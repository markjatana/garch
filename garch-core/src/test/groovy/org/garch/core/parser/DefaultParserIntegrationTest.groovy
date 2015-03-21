package org.garch.core.parser;

import static org.junit.Assert.*

import org.garch.core.parser.service.GrailsFrameworkParser
import org.junit.Test

class DefaultParserIntegrationTest{

 	@Test
 	public void testGenerateArch(){
		 def expectedProjectLocations = "src/test/resources/org/garch/core/parser/service"		 
		 DefaultParser.main(expectedProjectLocations)
 	}
}
