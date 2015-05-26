package org.garch.core.parser

import org.garch.core.parser.service.FrameworkParser


class FrameworkParserFactory {
	
	def parsers = ["org.garch.core.parser.service.GrailsFrameworkParser"]
	
	/**
	 * Currently the framework parsers are discovered via a hard-coded string in 
	 * this class.
	 * TODO create a framework parser annotation. 
	 * TODO logger required.
	 * @param dir
	 * @return
	 */
	FrameworkParser getParser(File dir){
		FrameworkParser compatableParser = null; 
		for(String parserClassName: parsers){
			FrameworkParser parser = (FrameworkParser)this.getClass().classLoader.loadClass( parserClassName)?.newInstance()
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
