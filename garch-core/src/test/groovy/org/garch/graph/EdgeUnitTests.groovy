package org.garch.graph

import org.junit.Rule;
import org.junit.Test
import org.junit.rules.ExpectedException;


class EdgeUnitTests {

		@Test
		public void testNodeAddedToEmptyEdgeBecomesNodeA(){
			INode expectedNode = new Node()
			Edge edge = new Edge()
			edge.addNode(expectedNode)
			assert edge.nodeA == expectedNode
		}
		
		@Test
		public void testNodeAddedToEdgeWithOneNodeBecomesNodeB(){
			INode expectedNode = new Node()
			Edge edge = new Edge()
			edge.nodeA = new Node()
			edge.addNode(expectedNode)
			assert edge.nodeB == expectedNode
		}
		
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void testNodeAddedToEdgeWithTwoNodesThrowsException(){
			INode expectedNode = new Node()
			Edge edge = new Edge()
			INode a = new Node()
			edge.addNode(a)
			INode b = new Node()
			edge.addNode(b)
			exception.expect(GraphException.class);
			exception.expectMessage(Edge.EDGE_HAS_NODES_EXCEPTION_MSG.format(a.toString(),b.toString()));
			edge.addNode(expectedNode)
			
		}
}
