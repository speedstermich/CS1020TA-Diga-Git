/*
 * author		: [Diga Widyaprana]
 * matric no.	: [A0114171W]
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  :
	 * 		POST-Condition :
	 */
	// public static boolean isPalindrome(String word) {

	// }
	
	public static void main(String[] args) {
		// declare the necessary variables
		String str1;
		String str2;
		int strLength;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		str1 = sc.next();
		str2 = sc.next();
		strLength = str1.length();

		// simulate the problem
		boolean isPalindrome = true;

		for (int i = 0; i < strLength; i++) {
			if (str1.charAt(i) != str2.charAt(strLength - i - 1)) {
				isPalindrome = false;
				break;
			}
		}

		// output the result
		System.out.println(isPalindrome ? "YES" : "NO");
	}
}