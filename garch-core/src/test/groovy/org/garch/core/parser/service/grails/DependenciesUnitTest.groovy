package org.garch.core.parser.service.grails

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class DependenciesUnitTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testErrorMsgThrownIfDependencyFormatIsNotRecognised(){
		Dependencies deps = new Dependencies()
		def expectedRuntime = "expected runtime"
		exception.expect(DependencyException.class);
		exception.expectMessage(Dependencies.UNRECOGNISED_DEPENDENCY_ERROR_MSG.format(expectedRuntime));
		deps.runtime(expectedRuntime)
	}
	
	@Test
	public void testRuntime(){
		Dependencies deps = new Dependencies()
		def expectedRuntime1 = "expected:runtime:0.1"
		def expectedRuntime2 = "expected:runtime:0.2"
		deps.runtime(expectedRuntime1)
		deps.runtime(expectedRuntime2)
		assert deps.runtime.size() == 2
		Dependency expectedRuntimeDep = new Dependency(group: 'expected', name: 'runtime', version:'0.1')
		assert deps.runtime.contains(expectedRuntimeDep)
	}
	
	@Test
	public void testCompile(){
	Dependencies deps = new Dependencies()
		def expectedCompile1 = "expected:compile:0.1"
		def expectedCompile2 = "expected:compile:0.2"
		deps.compile(expectedCompile1)
		deps.compile(expectedCompile2)
		assert deps.compile.size() == 2
		Dependency expectedCompileDep = new Dependency(group: 'expected', name: 'compile', version:'0.1')
		assert deps.compile.contains(expectedCompileDep)
	}
	
}
