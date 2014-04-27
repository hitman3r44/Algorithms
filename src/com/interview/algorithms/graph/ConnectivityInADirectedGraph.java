package com.interview.algorithms.graph;

import com.example.datastructures.Stack;
import com.example.datastructures.graph.Graph;

public class ConnectivityInADirectedGraph {
	Graph graph = null;
	Stack<Integer> stack = null;

	protected ConnectivityInADirectedGraph(Graph xGraph) {
		graph = xGraph;
		stack = new Stack<Integer>(10);
	}

	/**
	 * Using BFS
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public boolean isReachable(int src, int dest) {
		int vertexLength = graph.getVertexList().length;
		dfs(0);

		// If DFS traversal doesn’t visit all vertices, then return false.
		for (int i = 0; i < graph.getVertexList().length; i++)
			if (graph.getVertexList()[i].wasVisited == false)
				return false;

		// Step 3: Create a reversed graph
		transposeMatrix(graph);

		// Step 4: Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < vertexLength; i++)
			graph.getVertexList()[i].wasVisited = false;

		dfs(0);

		// If DFS traversal doesn’t visit all vertices, then return false.
		for (int i = 0; i < graph.getVertexList().length; i++)
			if (graph.getVertexList()[i].wasVisited == false)
				return false;
		
		return true;

	}

	private void transposeMatrix(Graph graph2) {
		// TODO Auto-generated method stub
		
	}

	

	public void dfs(int index) {
		graph.getVertexList()[index].wasVisited = true;
		graph.displayVertex(index);
		stack.push(index);

		while (!stack.isEmpty()) {
			int v = graph.getAdjUnVisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			} else {
				graph.getVertexList()[v].wasVisited = true;
				graph.displayVertex(v);
				stack.push(v);

			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(10);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 4);
		FindIfPathExistsBetweenTwoVerticesOfGraph pathExists = new FindIfPathExistsBetweenTwoVerticesOfGraph(
				graph);

		System.out.println("Is Paths Reacahble: "
				+ pathExists.isReachable(1, 3));

	}

}
