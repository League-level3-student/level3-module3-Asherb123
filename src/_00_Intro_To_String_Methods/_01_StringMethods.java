package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;
		}

	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {

		if (s.contains("underscores")) {
			s = s.replaceAll(" ", "_");
		}

		return s;

	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {

		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();

		String[] split1 = s1.split(" ");
		String[] split2 = s2.split(" ");
		String[] split3 = s3.split(" ");

		// two before one
		if (split1[1].compareTo(split2[1]) > 0) {
			int twoVthree = split2[1].compareTo(split3[1]);

			// three before two
			if (twoVthree > 0) {
				return s3;
			} else {
				return s2;
			}
		}
		// one before two
		else if (split1[1].compareTo(split2[1]) < 0) {
			int oneVthree = split1[1].compareTo(split3[1]);

			if (oneVthree > 0) {
				// if three before one
				return s3;
			} else {
				return s1;
			}
		}

		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {

		int nums = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {

				nums = nums + ((int) s.charAt(i) - 48);
			}
		}

		return nums;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {

		int nonoword = 0;
		int index = s.indexOf(substring);
		while (index != -1) {

			nonoword = nonoword + 1;
			index = s.indexOf(substring, index + 1);

		}
		return nonoword;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {

		return Utilities.encrypt(s.getBytes(), (byte) key);

	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {

		return Utilities.decrypt(s, (byte) key);

	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {

		s = s.trim();
		String[] split = s.split(" ");
		int words = 0;
		for (int i = 0; i < split.length; i++) {
			if (split[i].endsWith(substring)) {

				words = words + 1;
			}
		}
		return words;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {

		//int distance = 0;

		s = s.trim();

		int start = s.indexOf(substring);
	int end = s.lastIndexOf(substring);	
		substring.length();
	
		
		
		
		return end-(start+ substring.length());
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		
		s=s.trim();
		s=s.replaceAll("\\.", "");
		s=s.replaceAll("\\?", "");
		s=s.replaceAll(",", "");
		s=s.replaceAll("-", "");
		s=s.replaceAll(" ", "");
		s=s.toLowerCase();
		s=s.replaceAll(":", "");
		
		String start = "";
		String end = "";
	if (s.length()%2==1) {
	

		for (int i = 0; i <= s.length()/2; i++) {
			start+=s.charAt(i);
			
		}
		for (int i = s.length()-1; i >= s.length()/2; i--) {
			end += s.charAt(i);
		}
	}		
	else {

		for (int i = 0; i < s.length()/2; i++) {
			start+=s.charAt(i);
			
		}
		for (int i = s.length()-1; i >= s.length()/2; i--) {
			end += s.charAt(i);
		}
	}
	
	System.out.println(start);
		System.out.println(end);
		
		
		if (start.equals(end)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
