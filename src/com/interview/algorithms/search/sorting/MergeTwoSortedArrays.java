package com.interview.algorithms.search.sorting;

import java.util.Arrays;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order
 * 
 * @author ajitkoti
 *
 */
public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int big[] = new int[20];
		int small[] = new int[] { 5, 10, 20, 30, 40 };

		for (int i = 0; i < 15; i++) {
			big[i] = i;

		}
		printArray(big);
		System.out.println();

		printArray(small);
		System.out.println();

		merge(big, small, 15, 5);

		printArray(big);

	}
	
	public static void printArray(int a[]){	
			System.out.println(Arrays.toString(a));
	}

	public static void merge(int[] big, int[] small, int bigLastElem,int smallLastElem) {

		int totalIndex = smallLastElem + bigLastElem - 1; // Index of last location of array													// big
		int bigIndex = bigLastElem - 1; // Index of last element in array big
		int smallIndex = smallLastElem - 1; // Index of last element in array small

		// Start comparing from the last element and merge a and b
		while (bigIndex >= 0 && smallIndex >= 0) {
			if (big[bigIndex] > small[smallIndex]) {
				big[totalIndex--] = big[bigIndex--];
				printArray(big);
			} else {
				big[totalIndex--] = small[smallIndex--];
				printArray(big);
			}
		}

		while (smallIndex >= 0) {
			big[totalIndex--] = small[smallIndex--];
		}
	}
}
