package org.garch.core.parser.service

class GrailsArchitectureService {
	
	public static String APP_FILE = "applications.properties"
	
	GrailsArchitecture generateArch(String... projectLocations){
		GrailsArchitecture arch
	    projectLocations.each {
			Properties props = new Properties()
			new File(it, APP_FILE).withInputStream(){props.load(it)}
			arch.grailsVersion = props.getProperty("app.grails.version")
		    arch.appName = props.getProperty("app.name")
			arch.version = props.getProperty("app.version")
	    }			
	}
	
}
