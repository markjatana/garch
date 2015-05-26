package org.garch.core.parser;

import static org.junit.Assert.*

import org.garch.core.parser.service.Architecture
import org.garch.core.parser.service.FrameworkParser
import org.garch.core.parser.service.GrailsFrameworkParser
import org.garch.graph.Graph
import org.garch.graph.Grapher
import org.garch.graph.INode

class DefaultParser {
	
	public static def log
	
	GrailsFrameworkParser grailsArchitectureService
	FrameworkParserFactory frameworkParserFactory
	GrapherFactory grapherFactory
	
	def arches
	
	Graph graph
	
	/**
	 * Basic constructor
	 */
	public DefaultParser(String... projectLocations){
	
		grailsArchitectureService = new GrailsFrameworkParser();
		frameworkParserFactory = new FrameworkParserFactory()
		grapherFactory = new GrapherFactory()
		arches = generateArch(projectLocations)
		graph = generateGraph(arches)
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
		Collection<Architecture> arches = new ArrayList<Architecture>()
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
	 * @param arches list of architectures found during parsing
	 * @return the list of architectures found
	 */
	def parseDirectories(dirs, Collection<Architecture> arches){
		dirs.each { File file->
			FrameworkParser fwParser = frameworkParserFactory.getParser(file)
			if(fwParser){
				Architecture arch = fwParser.generateArch(file)
				arches.add(arch)
			}else {
				parseDirectories(file.listFiles(), arches)
			}
		}
		return arches
	}
	
	def generateGrailsArchitecture(String... projectLocations){
		return grailsArchitectureService.generateArch(projectLocations);
	}
	
	/**
	 * Generates a graph for the generated architectures.
	 * 
	 * @param arch
	 */	
	public Graph generateGraph(Collection <? extends INode> nodes){
		graph = new Graph(nodes)
		Collection<Grapher> graphers = grapherFactory.getAllGraphers();
		graphers.each{
			 it.graph(graph)
		}
		return graph;
	}
	
}
