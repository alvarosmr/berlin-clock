Berlin Clock
=============

Simple application to make usage of the BerlinClockTime class. The user can introduce hours, minutes and seconds
in the command line and the application will use the BerlinClockTime to return a string representation of the
Berlin clock time described on https://en.wikipedia.org/wiki/Mengenlehreuhr.

The string representation of the Berlin clock time consists of 28 characters whose format is 
"s HHHH hhhh MMMMMMMMMMM mmmm", where ('O' -> Off, 'Y' -> Yellow light, 'R' -> Red light):
     
     - 's' represents the seconds lamp (if 'O' the lamp is off, if 'Y' the lamp is on)
     - 'HHHH' represents the lamps for the five hours row (if 'O' the lamp is off, if 'R' the lamp is on)
     - 'hhhh' represents the lamps for the single hours row (if 'O' the lamp is off, if 'R' the lamp is on)
     - 'MMMMMMMMMMM' represents the lamps for the five minutes row (if 'O' the lamp is off, if 'Y' or 'R' the lamp
        is on, 'R' is the color for 15, 30 and 45 minutes lamps)
     - 'mmmm' represents the lamps for the single minutes row (if 'O' the lamp is off, if 'Y' the lamp is on)
     
Examples:

     - Time 15:30:01 -> "O RRRO OOOO YYRYYROOOOO OOOO"
     - Time 23:59:59 -> "O RRRR RRRO YYRYYRYYRYY YYYY"
     - Time 00:00:00 -> "Y RRRR RRRR OOOOOOOOOOO OOOO"
     - Time 00:00:01 -> "O RRRR RRRR OOOOOOOOOOO OOOO"
     - Time 00:59:59 -> "O RRRR RRRR YYRYYRYYRYY YYYY"
     - Time 01:00:00 -> "Y OOOO ROOO OOOOOOOOOOO OOOO"

## Dependencies

 * Java 8
 * Maven 3.5.x

## Build 

```mvn package```

## Run

```
java -jar target/berlin-clock-<VERSION>.jar
```