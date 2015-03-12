package org.garch.core.parser.service

import org.junit.Test

class GrailsArchitectureServiceIntegrationTest {
	
	@Test
	public void testGenerateArch() {
		def sampleProjectLocations = ["resources/org/garch/core/parser/service/"]
		def arches = new GrailsArchitectureService().generateArch(sampleProjectLocations)
		arches.each {
			println it.describe()
		}		
		
	}
	
}
