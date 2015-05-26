package org.garch.core.parser;

import org.garch.core.parser.service.grails.graph.GrailsGrapher
import org.garch.graph.Grapher

/**
 * Produces @link{Grapher} instances that are found on the
 * classpath
 *
 */
public class GrapherFactory {
	
	/**
	 * Currently this is hard coded to return the included Grails Grapher
	 * @return  list of availabe graphers
	 */
	public Collection<Grapher> getAllGraphers(){
		return [new GrailsGrapher()]
	}

}
