package uk.co.asmsoftwaresolutions.codility.berlinclock;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * Simple application to make usage of the BerlinClockTime class. The user can introduce hours, minutes and seconds
 * in the command line and the application will use the BerlinClockTime to return a string representation of the
 * Berlin clock time described on https://en.wikipedia.org/wiki/Mengenlehreuhr.
 */
public class BerlinClockApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hours [0-23]: ");
        int hours = scanner.nextInt();
        System.out.print("Minutes [0-59]: ");
        int minutes = scanner.nextInt();
        System.out.print("Seconds [0-59]: ");
        int seconds = scanner.nextInt();

        LocalTime localTime = LocalTime.of(hours, minutes, seconds);
        BerlinClockTime berlinClockTime = BerlinClockTime.valueOf(localTime);
        System.out.printf("The berlin clock time string representation of the time [%s] is [%s]\n", localTime,
                berlinClockTime.toString());
    }
}
