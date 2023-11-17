/*
 * Name: Paige Ireland
 * Student number: 22032538
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.List;


public class Assignment1 {


    private static final String[] dayString = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};

    /*
     * A method to find the day-of-week for a date.
     *
     * Arguments:
     * `date` -- the SimpleDate for which the day-of-week is to be found. dd/mm/yyyy
     *
     * Return value:
     * A String representing the day of week. The day of week should be
     * expressed as a three-letter abbreviation; in other words, this method
     * returns one of:
     *   "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
     */
    public static String dayOfWeek( SimpleDate date ) {
        // TO BE COMPLETED
        int d = date.getDay();
        int m = date.getMonth();
        int y = date.getYear();
        if (m < 3){
            m += 12;
            y -= 1;
        }

        int D = (y / 100);
        int C = (y % 100);



        int W = ((13 * (m + 1) / 5));
        int X = C / 4;
        int Y = D / 4;
        int Z = W + X + Y + d + C - 2 * D;
        int day = Z % 7;
        if (day < 0) {
            day += 7;
        }

        return dayString[day];
    }

    /*
     * Given a set of dates, this method will count the number of dates in the
     * set that fall on a particular day-of-week.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     * `dayOfWeek` -- a String representing the day of week ("Mon" to "Sun")
     *
     * Return value:
     * An integer giving the number of dates that fell on `dayOfWeek`.
     */
    public static int countDatesOnDay( SimpleDate[] dates, String dayOfWeek ) {
        // TO BE COMPLETED
        int count = 0;
        for (SimpleDate simpleDate : dates) {
            String day = dayOfWeek(simpleDate);
            if (Objects.equals(day, dayOfWeek)) {
                count += 1;
            }

        }
        return count;
    }

    /*
     * A method to find the most frequent day-of-week among a collection of
     * dates.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     *
     * Return value:
     * If the array `dates` is empty, then this method should return the null
     * reference. Otherwise, the method should return the three-letter
     * abbreviation ("Mon", "Tue", etc.) of the day-of-week that was most
     * frequent.
     * In the case that there is a tie for the most-frequent day-of-week,
     * priority should be given to the day-of-week that comes earliest in the
     * week. (For this method, "Mon" is assumed to be the first day of the
     * week.)
     * For example, if there were a tie between Tuesday, Wednesday, and Sunday,
     * the method should return "Tue".
     */
    public static String mostFrequentDayOfWeek( SimpleDate[] dates ) {

        int[] frequencies = new int[dayString.length];
        int largest = frequencies[0];
        int count = 0;
        int counter = 0;
        String[] datePreference = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        List<Integer> frequenciesList = new java.util.ArrayList<>();
        List<Integer> tieIndexes = new java.util.ArrayList<>();
        List<String> mostFrequentDays = new java.util.ArrayList<>();

        if( dates == null ) {
            return null;
        }

        else {
            for(String day : dayString) {
                // frequencies is the array of the times the date is on a certain day saturday - friday
                frequencies[count] = countDatesOnDay(dates, day);
                count ++;
            }

            for (int frequency : frequencies) {
                // turn frequencies into list for methods
                frequenciesList.add(frequency);
                // find most frequent day
                if (frequency > largest) {
                    largest = frequency;

                }
            }

            // tie checker

            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] == largest){
                    tieIndexes.add(i);
//                    System.out.println(tieIndexes);
                }
            }
            //set count to 0 to use again in this loop
            count = 0;
            //make items in tieIndexes correspond to mon-sun rather than sat - fri
            for (int i : tieIndexes) {
                if (i == 0){
                    tieIndexes.set(count, 5);
                }
                if (i == 1){
                    tieIndexes.set(count, 6);
                }
                if (i == 2){
                    tieIndexes.set(count, 0);
                }
                if (i == 3){
                    tieIndexes.set(count, 1);
                }
                if (i == 4){
                    tieIndexes.set(count, 2);
                }
                if (i == 5){
                    tieIndexes.set(count, 3);
                }
                if (i == 6){
                    tieIndexes.set(count, 4);
                }
                count ++;

            }
            //sort tie indexes for later selection
            Collections.sort(tieIndexes);
//            System.out.println(tieIndexes);
            // convert List tieIndexes to String

            for (Integer i : tieIndexes){
                mostFrequentDays.add(Integer.toString(i));
            }

            //change numbers to names of dates
            for (int i = 0; i < mostFrequentDays.size(); i++){

                mostFrequentDays.set(i, datePreference[tieIndexes.get(i)]);
            }
//            System.out.println(mostFrequentDays);

            // find the earliest day in week

            //            System.out.println(firstMostCommonDate);
            return mostFrequentDays.get(0);

        }
    }




}