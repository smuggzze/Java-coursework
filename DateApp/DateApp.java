/*
 * Name: Paige Ireland
 * Student number: 22032538
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DateApp{

    public static void main(String[] args) {
    List<String> argsList = new ArrayList<>(Arrays.stream(args).toList());
    List<String> argsListClone = new ArrayList<>(Arrays.stream(args).toList());

    int count = 0;
        for (String date : argsList) {
        if (date.contains(".txt")) {
            File file = new File(date);
            try {
                Scanner scanner = new Scanner(file);
                List<String> dates = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String entry = scanner.nextLine();
                    dates.add(entry);

                }
                scanner.close();
                SimpleDate[] theDates = Assignment1.test(dates);
                Assignment1.mostFrequentDayOfWeek(theDates);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            argsListClone.remove(date);

        }else {

            System.out.println(Assignment1.dayOfWeek(Assignment1.test(argsListClone)[count]));
        }


    }


}
}