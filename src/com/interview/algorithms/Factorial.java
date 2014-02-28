package com.interview.algorithms;

public class Factorial {

	public void generateFactorial(int kth) {
		System.out.println("Factoial for " + kth + "  no is : "
				+ recFactorial(kth));

	}

	private int recFactorial(int n) {
		if (n <= 0) {

			return 1;

		} else {
			int fac = n * recFactorial(n - 1);
			System.out.print(fac + ",");
			return fac;
		}

	}

	public static void main(String[] args) {

		Factorial factorial = new Factorial();
		factorial.generateFactorial(5);

	}

}
