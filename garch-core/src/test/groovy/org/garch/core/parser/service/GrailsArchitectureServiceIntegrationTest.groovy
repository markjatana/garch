package org.garch.core.parser.service

import org.junit.Test
import static org.junit.Assert.*

class GrailsArchitectureServiceIntegrationTest {
	
	@Test
	public void testGenerateArch() {

		def sampleProjectLocations = ["src/test/resources/org/garch/core/parser/service/test-app"]
		def gas = new GrailsFrameworkParser()
		Collection<GrailsArchitecture> garches = gas.generateArch(sampleProjectLocations)
		assertEquals(garches.size(), 1)
		assertEquals(garches[0].appName, 'test-app')
	}
	
}
