package org.garch.graph

import groovy.mock.interceptor.MockFor

import org.junit.Test

/**
 * Node can have many edges emanating from it
 */
class NodeUnitTests {

	@Test
	public void testAddEdgeWithNoNodes(){
		INode node = new Node()
		def edgeMocker = new MockFor(Edge)
		Edge mockEdge
		edgeMocker.demand.addNode {INode expectedNode ->
			assert expectedNode == node
		}
		mockEdge = edgeMocker.proxyInstance()
		
		node.addEdge(mockEdge)
		assert node.edges.size() == 1
		assert node.edges.contains(mockEdge)
	}
	
}
