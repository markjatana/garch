package org.garch.core.parser;

import static org.junit.Assert.*

import org.garch.core.parser.service.GrailsArchitecture
import org.garch.core.parser.service.grails.graph.DependencyEdge
import org.garch.graph.Edge
import org.junit.Test

class DefaultParserIntegrationTest {

 	@Test
 	public void testGenerateArch(){
		 def expectedProjectLocations = "src/test/resources/org/garch/core/parser/service"		 
		 DefaultParser parser = new DefaultParser(expectedProjectLocations)
		 def expectedNode1Name = 'org.test:test-app-1:0.1'
		 def expectedNode2Name = 'org.test_group:test-app-2:2.2'
		 assert parser.arches.size() == 2
		 def nodes = parser.graph.nodes  
		 assert nodes.size() == 2
		 assert nodes.find{it.name == expectedNode1Name }
		 assert nodes.find{it.name == expectedNode2Name }
		 
//		 def parentNodeName = expectedNode1Name
//		 def childNodeName = expectedNode2Name
//		 def childNode = nodes.find{it.name == childNodeName }
//		 
//		 assert childNode.edges.size() == 1
//		 Edge edge = childNode.edges[0]
//		 assert edge instanceof DependencyEdge
//		 assert edge.nodeA.name == childNodeName
//		 assert edge.nodeB.name == parentNodeName
 	}
}
