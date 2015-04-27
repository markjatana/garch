package org.garch.core.parser.service.grails

/**
 * Class designed delegated to a 'dependencies' call from the 'grails.project.dependency.resolution'
 * property of a grails' BuildConfig file   
 * @see{BuildConfig)
 */
class Dependencies {
	
	public static final String UNRECOGNISED_DEPENDENCY_ERROR_MSG = 'Unrecognised dependency declaration - $1'

	Collection<Dependency> compile = []
	Collection<Dependency> build = []
	Collection<Dependency> runtime = []
	Collection<Dependency> provided = []
	
	/**
	 * Add a runtime dependency to the collection of runtime dependencies
	 * @param runTimeDep
	 */
	public void runtime(String runTimeDep){
		runtime << createDependency(runTimeDep)
	}
	
	/**
	 * Add a compile dependency to the collection of compile dependencies
	 * @param compTimeDep
	 */
	public void compile(String compTimeDep){
		compile << createDependency(compTimeDep)
	}
	
	public Dependency createDependency(String colonSeparateDeclaration){
		def parts = colonSeparateDeclaration.split(":")
		if(parts.length !=3){
			throw new DependencyException(UNRECOGNISED_DEPENDENCY_ERROR_MSG.format(colonSeparateDeclaration))
		}
		return new Dependency(group: parts[0], name: parts[1], version: parts[2])
	}
}
