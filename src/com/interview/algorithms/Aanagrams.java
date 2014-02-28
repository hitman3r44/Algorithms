package com.interview.algorithms;

public class Aanagrams {
	public static void main(String[] args) {
		System.out.println(anagram("cat", "cat"));

	}

	public static boolean anagram(String s, String t) {
		return sort(s).equals(sort(t));
	}

	private static String sort(String str) {
		char temp;
		int in;
		int length = str.length();

		// start the outer loop at 1 so would be compared with previous 0
		for (int out = 1; out < length; out++) {
			temp = str.charAt(out); // copy into temp , later insert at the
									// correct empty position
			in = out;
			while (in > 0 && str.charAt(in - 1) >= temp) {
				// shift the elements if they are greater than temp
				str = str.replace(str.charAt(in), str.charAt(in - 1));
				--in;
			}
			// insert at the correct empty position after all shifts done

			str = str.replace(str.charAt(in), str.charAt(out));
		}
		
		System.out.println(str);
		return str;

	}

}
