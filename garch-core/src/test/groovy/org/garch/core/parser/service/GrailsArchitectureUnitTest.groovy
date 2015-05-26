package org.garch.core.parser.service

import org.junit.Test
import static org.junit.Assert.* 
class GrailsArchitectureUnitTest {

	@Test
	public void testDescribe(){
		
		def expectedAppName = "expected_app_name"
		def expectedAppVersion = "expected_app_version"
		def expectedAppGroup = "expected_app_group"

		GrailsArchitecture grailsArch = new GrailsArchitecture()
		grailsArch.appName = expectedAppName
		grailsArch.appVersion = expectedAppVersion
		grailsArch.appGroup = expectedAppGroup
		
		String expectedDescription = "$expectedAppGroup:$expectedAppName:$expectedAppVersion"
		assertEquals(expectedDescription, grailsArch.describe())
	}
	
}
