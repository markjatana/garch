package org.garch.graph

/**
 * An edge has only two nodes and can be directed
 * The nodes are labeled A and B so that the 
 * edge can be directed: i.e. from A to B or B to A
 * By default an edge is directed from A to B
 * 
 */
class Edge {

		public static final String EDGE_HAS_NODES_EXCEPTION_MSG = 'This edge is already connected to two nodes - %1$s and %2$s'
	
		INode nodeA
		INode nodeB
		Boolean directedAToB = true
		
		/**
		 * Will add a node to the nodeA position on the edge by default unless 
		 * there is already a nodeA in which case it is added as NodeB. 
		 * If both nodes are already taken an Exception will be thrown.
		 * @param node
		 * 	node to add.
		 * @throws GraphException
		 * 	if both nodes on the edge are already taken.
		 */
		public void addNode(INode node) throws GraphException {
			if(!nodeA){
				nodeA = node
			}else if(!nodeB){
				nodeB = node
			}else {
				throw new GraphException(String.format(EDGE_HAS_NODES_EXCEPTION_MSG, nodeA.toString(), nodeB.toString()))
			}
		}
}
