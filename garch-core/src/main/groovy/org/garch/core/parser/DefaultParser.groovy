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
		arches.each {
			println("")
			println it.describe()
		}
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
	
	/**
	 * Recursively parses directories generating an @link{Architecture} if
	 * a suitable @link{FrameworkParser} can be found. If one can be found the
	 * directory's content's are NOT parsed any further. We assume
	 * we don't have a framework within a framework.
	 * 
	 * If a framework is not found then contained directories are parsed.
	 *
	 * @param dirs directories to be parsed
	 * @param arches list of architectures found during porsing
	 * @return the list of architectures found
	 */
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
