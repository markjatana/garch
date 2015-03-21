package org.garch.core.parser

import java.io.File;

import org.garch.core.parser.service.FrameworkParser
import org.garch.core.parser.service.GrailsFrameworkParser

class FrameworkParserFactory {
	
	Collection<FrameworkParser> parsers = [new GrailsFrameworkParser()]
	
	/**
	 * TODO logger required
	 * @param dir
	 * @return
	 */
	FrameworkParser getParser(File dir){
		FrameworkParser compatableParser = null; 
		for(FrameworkParser parser: parsers){
			if(parser.isParseable(dir)){
					compatableParser = parser
					break
			}
		}
		if(!compatableParser){
			println ("No framework found for $dir")
		}
		return compatableParser
	}
}
