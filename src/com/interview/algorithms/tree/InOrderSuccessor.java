package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a
 * given node in a binary search tree where each node has a link to its parent
 * 
 * @author ajitkoti
 *
 */
public class InOrderSuccessor {

	public static void main(String[] args) {

	}

	/**
	 * On an in-order traversal, we visit X.left, then X, then X.right. So, if
	 * we want to find X.successor(), we do the following:
	 * 
	 *  1. If X has a right child, then the successor must be on the right side of X (because of the
	 * order in which we visit nodes). Specifically, the left-most child must be
	 * the first node visited in that subtree. 
	 * 
	 * 2. Else, we go to X’s parent (call it P). 
	 * 
	 * 2.a. If X was a left child (P.left = X), then P is the successor of X
	 * 
	 *  2.b. If X was a right child (P.right = X), then we have fully visited P, so we call successor(P)
	 * 
	 * @param currentNode
	 * @param parentNode
	 * @return
	 */
	public static BinaryNode inorderSucc(BinaryNode currentNode, BinaryNode parentNode) {

		if (currentNode != null) {
			BinaryNode p;

			// Found right children -> return 1st inorder node on right
			if (parentNode == null || currentNode.getRightChild() != null) {
				p = leftMostChild(currentNode.getRightChild());
			} else {
				// Go up until we’re on left instead of right (case 2b)
				while ((p = parentNode) != null) {
					if (p.getLeftChild() == currentNode) {
						break;
					}

					currentNode = p;
				}
			}
			return p;
		}

		return null;
	}

	public static BinaryNode leftMostChild(BinaryNode e) {
		if (e == null)
			return null;

		while (e.getLeftChild() != null)
			e = e.getLeftChild();

		return e;
	}

}
