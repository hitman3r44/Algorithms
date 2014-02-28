package com.interview.algorithms;

import java.util.BitSet;

public class FindMissingElementInArray {
	private int[] intArray = new int[100];

	private void loadArray() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = i + 1;
		}
	}

	private void displayArray() {
		System.out.println("The Contents are");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.println("--------------------------------");
	}

	private void setElement(int index, int value) {
		intArray[index] = value;
	}

	private int missingElemntUsingSum() {
		int sum = 0;
		int missingNo = -1;

		int actualSum = (intArray.length * (intArray.length + 1)) / 2;

		for (int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}

		missingNo = actualSum - sum;

		return missingNo;

	}

	private void missingElemntUsingBitSet() {
		BitSet bitset = new BitSet(intArray.length);

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] != i + 1) {
				bitset.flip(i);
			}
		}

		System.out.println("The missing nos are : ");

		for (int i = 0; i < intArray.length; i++) {
			if (bitset.get(i)) {
				System.out.print(i + ",");
			}
		}

		System.out.println("----------------------------------------- ");

	}

	public static void main(String[] args) {
		FindMissingElementInArray find = new FindMissingElementInArray();
		find.loadArray();
		find.setElement(30, 0);
		find.setElement(60, 0);
		find.displayArray();

		find.missingElemntUsingBitSet();

		find.loadArray();
		find.setElement(30, 0);
		find.displayArray();
		System.out.println("The missing no is : "
				+ find.missingElemntUsingSum());

	}

}
