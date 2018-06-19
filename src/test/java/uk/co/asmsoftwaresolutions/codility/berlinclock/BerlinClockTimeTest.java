package uk.co.asmsoftwaresolutions.codility.berlinclock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BerlinClockTimeTest {

    @DisplayName("Testing single minutes row when factory method valueOf is called")
    @ParameterizedTest(name = "Time with \"{0}\" minute/s should show \"{1}\" lamp/s on in the single minutes row")
    @CsvSource({
            "0, 0", "1, 1", "2, 2", "3, 3", "4, 4", "5, 0", "6, 1", "7, 2", "8, 3", "9, 4",
            "10, 0", "11, 1", "12, 2", "13, 3", "14, 4", "15, 0", "16, 1", "17, 2", "18, 3", "19, 4",
            "20, 0", "21, 1", "22, 2", "23, 3", "24, 4", "25, 0", "26, 1", "27, 2", "28, 3", "29, 4",
            "30, 0", "31, 1", "32, 2", "33, 3", "34, 4", "35, 0", "36, 1", "37, 2", "38, 3", "39, 4",
            "40, 0", "41, 1", "42, 2", "43, 3", "44, 4", "45, 0", "46, 1", "47, 2", "48, 3", "49, 4",
            "50, 0", "51, 1", "52, 2", "53, 3", "54, 4", "55, 0", "56, 1", "57, 2", "58, 3", "59, 4"
    })
    void when_TimeIsGiven_expect_CorrectLampsOnSingleMinutesRow(int minutes, int expectedLampsOn) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.of(0, Integer.valueOf(minutes), 0));

        assertEquals(expectedLampsOn, result.getLampsOnSingleMinutesRow(),
                "Wrong number of lamps on in the single minutes row (expected " + expectedLampsOn + " for " + minutes
                        + " minutes)");
    }

    @DisplayName("Testing five minutes row when factory method valueOf is called")
    @ParameterizedTest(name = "Time with \"{0}\" minute/s should show \"{1}\" lamp/s on in the five minutes row")
    @CsvSource({
            "0, 0", "1, 0", "2, 0", "3, 0", "4, 0", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1",
            "10, 2", "11, 2", "12, 2", "13, 2", "14, 2", "15, 3", "16, 3", "17, 3", "18, 3", "19, 3",
            "20, 4", "21, 4", "22, 4", "23, 4", "24, 4", "25, 5", "26, 5", "27, 5", "28, 5", "29, 5",
            "30, 6", "31, 6", "32, 6", "33, 6", "34, 6", "35, 7", "36, 7", "37, 7", "38, 7", "39, 7",
            "40, 8", "41, 8", "42, 8", "43, 8", "44, 8", "45, 9", "46, 9", "47, 9", "48, 9", "49, 9",
            "50, 10", "51, 10", "52, 10", "53, 10", "54, 10", "55, 11", "56, 11", "57, 11", "58, 11", "59, 11"
    })
    void when_TimeIsGiven_expect_CorrectLampsOnFiveMinutesRow(int minutes, int expectedLampsOn) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.of(0, Integer.valueOf(minutes), 0));

        assertEquals(expectedLampsOn, result.getLampsOnFiveMinutesRow(),
                "Wrong number of lamps on in the five minutes row (expected " + expectedLampsOn + " for " + minutes
                        + " minutes)");
    }

    @DisplayName("Testing single hours row when factory method valueOf is called")
    @ParameterizedTest(name = "Time with \"{0}\" hour/s should show \"{1}\" lamp/s on in the single hours row")
    @CsvSource({
            "0, 4", "1, 1", "2, 2", "3, 3", "4, 4", "5, 0", "6, 1", "7, 2", "8, 3", "9, 4", "10, 0", "11, 1", "12, 2",
            "13, 3", "14, 4", "15, 0", "16, 1", "17, 2", "18, 3", "19, 4", "20, 0", "21, 1", "22, 2", "23, 3"
    })
    void when_TimeIsGiven_expect_CorrectLampsOnSingleHoursRow(int hours, int expectedLampsOn) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.of(Integer.valueOf(hours), 0, 0));

        assertEquals(expectedLampsOn, result.getLampsOnSingleHoursRow(),
                "Wrong number of lamps on in the single hours row (expected " + expectedLampsOn + " for " + hours
                        + " hours)");
    }

    @DisplayName("Testing five hours row when factory method valueOf is called")
    @ParameterizedTest(name = "Time with \"{0}\" hour/s should show \"{1}\" lamp/s on in the five hours row")
    @CsvSource({
            "0, 4", "1, 0", "2, 0", "3, 0", "4, 0", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1", "10, 2", "11, 2", "12, 2",
            "13, 2", "14, 2", "15, 3", "16, 3", "17, 3", "18, 3", "19, 3", "20, 4", "21, 4", "22, 4", "23, 4"
    })
    void when_TimeIsGiven_expect_CorrectLampsOnFiveHoursRow(int hours, int expectedLampsOn) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.of(Integer.valueOf(hours), 0, 0));

        assertEquals(expectedLampsOn, result.getLampsOnFiveHoursRow(),
                "Wrong number of lamps on in the five hours row (expected " + expectedLampsOn + " for " + hours
                        + " hours)");
    }

    @DisplayName("Testing seconds when factory method valueOf is called")
    @ParameterizedTest(name = "Time with \"{0}\" second/s should show \"{1}\" seconds")
    @CsvSource({
            "0, 0", "1, 1", "2, 2", "3, 3", "4, 4", "5, 5", "6, 6", "7, 7", "8, 8", "9, 9",
            "10, 10", "11, 11", "12, 12", "13, 13", "14, 14", "15, 15", "16, 16", "17, 17", "18, 18", "19, 19",
            "20, 20", "21, 21", "22, 22", "23, 23", "24, 24", "25, 25", "26, 26", "27, 27", "28, 28", "29, 29",
            "30, 30", "31, 31", "32, 32", "33, 33", "34, 34", "35, 35", "36, 36", "37, 37", "38, 38", "39, 39",
            "40, 40", "41, 41", "42, 42", "43, 43", "44, 44", "45, 45", "46, 46", "47, 47", "48, 48", "49, 49",
            "50, 50", "51, 51", "52, 52", "53, 53", "54, 54", "55, 55", "56, 56", "57, 57", "58, 58", "59, 59"
    })
    void when_TimeIsGiven_expect_CorrectNumberOfSeconds(int seconds, int expectedSeconds) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.of(0, 0, Integer.valueOf(seconds)));

        assertEquals(expectedSeconds, result.getSeconds(), "Wrong number of seconds");
    }

    @DisplayName("Testing string representation of Berlin clock time")
    @ParameterizedTest(name = "String representation of \"{0}\" should be \"{1}\"")
    @CsvSource({
            "15:30:01, O RRRO OOOO YYRYYROOOOO OOOO",
            "23:59:59, O RRRR RRRO YYRYYRYYRYY YYYY",
            "00:00:00, Y RRRR RRRR OOOOOOOOOOO OOOO",
            "00:00:01, O RRRR RRRR OOOOOOOOOOO OOOO",
            "00:59:59, O RRRR RRRR YYRYYRYYRYY YYYY",
            "01:00:00, Y OOOO ROOO OOOOOOOOOOO OOOO"
    })
    void when_toStringIsCalled_expect_CorrectStringRepresentation(String localTime, String expectedString) {
        BerlinClockTime result = BerlinClockTime.valueOf(LocalTime.parse(localTime));

        assertEquals(expectedString, result.toString(), "Wrong Berlin clock time string representation for the time "
                + localTime);
    }
}