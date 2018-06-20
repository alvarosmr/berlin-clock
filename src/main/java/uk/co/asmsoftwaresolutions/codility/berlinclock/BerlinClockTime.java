package uk.co.asmsoftwaresolutions.codility.berlinclock;

import com.google.common.base.Strings;

import java.time.LocalTime;
import java.util.Objects;

/**
 * A Berlin clock time immutable object representing the time as described on
 * https://en.wikipedia.org/wiki/Mengenlehreuhr.
 */
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

    /**
     * Static factory method to return a BerlinClockTime whose time is equivalent to that of the specified
     * {@code localTime}.
     *
     * @param localTime time of the Berlin clock time to return
     * @return a BerlinClockTime with the specified time
     */
    public static BerlinClockTime valueOf(LocalTime localTime) {
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();

        int lampsOnFiveHoursRow = hours / 5;
        int lampsOnSingleHoursRow = hours % 5;
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

    /**
     * Returns the string representation of this Berlin clock time. The string consists of 28 characters whose format
     * is "s HHHH hhhh MMMMMMMMMMM mmmm", where ('O' -> Off, 'Y' -> Yellow light, 'R' -> Red light):
     *
     *   - 's' represents the seconds lamp (if 'O' the lamp is off, if 'Y' the lamp is on)
     *   - 'HHHH' represents the lamps for the five hours row (if 'O' the lamp is off, if 'R' the lamp is on)
     *   - 'hhhh' represents the lamps for the single hours row (if 'O' the lamp is off, if 'R' the lamp is on)
     *   - 'MMMMMMMMMMM' represents the lamps for the five minutes row (if 'O' the lamp is off, if 'Y' or 'R' the lamp
     *      is on, 'R' is the color for 15, 30 and 45 minutes lamps)
     *   - 'mmmm' represents the lamps for the single minutes row (if 'O' the lamp is off, if 'Y' the lamp is on)
     *
     * Examples:
     *
     *   - Time 15:30:01 -> "O RRRO OOOO YYRYYROOOOO OOOO"
     *   - Time 23:59:59 -> "O RRRR RRRO YYRYYRYYRYY YYYY"
     *   - Time 00:00:00 -> "Y OOOO OOOO OOOOOOOOOOO OOOO"
     *   - Time 00:00:01 -> "O OOOO OOOO OOOOOOOOOOO OOOO"
     *   - Time 00:59:59 -> "O OOOO OOOO YYRYYRYYRYY YYYY"
     *   - Time 01:00:00 -> "Y OOOO ROOO OOOOOOOOOOO OOOO"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(28)
                .append(seconds % 2 == 0 ? 'Y' : 'O')
                .append(' ')
                .append(Strings.repeat("R", lampsOnFiveHoursRow))
                .append(Strings.repeat("O", 4 - lampsOnFiveHoursRow))
                .append(' ')
                .append(Strings.repeat("R", lampsOnSingleHoursRow))
                .append(Strings.repeat("O", 4 - lampsOnSingleHoursRow))
                .append(' ');

        for (int i = 0; i < lampsOnFiveMinutesRow; i++) {
            // 15, 30 or 45 minutes
            if (i == 2 || i == 5 || i == 8)
                builder.append('R');
            else
                builder.append('Y');
        }

        builder.append(Strings.repeat("O", 11 - lampsOnFiveMinutesRow))
                .append(' ')
                .append(Strings.repeat("Y", lampsOnSingleMinutesRow))
                .append(Strings.repeat("O", 4 - lampsOnSingleMinutesRow));

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        BerlinClockTime that = (BerlinClockTime) o;
        return seconds == that.seconds
                && lampsOnFiveHoursRow == that.lampsOnFiveHoursRow
                && lampsOnSingleHoursRow == that.lampsOnSingleHoursRow
                && lampsOnFiveMinutesRow == that.lampsOnFiveMinutesRow
                && lampsOnSingleMinutesRow == that.lampsOnSingleMinutesRow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                seconds, lampsOnFiveHoursRow, lampsOnSingleHoursRow, lampsOnFiveMinutesRow, lampsOnSingleMinutesRow);
    }
}
