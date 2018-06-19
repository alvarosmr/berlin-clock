package uk.co.asmsoftwaresolutions.codility.berlinclock;

import java.time.LocalTime;

public final class BerlinClockTime {

    private final byte seconds;
    private final byte lampsOnFiveHoursRow;
    private final byte lampsOnSingleHoursRow;
    private final byte lampsOnFiveMinutesRow;
    private final byte lampsOnSingleMinutesRow;

    private BerlinClockTime(
            int seconds,
            int lampsOnFiveHoursRow,
            int lampsOnSingleHoursRow,
            int lampsOnFiveMinutesRow,
            int lampsOnSingleMinutesRow)
    {
        this.seconds = (byte) seconds;
        this.lampsOnFiveHoursRow = (byte) lampsOnFiveHoursRow;
        this.lampsOnSingleHoursRow = (byte) lampsOnSingleHoursRow;
        this.lampsOnFiveMinutesRow = (byte) lampsOnFiveMinutesRow;
        this.lampsOnSingleMinutesRow = (byte) lampsOnSingleMinutesRow;
    }

    public static BerlinClockTime valueOf(LocalTime localTime) {
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();

        // Zero hours in LocalTime is represented by all the lamps on in the hours rows of the Berlin Clock
        int lampsOnFiveHoursRow = hours == 0 ? 4 : hours / 5;
        int lampsOnSingleHoursRow = hours == 0 ? 4 : hours % 5;
        int lampsOnFiveMinutesRow = minutes / 5;
        int lampsOnSingleMinutesRow = minutes % 5;

        return new BerlinClockTime(
                localTime.getSecond(),
                lampsOnFiveHoursRow,
                lampsOnSingleHoursRow,
                lampsOnFiveMinutesRow,
                lampsOnSingleMinutesRow);
    }

    public byte getSeconds() {
        return seconds;
    }

    public byte getLampsOnFiveHoursRow() {
        return lampsOnFiveHoursRow;
    }

    public byte getLampsOnSingleHoursRow() {
        return lampsOnSingleHoursRow;
    }

    public byte getLampsOnFiveMinutesRow() {
        return lampsOnFiveMinutesRow;
    }

    public int getLampsOnSingleMinutesRow() {
        return lampsOnSingleMinutesRow;
    }
}
