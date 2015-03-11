package org.garch.core.parser;

import static org.junit.Assert.*
import groovy.mock.interceptor.MockFor
import org.junit.Test

class DefaultParserUnitTest{

 	@Test
 	public void testGenerateArch(){
		 def expectedProjectLocations = "expected_loc_1"
		 def arch = parser.generateArch(expectedProjectLocations)
		 
		 def archMocker = new MockFor(Architecture)
		 
		 def grailsArchServiceMocker = new MockFor(GrailsArchitectureService)
		 grailsArchServiceMocker.demand.generateArch(){ def actualProjectLocations ->
		 	assertEquals(expectedProjectLocations, actualProjectLocations)
			return mockArch
		 }
		 
		 DefaultParser parser = new DefaultParser()
		 parser.grailsArchService = grailsArchServiceMocker.createMock()
		 parser.main(expectedProjectLocations) 
 	}
}
