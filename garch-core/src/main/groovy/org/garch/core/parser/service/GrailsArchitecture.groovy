package org.garch.core.parser.service

import org.garch.core.parser.service.grails.Dependencies

class GrailsArchitecture extends Architecture {
	
	String grailsVersion
	String appName
	String appVersion
	Dependencies dependencies 
	
	String describe(){	
	   return "$grailsVersion $appName $appVersion"
	}
	
	
}
