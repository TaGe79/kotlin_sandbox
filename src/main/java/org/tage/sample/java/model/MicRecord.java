package org.tage.sample.java.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 */
public class MicRecord {
    private final String mic;
    private final String operatingMic;
    private final String acronym;
    private final Country country;
    private final OS os;
    private final String status;
    private final String website;

    public MicRecord(@NotNull String mic, @NotNull String operatingMic, @NotNull String acronym, @NotNull Country country, @NotNull OS os, @NotNull String status, @NotNull String website) {
        this.mic = Objects.requireNonNull(mic);
        this.operatingMic = Objects.requireNonNull(operatingMic);
        this.acronym = Objects.requireNonNull(acronym);
        this.country = Objects.requireNonNull(country);
        this.os = Objects.requireNonNull(os);
        this.status = Objects.requireNonNull(status);
        this.website = Objects.requireNonNull(website);
    }

    @NotNull
    public final String getMic() {
        return this.mic;
    }

    @NotNull
    public final String getOperatingMic() {
        return this.operatingMic;
    }

    @NotNull
    public final String getAcronym() {
        return this.acronym;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    @NotNull
    public final OS getOs() {
        return this.os;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getWebsite() {
        return this.website;
    }

    @NotNull
    public String toString() {
        return "MicRecord(mic=" + this.mic + ", operatingMic=" + this.operatingMic + ", acronym=" + this.acronym + ", country=" + this.country + ", os=" + this.os + ", status=" + this.status + ", website=" + this.website + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MicRecord)) return false;
        MicRecord that = (MicRecord) o;
        return Objects.equals(mic, that.mic) &&
                Objects.equals(operatingMic, that.operatingMic) &&
                Objects.equals(acronym, that.acronym) &&
                Objects.equals(country, that.country) &&
                os == that.os &&
                Objects.equals(status, that.status) &&
                Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mic, operatingMic, acronym, country, os, status, website);
    }

    public static final class RowStructure {
        private static final int COUNTRY = 0;
        private static final int ISO = 1;
        private static final int MIC = 2;
        private static final int OP_MIC = 3;
        private static final int OS = 4;
        private static final int NAME = 5;
        private static final int ACRONYM = 6;
        private static final int CITY = 7;
        private static final int WEBSITE = 8;
        private static final int STATUS_DATE = 9;
        private static final int STATUS = 10;
        private static final int CREATION_DATE = 11;
        private static final int COMMENTS = 12;
    }
}


