package org.garch.core.parser.service.grails.graph

import org.garch.graph.Edge

/**
 * Links two grails dependency. A is dependant on B.
 * 
 */
class DependencyEdge extends Edge {

	 public String toString(){
		 return nodeA + " -> " + nodeB
	 }
	
}
