package com.interview.algorithms.graph;

import com.example.datastructures.PriortyQueue;
import com.example.datastructures.weighted.graph.Edge;
import com.example.datastructures.weighted.graph.WeightedGraph;

/**
 * 
 * @author ajitkoti
 *
 */
public class MinimumSpanningTreeWeight {

	private static WeightedGraph graph;
	private static int currentVert;
	private static PriortyQueue<Edge> thePQ = new PriortyQueue<Edge>(100);
	private static int nTree; // # of verts in tree

	/**
	 * 	
	 */
	private static void mstw() {
		// start at Vertex 0
		currentVert = 0;

		while (nTree < graph.nVerts - 1) // while not all vertices in tree
		{
			// put current vert in tree
			graph.vertexList[currentVert].isInTree = true;
			nTree++;

			// insert edges adjacent to currentVert into priority queue
			for (int j = 0; j < graph.nVerts; j++) // for each vertex
			{
				// There are self-to-self cells in the adajacency matrix
				// No need to evaluate these.
				if (j == currentVert)
					continue;

				// If the vertex we're looking at is already in the tree
				// No need to consider connecting to it
				if (graph.vertexList[j].isInTree)
					continue;

				// Capture the distance from the current vert to the
				// vert the loop is looking at
				int distance = graph.adjMat[currentVert][j];

				// If the vert referenced in the loop is reached
				// via infinity, there isn't an edge. Go to next
				// loop iteration
				if (distance == graph.INFINITY)
					continue;

				// Otherwise, pass it to the putInPQ method to
				// (possibly) insert it into the priority queue
				putInPQ(j, distance);
			}

			// If the priority queue is still empty after the while loop
			// above executes, the graph is not connected
			if (thePQ.getSize() == 0) {
				System.out.println(" GRAPH NOT CONNECTED");
				return;
			}

			// Remove the edge with minimum distance from priority queue
			Edge theEdge = thePQ.removeMin();
			int sourceVert = theEdge.srcVert;

			// set currentVert to our chosen destination (for next iteration)
			currentVert = theEdge.destVert;

			// Display the Edge from source to destination
			System.out.print(graph.vertexList[sourceVert].label); // source
			System.out.print(graph.vertexList[currentVert].label); // dest
			System.out.print(" ");
		}

		// mst is complete -- unmark vertices
		for (int j = 0; j < graph.nVerts; j++)
			graph.vertexList[j].isInTree = false;
	}

	// ---------------------------------------------------------------
	public static void putInPQ(int newVert, int newDist) {
		// determine if there is already an edge with the same
		// destination vertex in the priority queue
		int queueIndex = find(newVert);

		if (queueIndex != -1) {
			// Get the Edge that Exists
			Edge tempEdge = thePQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if (oldDist > newDist) {
				// Remove Old Edge
				thePQ.removeN(queueIndex);
				// Create New Edge
				Edge theEdge = new Edge(currentVert, newVert, newDist);
				// Add New Edge to PQ
				thePQ.insert(theEdge);
			}
			// else no action--> just leave old vertex there
		} else // no edge with same destination vertex
		{
			// Insert into PQ
			Edge theEdge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(theEdge);
		}
	}

	public static int find(int findDex) {
		for (int j = 0; j < thePQ.getSize(); j++)
			if (thePQ.peekN(j).destVert == findDex)
				return j;
		return -1;
	}

	public static void main(String[] args) {
		graph = new WeightedGraph();
		graph.addVertex('A'); // 0
		graph.addVertex('B'); // 1
		graph.addVertex('C'); // 2
		graph.addVertex('D'); // 3
		graph.addVertex('E'); // 4
		graph.addVertex('F'); // 5

		graph.addEdge(0, 1, 6); // AB 6
		graph.addEdge(0, 3, 4); // AD 4
		graph.addEdge(1, 2, 10); // BC 10
		graph.addEdge(1, 3, 7); // BD 7
		graph.addEdge(1, 4, 7); // BE 7
		graph.addEdge(2, 3, 8); // CD 8
		graph.addEdge(2, 4, 5); // CE 5
		graph.addEdge(2, 5, 6); // CF 6
		graph.addEdge(3, 4, 12); // DE 12
		graph.addEdge(4, 5, 7); // EF 7

		System.out.print("Minimum spanning tree: ");
		mstw(); // compute minimum spanning tree
		System.out.println();
	}
}
