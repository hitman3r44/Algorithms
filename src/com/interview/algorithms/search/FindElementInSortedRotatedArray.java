package com.interview.algorithms.search;

import com.example.datastructures.search.BinarySearch;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, give an O(log n) algorithm that finds an element in the array. You may
 * assume that the array was originally sorted in increasing order.
 *  EXAMPLE: Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *  Output: 8 (the index
 * of 5 in the array)
 * 
 * @author ajitkoti
 *
 */
public class FindElementInSortedRotatedArray {

	private int[] searchArray;

	public int find(int[] searchArray, int tobeFound) {
		this.searchArray = searchArray;

		return find(tobeFound, 0, searchArray.length - 1);
	}

	public int find(int tobeFound, int lowerbound, int upperbound) {
		int mid;

		mid = (lowerbound + upperbound) / 2;

		if (searchArray[mid] == tobeFound) {
			return tobeFound;
		} else if (lowerbound > upperbound) {
			return -1;
		} else {
			if (searchArray[mid] > tobeFound) {
				return find(tobeFound, lowerbound, mid - 1);
			} else {
				return find(tobeFound, mid + 1, upperbound);
			}
		}

	}

	public static void main(String[] args) {
		int[] searchArray = new int[] { 9, 8, 7, 6, 5, 4, 3, 10, 10 };
		BinarySearch search = new BinarySearch();
		System.out.println(search.find(searchArray, 5));
		System.out.println(search.find(searchArray, 10));

	}

}
