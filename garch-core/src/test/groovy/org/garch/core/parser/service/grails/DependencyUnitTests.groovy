package org.garch.core.parser.service.grails

import org.junit.Test

class DependencyUnitTests {
	
	@Test
	public void testGetFullyQualifiedName(){
		
		def dummyName = "dummy_name"
		def dummyVersion = "dummy_version"
		def dummyGroup = "dummy_group"
		Dependency dep = new Dependency(name : dummyName, version: dummyVersion, group: dummyGroup)
		assert dep.fullyQualifiedName == "$dummyGroup:$dummyName:$dummyVersion"
	}

}
