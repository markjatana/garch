package org.garch.core.parser.service.grails

class Dependencies {

	Collection<Dependency> compile = []
	Collection<Dependency> build = []
	Collection<Dependency> runtime = []
	Collection<Dependency> provided = []
	
	public void runtime(String runTimeDep){
		runtime << createDependency(runTimeDep)
	}
	
	public Dependency createDependency(String colonSeparateDeclaration){
		def parts = colonSeparateDeclaration.split(":")
		return new Dependency(group: parts[0], name: parts[1], version: parts[2])
	}
}
