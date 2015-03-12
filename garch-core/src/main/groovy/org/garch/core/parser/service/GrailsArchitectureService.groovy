package org.garch.core.parser.service

class GrailsArchitectureService {
	
	public static String APP_FILE = "application.properties"
	
	Collection<GrailsArchitecture> generateArch(Collection<String> projectLocations){
		def arches = []
	    projectLocations.each {
			GrailsArchitecture arch
			Properties props = new Properties()
			File file = new File(it, APP_FILE)
			new File(it, APP_FILE).withInputStream(){props.load(it)}
			arch.grailsVersion = props.getProperty("app.grails.version")
		    arch.appName = props.getProperty("app.name")
			arch.appVersion = props.getProperty("app.version")
			arches << arch
	    }			
		return arches
	}
	
}
