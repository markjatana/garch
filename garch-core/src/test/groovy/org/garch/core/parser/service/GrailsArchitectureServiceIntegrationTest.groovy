package org.garch.core.parser.service

import org.junit.Test
import static org.junit.Assert.*

class GrailsArchitectureServiceIntegrationTest {
	
	@Test
	public void testGenerateArch() {

		File sampleProjectLocation = new File("src/test/resources/org/garch/core/parser/service/test-app")
		def gas = new GrailsFrameworkParser()
		GrailsArchitecture garche = gas.generateArch(sampleProjectLocation)
		assertEquals(garche.appName, 'test-app')
	}
	
}
