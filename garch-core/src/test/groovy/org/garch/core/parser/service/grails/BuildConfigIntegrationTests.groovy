package org.garch.core.parser.service.grails

import groovy.mock.interceptor.MockFor
import org.junit.Test


class BuildConfigIntegrationTests {

	@Test
	public void testDependencies(){
	 BuildConfig buildConfig = new BuildConfig()
	 def closureCalled
	 Closure mockClos = {
		 runtime 'group:name:version'
	 }
	 buildConfig.dependencies(mockClos)
	 assert buildConfig.dependencies.runtime.size == 1
	}
	
	
	
}
