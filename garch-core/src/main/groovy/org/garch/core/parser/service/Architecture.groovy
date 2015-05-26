package org.garch.core.parser.service

import org.garch.graph.Edge
import org.garch.graph.GraphException;
import org.garch.graph.INode

abstract class Architecture  implements INode{
	
	 String name;
	 List<Edge> edges = []

 	 abstract def describe();
	 
	 public void addEdge(Edge edge) throws GraphException{
		  edges << edge
		  edge.addNode(this)
	 }
	  
	 public String toString(){ 
		 return getName()
	 }
	  
}
