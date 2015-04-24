package org.garch.core.parser.service

import org.garch.core.parser.service.grails.BuildConfig
import org.garch.core.parser.service.grails.Dependencies
import org.garch.core.parser.service.grails.Dependency

class GrailsFrameworkParser extends FrameworkParser {
	
	public static String APP_FILE = "application.properties"
	public static String CONFIG_DIR_PATH = "grails-app/conf"
	public static String BUILD_CONFIG_FILE_NAME = "BuildConfig.groovy"

	GrailsArchitecture generateArch(File projectLocation){		
		GrailsArchitecture arch = new GrailsArchitecture();
		readApplicationPropertiesFile(projectLocation, arch);		
		getDependencies(projectLocation, arch)
		return arch;
	}
	
	public GrailsArchitecture readApplicationPropertiesFile(File projectLocation, GrailsArchitecture arch){
		Properties props = new Properties()
		File appProps = new File(projectLocation, APP_FILE)
		println appProps.absolutePath
		appProps.withInputStream(){props.load(it)}
		arch.grailsVersion = props.getProperty("app.grails.version")
		arch.appName = props.getProperty("app.name")
		arch.appVersion = props.getProperty("app.version")
		return arch;
	}
	
	public void getDependencies(File projectLocation, GrailsArchitecture arch){
		File buildConfigFile = new File(new File(projectLocation,CONFIG_DIR_PATH),BUILD_CONFIG_FILE_NAME)
		def config = new ConfigSlurper().parse(buildConfigFile.toURI().toURL());
		Closure resolution = config.grails.project.dependency.resolution
		BuildConfig buildConfig = new BuildConfig() 
		resolution.setDelegate(buildConfig)
		resolution()
		arch.dependencies = buildConfig.dependencies
	}
	
	
	Boolean isParseable(File dir){
		return new File(dir, APP_FILE).exists(); 
	}
	
}
