package org.garch.core.parser.service.grails.graph


import org.garch.core.parser.service.GrailsArchitecture
import org.garch.core.parser.service.grails.Dependencies
import org.garch.core.parser.service.grails.Dependency
import org.garch.graph.Graph
import org.garch.graph.Grapher
import org.garch.graph.INode


/**
 * Runs through an architecture creating Grails nodes and edges to describe
 * the architecture
 *
 */
class GrailsGrapher extends Grapher{
	
	public void graph(Graph graph){
		graph.nodes.each{INode node ->
		 	if(node instanceof GrailsArchitecture){
				 GrailsArchitecture gArch = (GrailsArchitecture)node
				 Dependencies dependencies = gArch.getDependencies()
				 dependencies.runtime.each{Dependency dependency ->
					  DependencyEdge edge = new DependencyEdge()
					  edge.addNode(gArch)
					  INode dependantNode = graph.findNodeByName(dependency.fullyQualifiedName)
					  edge.addNode(dependantNode)
					  node.addEdge(edge)
				 }
			 }
		}
	}
}
