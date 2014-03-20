package com.interview.algorithms.tree;

import java.util.ArrayList;

import com.example.datastructures.node.BinaryNode;

/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum up to that value. Note that it can be
 * any path in the tree - it does not have to start at the root.
 * 
 * @author ajitkoti
 *
 */
public class FindTheSumAndPrintThePath {
	public static void main(String[] args) {

	}

	/**
	 * On every node, we look “up” to see if we’ve found the sum. That is—rather
	 * than asking “does this node start a path with the sum?,” we ask “does
	 * this node complete a path with the sum?
	 * 
	 * 
	 * What is the time complexity of this algorithm?
	 * 
	 * Well, if a node is at level r, we do r amount of work (that’s in the
	 * looking “up” step). We can take a guess at O(n lg n) (n nodes, doing an
	 * average of lg n amount of work on each step)
	 * @param head
	 * @param sum
	 * @param buffer
	 * @param level
	 */
	@SuppressWarnings("unchecked")
	private void findSum(BinaryNode head, int sum, ArrayList<Integer> buffer, int level) {

		if (head == null)
			return;

		int tmp = sum;
		buffer.add(head.getData());

		for (int i = level; i > -1; i--) {
			tmp -= buffer.get(i);

			if (tmp == 0)
				print(buffer, i, level);
		}

		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();

		findSum(head.getLeftChild(), sum, c1, level + 1);
		findSum(head.getRightChild(), sum, c2, level + 1);
	}

	/**
	 * 
	 * @param buffer
	 * @param level
	 * @param i2
	 */
	private void print(ArrayList<Integer> buffer, int level, int i2) {

		for (int i = level; i <= i2; i++) {
			System.out.print(buffer.get(i) + "");
		}

		System.out.println();
	}

}
