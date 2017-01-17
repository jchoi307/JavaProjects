/**
 * CS 2110 Spring 2016 HW2
 * Part 1 - Coding with bases
 * 
 * @author Joon Gyu Choi
 *
 * Global rules for this file:
 * - You may not use more than 2 conditionals per method. Conditionals are
 *   if-statements, if-else statements, or ternary expressions. The else block
 *   associated with an if-statement does not count toward this sum.
 * - You may not use more than 2 looping constructs per method. Looping
 *   constructs include for loops, while loops and do-while loops.
 * - You may not use nested loops.
 * - You may not declare any file-level variables.
 * - You may not declare any objects, other than String in select methods.
 * - You may not use switch statements.
 * - You may not use the unsigned right shift operator (>>>)
 * - You may not write any helper methods, or call any other method from this or
 *   another file to implement any method.
 * - The only Java API methods you are allowed to invoke are:
 *     String.length()
 *     String.charAt()
 *     String.equals()
 * - You may not invoke the above methods from string literals.
 *     Example: "12345".length()
 * - When concatenating numbers with Strings, you may only do so if the number
 *   is a single digit.
 *
 * Method-specific rules for this file:
 * - You may not use multiplication, division or modulus in any method, EXCEPT
 *   strdtoi.
 * - You may declare exactly one String variable each in itostrb, and itostrx.
 */
public class HW2Bases
{
	/**
	 * strdtoi - Decimal String to int
	 *
	 * Convert a string containing ASCII characters (in decimal) to an int.
	 * You do not need to handle negative numbers. The Strings we will pass in will be
	 * valid decimal numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strdtoi("123"); // => 123
	 */
	public static int strdtoi(String decimal) {
		/*
		 * Just a basic concept of converting numbers from string to int.
		 * The only important thing is understand the ASCII,
		 * which is 48 for number start (0) and 65 for character start (A).
		 */
		final int ASCII = 48;
		int result = 0;
		for (int i = 0; i < decimal.length(); i++) {
			result = result * 10 + decimal.charAt(i) - ASCII;
		}
		return result;
	}

	/**
	 * strbtoi - Binary String to int
	 *
	 * Convert a string containing ASCII characters (in binary) to an int.
	 * You do not need to handle negative numbers. The Strings we will pass in will be
	 * valid binary numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strbtoi("111"); // => 7
	 */
	public static int strbtoi(String binary) {
		/*
		 * Same a basic concept of converting numbers from string to int,
		 * but have to know how to convert numbers from binary to int,
		 * without using formal operators like (*, /, %).
		 * Also the important thing is understand the ASCII,
		 * which is 48 for number start (0) and 65 for character start (A).
		 */
		final int ASCII = 48;
		int result = 0;
		for (int i = 0; i < binary.length(); i++) {
			result += result + binary.charAt(i) - ASCII;
		}
		return result;
	}

	/**
	 * strxtoi - Hexadecimal String to int
	 *
	 * Convert a string containing ASCII characters (in hex) to an int.
	 * The input string will only contain numbers and uppercase letters A-F.
	 * You do not need to handle negative numbers. The Strings we will pass in will be
	 * valid hexadecimal numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strxtoi("A6"); // => 166
	 */
	public static int strxtoi(String hex) {
		/*
		 * Same a basic concept of converting numbers from string to int,
		 * but have to know how to convert numbers from hex to int,
		 * without using formal operators like (*, /, %).
		 * Also the important thing is understand the ASCII,
		 * which is 48 for number start (0) and 65 for character start (A).
		 */
		final int ASCII_num = 48;
		final int ASCII_char = 65;
		int result = 0;
		for (int i = 0; i < hex.length(); i++) {
			result = result << 4;
			if (hex.charAt(i) >= ASCII_char) {
				result += hex.charAt(i) - ASCII_char + 10;
			} else {
				result += hex.charAt(i) - ASCII_num;
			}
		}
		return result;
	}

	/**
	 * itostrb - int to Binary String
	 *
	 * Convert a int into a String containing ASCII characters (in binary).
	 * You do not need to handle negative numbers.
	 * The String returned should contain the minimum number of characters necessary to
	 * represent the number that was passed in.
	 * 
	 * Example: itostrb(7); // => "111"
	 */
	public static String itostrb(int binary) {
		/*
		 * Simple calculation to keep dividing by 2 from original number,
		 * and get remainder to add up to the result in right spot,
		 * until the original number become zero.
		 */
		final int ASCII = 48;
		String result = "";
		int i = binary;
		for ( ; i >= 2; i = i >> 1) {
			result = (char) ((i & 1) + ASCII) + result;
		}
		result = i + result;
		return result;
	}

	/**
	 * itostrx - int to Hexadecimal String
	 *
	 * Convert a int into a String containing ASCII characters (in hexadecimal).
	 * The output string should only contain numbers and uppercase letters A-F.
	 * You do not need to handle negative numbers.
	 * The String returned should contain the minimum number of characters necessary to
	 * represent the number that was passed in.
	 * 
	 * Example: itostrx(166); // => "A6"
	 */
	public static String itostrx(int hex) {
		/*
		 * Basically same as above calculation,
		 * to keep dividing by 16 from original number,
		 * and get remainder to add up to the result in right spot,
		 * until the original number become zero.
		 * However, in this method, since the hex range is to 16,
		 * the ASCII code's first 6 character (10~15) looks not work properly,
		 * so I had to search the remainders upper than 9 has more step to get result.
		 */

		final int ASCII_char = 65;
		String result = "";
		int remain;
		int i = hex;
		for ( ; i >= 16; i = i >> 4) {
			remain = i & 15;
			if (remain >= 10) {
				result = (char) (ASCII_char + (remain - 10)) + result;
			} else {
				result = remain + result;
			}
		}
		if (i >= 10) {
			result = (char) (ASCII_char + (i - 10)) + result;
		} else {
			result = i + result;
		}
		return result;
	}
}
