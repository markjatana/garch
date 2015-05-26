package org.garch.graph

class Node implements INode {
	
	public void addEdge(Edge edge) throws GraphException{
		edges << edge
		edge.addNode(this)
	}
	
}
