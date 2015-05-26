package org.garch.core.parser.service

import org.garch.core.parser.service.grails.Dependencies
import org.garch.core.parser.service.grails.Dependency
import org.junit.Test

class GrailsFrameworkParserIntegrationTests {
	
	public static final String testProjectLocation= "src/test/resources/org/garch/core/parser/service/test-app-1" 
	
	@Test
	public void testGenerateArchProducesDependencies(){
		GrailsFrameworkParser parser = new GrailsFrameworkParser()
		GrailsArchitecture arch = parser.generateArch(new File(testProjectLocation))
		Dependency expectedDependency1 = new Dependency(group:'mysql',name: 'mysql-connector-java', version: '5.1.16')
		Dependency expectedDependency2 = new Dependency(group:'com.google.api-client',name: 'google-api-client', version: '1.10.1-beta')
		assert arch.dependencies.runtime.size() == 2
		assert arch.dependencies.runtime.contains(expectedDependency1)
		assert arch.dependencies.runtime.contains(expectedDependency2)	
	}
	
	@Test
	public void testGenerateArch(){
		GrailsFrameworkParser parser = new GrailsFrameworkParser()
		GrailsArchitecture arch = parser.generateArch(new File(testProjectLocation))
		assert arch.getAppGroup() == 'org.test'
	}

}
