package com.interview.algorithms;

public class FibonanciSeries {

	public FibonanciSeries() {

	}

	public void generateFibonanciSeries(int kth) {
		System.out.println(kth + "th : Fib no is :" + recFibonanci(kth));

	}

	private int recFibonanci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int fib = recFibonanci(n - 1) + recFibonanci(n - 2);

			return fib;
		}

	}

	public static void main(String[] args) {

		FibonanciSeries series = new FibonanciSeries();

		series.generateFibonanciSeries(8);

		for (int i = 0; i <= 8; i++) {
			System.out.print("   " + series.recFibonanci(i));
		}

	}

}
