// package import missing
package javaStuff.cm1210Set1;

import java.util.Scanner;

public class RewriteNumber {
	public static void main( String args[] ) {
	    Scanner in = new Scanner( System.in );

	    System.out.println( "Enter an integer between 0 and 9" );
	    int num = in.nextInt();
	    String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	    System.out.println( "You entered " + numbers[num - 1] );
	}
}
