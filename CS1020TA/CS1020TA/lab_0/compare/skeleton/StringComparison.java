/**
 *
 * author	: [Diga Widyaprana]
 * matric no: [A0114171W]
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables
        String str1, str2;

		// declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
        str1 = sc.next();
        str2 = sc.next();

        int res = str1.compareTo(str2);

        System.out.println(res < 0 ? 1 : res > 0 ? 2 : 0);
	}
}
