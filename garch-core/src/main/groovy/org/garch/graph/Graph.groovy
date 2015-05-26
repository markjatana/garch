package org.garch.graph

import org.garch.core.parser.service.Architecture

/**
 * A collection of connected Edges. 
 *
 */
class Graph {
	
	List<INode> nodes;
	
	Graph(Collection<INode> nodes){
		this.nodes = nodes.asList()
	}
	
	/**
	 * Searches the graph for a node with the given name
	 * @param nodeName
	 * 	the name of the node
	 * @return Node
	 * 	node if found otherwise null
	 */
	public INode findNodeByName(String nodeName){
		def results = []
		 def nodes = searchNodes(results, nodes, true){ INode node ->
			 return node.name == nodeName
		 }
		 results.isEmpty() ?  null : nodes[0] 
	}
	
	public void searchNodes(Collection<INode> results, Collection<INode> nodes, Boolean findFirst, Closure check){
		nodes.each {INode node ->
					Boolean nodeFound = check(node)
					if(nodeFound){
						results << node
						if(findFirst) { 
						 return
						}
					}
		}
	}
}