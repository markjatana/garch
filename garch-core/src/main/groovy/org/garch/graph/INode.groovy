package org.garch.graph

/**
 * Node can have many edges emanating from it
 */
interface INode {

	List<Edge> edges = new ArrayList<Edge>()
	
	/**
	 * Adds an edge to this node and this node to the 
	 * edge.
	 * @param edge
	 *  The edge to add
	 */
	public void addEdge(Edge edge) throws GraphException
	
}
