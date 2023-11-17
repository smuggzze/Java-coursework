/*
 * Name: Paige Ireland
 * Student number: 22032538
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExceptionHandler {

    private static final Integer[] monthsWith30Days = {3, 5, 8, 10};
    private static final Integer[] monthsWith31Days = {0, 2, 4, 6, 7, 9, 12};

    public static void main(String[] args){
    }


    public static Boolean dateHandler(int day, int month, int year){
        /**

         Determines whether a given date is valid based on the day, month, and year provided.
         @param day the day of the month (1-31)
         @param month the month of the year (1-12)
         @param year the year in question
         @return true if the date is valid, false otherwise
         */


        List<Integer> thirtyDays = Arrays.asList(monthsWith30Days);
        List<Integer> thirtyOneDays = Arrays.asList(monthsWith31Days);
        //doesn't work for years before 1753
        if (year >= 1753) {
            if (thirtyDays.contains(month)) {
                if ((day <= 30) && (day >= 0)) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }

            } else if (thirtyOneDays.contains(month)) {
                if ((day <= 31) && (day >= 0)) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }

            } else if ((month == 1)) { // February
                if ((day <= 28) && (day >= 0) && (leapYearFinder(year) == Boolean.FALSE)) {
                    return Boolean.TRUE;
                } else if ((day <= 29) && (day >= 0) && (leapYearFinder(year))) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } else {
                return Boolean.FALSE;
            }
        }else{
            return Boolean.FALSE;
        }

    }
    public static Integer suffixDetectorAndRemover(String part) {
        /**

         Detects and removes suffixes from a given string representation of a number.
         The method specifically checks for suffixes 'st', 'th' and 'rd' and removes them.
         If the input string does not contain any of the allowed suffixes, the method throws
         an IllegalArgumentException.
         @param part a string representation of a number with a possible suffix
         @return the integer value of the input string after removing the suffix
         @throws IllegalArgumentException if the input string does not contain any allowed suffixes
         */

        part = part.toLowerCase();
        String[] allowedSuffixes = {"st", "th", "rd"};
        String checker = part;
        String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
        String[] suffixComponents = {"s", "t", "r", "d", "h"};
        for (String number : numbers){
            if (checker.contains(number)){
                checker = checker.replace(number, ""); // re
            }
        }
        Boolean flag = Boolean.FALSE;
        for (String suffix : allowedSuffixes){
            if (checker.contains(suffix)){
                flag = Boolean.TRUE;
                break;
            }

        }
        if (!flag){
            throw new IllegalArgumentException(checker + " dates are suffixed with 'th', 'st' or 'rd' please make sure you amend your date to make it correct.");

        }
        for (String component : suffixComponents) {
            if (part.contains(component)) {
                part = part.replace(component, "");
            }
        }

        return Integer.parseInt(part);
    }

    public static boolean leapYearFinder(int year) {
        /**
         * Checks if a given year is a leap year or not.
         *
         * @param year the year to check
         * @return true if the year is a leap year, false otherwise
         */
        // If the year is divisible by 4
        if (year % 4 == 0) {
            // If the year is divisible by 100 but not divisible by 400
            if (year % 100 == 0 && year % 400 != 0) {
                return false; // Not a leap year
            } else {
                return true; // Leap year
            }
        } else {
            return false; // Not a leap year
        }
    }

    public static String[] dateSplitter(String date){
        /**
         * Splits a date string into an array of strings representing its parts.
         * Supports dates formatted as "dd/mm/yyyy" or "dd-mm-yyyy".
         *
         * @param date a string representing a date
         * @return an array of strings containing the date's parts
         *         (day, month, and year, in that order)
         */
        String[] dateParts;
        if (date.contains("/")) {
            dateParts = date.split("/");
            return dateParts;
        }
        else{
            dateParts = date.split("-");
            return dateParts;
        }
    }

}
