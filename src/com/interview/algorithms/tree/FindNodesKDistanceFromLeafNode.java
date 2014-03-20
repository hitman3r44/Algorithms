package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Print all nodes that are at distance k from a leaf node
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * 
 * @author ajitkoti
 *
 */
public class FindNodesKDistanceFromLeafNode {

	/*
	 * This function prints all nodes that are distance k from a leaf node
	 * path[] --> Store ancestors of a node visited[] --> Stores true if a node
	 * is printed as output. A node may be k distance away from many leaves, we
	 * want to print it once
	 */
	void kDistantFromLeafUtil(BinaryNode node, int path[], boolean visited[],
			int pathLen, int k) {
		// Base case
		if (node == null)
			return;

		/* append this Node to the path array */
		path[pathLen] = node.getData();
		visited[pathLen] = false;
		pathLen++;

		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor
		 * is not already printed
		 */
		if (node.getLeftChild() == null && node.getRightChild() == null
				&& pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
			System.out.println(path[pathLen - k - 1]);
			visited[pathLen - k - 1] = true;
			return;
		}

		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.getLeftChild(), path, visited, pathLen, k);
		kDistantFromLeafUtil(node.getRightChild(), path, visited, pathLen, k);
	}

	/*
	 * Given a binary tree and a nuber k, print all nodes that are k distant
	 * from a leaf
	 */
	void printKDistantfromLeaf(BinaryNode node, int k) {
		int[] path = new int[100];
		boolean[] visited = new boolean[100];
		kDistantFromLeafUtil(node, path, visited, 0, k);
	}

}
