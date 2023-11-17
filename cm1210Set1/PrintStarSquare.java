package javaStuff.cm1210Set1;

public class PrintStarSquare {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print("*");

            for (int x = 0; x < 9; x++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
