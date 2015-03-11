package org.garch.core.parser;

import static org.junit.Assert.*

import org.garch.core.parser.service.GrailsArchitectureService

class DefaultParser {
	
	GrailsArchitectureService grailsArchService 

	public static void main(String... projectLocations){
		def arch = new DefaultParser().generateArch(projectLocations)
		arch.describe()
	}
	
	
	/**
	 * Generates an architectural overview of: 
	 * 
	 * - Grails Projects
	 * 
	 * @param projectLocations
	 * 	list of grails projects
	 */
	def generateArch(String... projectLocations){
		return generateGrailsArchitecture(projectLocations)
	}
	
	def generateGrailsArchitecture(String... projectLocations){
		return grailsArchService.generateArch(projectLocations);
	}
	
}
