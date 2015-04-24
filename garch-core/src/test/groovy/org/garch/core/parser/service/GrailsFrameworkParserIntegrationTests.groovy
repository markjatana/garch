package org.garch.core.parser.service

import org.garch.core.parser.service.grails.Dependencies
import org.garch.core.parser.service.grails.Dependency
import org.junit.Test

class GrailsFrameworkParserIntegrationTests {
	
	public static final String testProjectLocation= "src/test/resources/org/garch/core/parser/service/test-app-1" 
	
	@Test
	public void testGetDependencies(){
		GrailsFrameworkParser parser = new GrailsFrameworkParser()
		File testProjectDir = new File(testProjectLocation)
		GrailsArchitecture arch = new GrailsArchitecture()
		parser.getDependencies(testProjectDir, arch)
		Dependency expectedDependency = new Dependency(group:'mysql',name: 'mysql-connector-java', version: '5.1.16')
		assert arch.dependencies.runtime.contains(expectedDependency)
	}

}
