package org.garch.core.parser;

import static org.junit.Assert.*

import org.garch.core.parser.service.Architecture;
import org.garch.core.parser.service.FrameworkParser
import org.garch.core.parser.service.GrailsFrameworkParser

class DefaultParser {
	
	public static def log
	
	GrailsFrameworkParser grailsArchitectureService
	FrameworkParserFactory frameworkParserFactory 

	public static void main(String... projectLocations){
		DefaultParser parser = new DefaultParser()
		parser.grailsArchitectureService = new GrailsFrameworkParser();
		parser.frameworkParserFactory = new FrameworkParserFactory()
		def arches = parser.generateArch(projectLocations)
		arches.each {println it.describe()}
	}
	
	Collection<File> convertToDirectories(String... projectLocations){
		def dirs = []
		projectLocations.each {
			File dir = new File(it)
			if(dir.isDirectory()){
				dirs << dir
			}else{
				println("$it is not a directoryLocation")
			}
		}
		return dirs
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
		def dirs = convertToDirectories(projectLocations)
		Collection<Architecture> arches = []
		parseDirectories(dirs, arches)
		return arches;
	}
	
	def parseDirectories(dirs, arches){
		dirs.each { File file->
			FrameworkParser fwParser = frameworkParserFactory.getParser(file)
			if(fwParser){
				Architecture arch = fwParser.generateArch(file)
				arches << arch
			}else {
				parseDirectories(file.listFiles(), arches)
			}
		}
		return arches
	}
	
	def generateGrailsArchitecture(String... projectLocations){
		return grailsArchitectureService.generateArch(projectLocations);
	}
	
}
