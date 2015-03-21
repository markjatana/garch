package org.garch.core.parser.service

class GrailsFrameworkParser extends FrameworkParser {
	
	public static String APP_FILE = "application.properties"

	GrailsArchitecture generateArch(File projectLocation){		
			GrailsArchitecture arch = new GrailsArchitecture();
			Properties props = new Properties()
			File appProps = new File(projectLocation, APP_FILE)
			println appProps.absolutePath
			appProps.withInputStream(){props.load(it)}
			arch.grailsVersion = props.getProperty("app.grails.version")
		    arch.appName = props.getProperty("app.name")
			arch.appVersion = props.getProperty("app.version")			
			return arch;
	}
	
	Boolean isParseable(File dir){
		return new File(dir, APP_FILE).exists(); 
	}
	
}
