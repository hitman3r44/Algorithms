package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * 
 * 
 * @author ajitkoti
 *
 */
public class LeastCommonAncestor {
	public static void main(String[] args) {

	}

	/**
	 * You could follow a chain in which p and q are on the same side. That is,
	 * if p and q are both on the left of the node, branch left to look for the
	 * common ancestor. When p and q are no longer on the same side, you must
	 * have found the first common ancestor
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public BinaryNode commonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {

		if (covers(root.getLeftChild(), p) && covers(root.getLeftChild(), q))
			return commonAncestor(root.getLeftChild(), p, q);

		if (covers(root.getRightChild(), p) && covers(root.getRightChild(), q))
			return commonAncestor(root.getRightChild(), p, q);

		return root;
	}

	private boolean covers(BinaryNode root, BinaryNode p) { // is p a child of
															// root?
		if (root == null)
			return false;

		if (root == p)
			return true;

		return covers(root.getLeftChild(), p) || covers(root.getRightChild(), p);
	}

}
