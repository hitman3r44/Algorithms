package com.interview.algorithms.array;

import java.util.Arrays;

//http://geeksforgeeks.org/?p=2105
/**
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find
 * the median of the array obtained after merging the above 2 arrays(i.e. array
 * of length 2n). The complexity should be O(log(n))
 * 
 * @author ajitkoti
 * 
 */
public class MedianOfTwoSortedArrays {

	public static int getMedian(int arr1[], int arr2[]) {
		int medainOfTwoArrays = -1;
		if(arr1.length == arr2.length){
		medainOfTwoArrays = getMedianRec(arr1, arr2,arr1.length);
		}
		return medainOfTwoArrays;

	}

	private static int getMedianRec(int[] arr1, int[] arr2, int length) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		int arr1[] = new int[]{1,2,6,7,8};
		int arr2[] = new int[] {12,13,16,17,18};
		System.out.println("The two integer array whose medain to be found are");
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println("and there  Medain is  : " +getMedian(arr1, arr2));
		
	}
}
