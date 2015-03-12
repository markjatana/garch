package org.garch.core.parser.service

class GrailsArchitectureService {
	
	public static String APP_FILE = "applications.properties"
	
	Collection<GrailsArchitecture> generateArch(String... projectLocations){
		def arches = []
	    projectLocations.each {
			GrailsArchitecture arch
			Properties props = new Properties()
			new File(it, APP_FILE).withInputStream(){props.load(it)}
			arch.grailsVersion = props.getProperty("app.grails.version")
		    arch.appName = props.getProperty("app.name")
			arch.appVersion = props.getProperty("app.version")
			arches << arch
	    }			
		return arches
	}
	
}
