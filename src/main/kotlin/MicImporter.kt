import org.tage.sample.model.Country
import org.tage.sample.model.MicRecord
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import kotlin.streams.toList

enum class OS {
    O,
    S
}

/**
 *
 */
class MicImporter(csvFileUrl: URL) {
    private fun MicRecord.insert(table: String): String = "INSERT INTO $table (MIC,OP_MIC,ACRONYM,COUNTRY_ISO,STATUS,WEBSITE) VALUES ('$mic', '$operatingMic', ${if ( acronym == null ) "null" else "'$mic'"}, '${country.isoCode}', '$status', '$website')"

    companion object {
        val SPLITTER = "(\"[^\"]*\")|,,".toRegex()
    }

    val records: List<MicRecord> =
        BufferedReader(InputStreamReader(csvFileUrl.openStream())).use { reader ->
            reader.lines().skip(1)
                .map { line -> SPLITTER.findAll(line).map { it.value.trim('"', ',') }.toList() }
                .map {
                    MicRecord(
                        it[MicRecord.RowStructure.MIC],
                        it[MicRecord.RowStructure.OP_MIC],
                        if (it[MicRecord.RowStructure.ACRONYM].isNotEmpty()) it[MicRecord.RowStructure.ACRONYM] else null,
                        Country(
                            it[MicRecord.RowStructure.COUNTRY],
                            it[MicRecord.RowStructure.ISO]
                        ),
                        OS.valueOf(it[MicRecord.RowStructure.OS]),
                        it[MicRecord.RowStructure.STATUS],
                        it[MicRecord.RowStructure.WEBSITE]
                    )
                }
                .toList()
        }

    fun print() {
        records.forEach { println(it) }
    }

    fun countries(): Set<Country> = records.groupBy { it.country }.keys

    fun insertStatements() : List<String> {
        return records.map { it.insert("MIC") }
    }
}



fun main(args: Array<String>) {
    val micImporter = MicImporter(URL(args[0]))
    micImporter.print()

    micImporter.countries()
        .also { println("COUNTRIES: ${it.size}") }
        .forEach { println(it) }

    val inserts = micImporter.insertStatements()

    inserts.forEach { println(it) }
}
