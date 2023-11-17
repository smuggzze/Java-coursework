/*
 * Name: Paige Ireland
 * Student number: 22032538
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Assignment1 {


    private static final String[] dayString = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};

    private static final String[] Months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
  



    public static void main(String[] args) {

//        args = new String[]{"C:\\Users\\3this\\OneDrive\\Code\\javaStuff\\DateApp\\src\\dates.txt", "1/2/2022"};
//        args = new String[]{"25/3/2023"};
    }

    public static SimpleDate[] test(List<String> dates){
        int cmdLineDay;
        int cmdLineMonth = 0;
        int cmdLineYear;
        String[] dateParts;
        List<SimpleDate> simpDateList = new ArrayList<SimpleDate>();
        int count = 0;
        for (String date : dates) {
            if (date.contains("/") || date.contains("-")) {
                dateParts = ExceptionHandler.dateSplitter(date);
                cmdLineDay = Integer.parseInt(dateParts[0]);
                cmdLineMonth = Integer.parseInt(dateParts[1]);
                cmdLineYear = Integer.parseInt(dateParts[2]);
                SimpleDate nextDate = new SimpleDate(cmdLineYear, cmdLineMonth, cmdLineDay);
                if (ExceptionHandler.dateHandler(cmdLineDay, cmdLineMonth, cmdLineYear).equals(Boolean.TRUE)) {
                    simpDateList.add(nextDate);

                }
                else{
                    throw new IllegalArgumentException(simpDateList.get(count-1).toString() + " day, month, or year are out of bounds. year must be above 1753, days and months are to be kept to valid dates.");
                }
            } else {
                dateParts = date.split(" ");
                cmdLineDay = ExceptionHandler.suffixDetectorAndRemover(dateParts[0]);
                List<String> monthList = Arrays.asList(Months);

                if (monthList.contains(dateParts[1].toLowerCase())){
                    cmdLineMonth = monthList.indexOf(dateParts[1].toLowerCase()) + 1;
                }
                else{
                    throw new IllegalArgumentException(cmdLineMonth + "month must be English and the full name of month");
                }
                cmdLineYear = Integer.parseInt(dateParts[2]);
                SimpleDate nextDate = new SimpleDate(cmdLineYear, cmdLineMonth, cmdLineDay);
                if (ExceptionHandler.dateHandler(cmdLineDay, cmdLineMonth, cmdLineYear).equals(Boolean.TRUE)) {
                    simpDateList.add(nextDate);
                }else{
                    throw new IllegalArgumentException(simpDateList.get(count-1).toString() + "day, month, or year are out of bounds. year must be above 1753, days and months are to be kept to valid dates.");
                }
            }
            count++;
        }
        SimpleDate[] simpleDates = simpDateList.toArray(new SimpleDate[simpDateList.size()]);
        return simpleDates;
    }

    public static String printDates (List<String> listOfDates) {
        SimpleDate[] dates = test(listOfDates);

        return mostFrequentDayOfWeek(dates);
    }

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


    public static int countDatesOnDay( SimpleDate[] dates, String dayOfWeek ) {
        int count = 0;
        for (SimpleDate simpleDate : dates) {
            String day = dayOfWeek(simpleDate);
            if (Objects.equals(day, dayOfWeek)) {
                count += 1;
            }

        }
        return count;
    }


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
            // convert List tieIndexes to String

            for (Integer i : tieIndexes){
                mostFrequentDays.add(Integer.toString(i));
            }

            //change numbers to names of dates
            for (int i = 0; i < mostFrequentDays.size(); i++){

                mostFrequentDays.set(i, datePreference[tieIndexes.get(i)]);
            }

            // find the earliest day in week

            return mostFrequentDays.get(0);

        }
    }




}

