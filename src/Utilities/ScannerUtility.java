package Utilities;

import TimeTypeTask.Task;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class ScannerUtility {

    public static final String TIME_FORMAT = "HH:mm";
    public static final String DATE_FORMAT = "dd.MM.y";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static Scanner scanner = new Scanner(System.in);

    public static String askString(String s) {
        System.out.println(s + ": ");
        return scanner.nextLine();
    }

    public static LocalTime askTime(String s) {
        System.out.println(s + TIME_FORMAT);
        var time = scanner.next();
        return LocalTime.parse(time, TIME_FORMATTER);
    }

    public static LocalDate askDate(String s) {
        System.out.println(s + DATE_FORMAT);
        var date = scanner.next();
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static int askInt(String s) {
        System.out.println(s + ": ");
        return scanner.nextInt();
    }

}
