package javaStuff.cm1210Set1;

import java.util.Scanner;

public class InputRect {

    public static void main(String[] args) {

        Scanner dimensions = new Scanner( System.in);
        System.out.println("enter x for rect");
        int x = dimensions.nextInt();
        System.out.println("enter y for rect");
        int y = dimensions.nextInt();

        for (int i = 0; i < y; i++) {
            System.out.print("*");

            for (int j = 0; j < x - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
