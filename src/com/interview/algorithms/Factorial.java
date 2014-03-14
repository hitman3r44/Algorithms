package com.interview.algorithms;

public class Factorial {

	public void generateFactorial(int kth) {
		System.out.println("Factoial for " + kth + "  no is : "
				+ recFactorial(kth));
		System.out.println("Factoial for " + kth + "  no is : "
				+ itertaiveFactorial(kth));

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

	int itertaiveFactorial(int n) {
		if (n < 0)
			return -1; // Error condition.

		if (n == 0)
			return 0;

		int a = 1, b = 1;

		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		
		return b;
	}

	public static void main(String[] args) {

		Factorial factorial = new Factorial();
		factorial.generateFactorial(5);
		

	}

}
