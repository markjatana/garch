package org.garch.core.parser.service

import org.garch.core.parser.service.grails.BuildConfig
import org.garch.core.parser.service.grails.Dependencies
import org.garch.core.parser.service.grails.Dependency

class GrailsFrameworkParser extends FrameworkParser {
	
	public static String APP_FILE = "application.properties"
	public static String CONFIG_DIR_PATH = "grails-app/conf"
	public static String BUILD_CONFIG_FILE_NAME = "BuildConfig.groovy"
	public static String CONFIG_FILE_NAME = "Config.groovy"

	private File projectLocation
	 
	private ConfigObject config
	
	private GrailsArchitecture arch = new GrailsArchitecture();
	
	GrailsArchitecture generateArch(File projectLocation){
		this.projectLocation = projectLocation
		parseConfig()
		getAppDetails();		
		getDependencies()
		getAppGroupInfo()
		return arch;
	}
	
	public String getAppGroupInfo(){
	 	arch.appGroup =  config.grails.project.groupId
	}
	
	private ConfigObject parseConfig(){
		File configFile = new File(new File(projectLocation,CONFIG_DIR_PATH),CONFIG_FILE_NAME)
		config = new ConfigSlurper().parse(configFile.toURI().toURL());
	}
	
	public GrailsArchitecture getAppDetails(){
		Properties props = new Properties()
		File appProps = new File(projectLocation, APP_FILE)
		println appProps.absolutePath
		appProps.withInputStream(){props.load(it)}
		arch.grailsVersion = props.getProperty("app.grails.version")
		arch.appName = props.getProperty("app.name")
		arch.appVersion = props.getProperty("app.version")
		arch.appGroup = props.getProperty("app.group")
		return arch;
	}
	
	public void getDependencies(){
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
