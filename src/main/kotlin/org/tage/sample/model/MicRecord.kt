package org.tage.sample.model

import OS

/**
 * "COUNTRY","ISO COUNTRY CODE (ISO 3166)","MIC","OPERATING MIC","O/S",
 * "NAME-INSTITUTION DESCRIPTION","ACRONYM","CITY","WEBSITE","STATUS DATE",
 * "STATUS","CREATION DATE","COMMENTS"
 */
data class MicRecord(
    val mic: String, val operatingMic: String,
    val acronym: String?,
    val country: Country, val os: OS, val status: String, val website: String
) {
    object RowStructure {
        val COUNTRY = 0
        val ISO = 1
        val MIC = 2
        val OP_MIC = 3
        val OS = 4
        val NAME = 5
        val ACRONYM = 6
        val CITY = 7
        val WEBSITE = 8
        val STATUS_DATE = 9
        val STATUS = 10
        val CREATION_DATE = 11
        val COMMENTS = 12
    }
}
