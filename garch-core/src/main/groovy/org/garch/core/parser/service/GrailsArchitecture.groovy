package org.garch.core.parser.service

import org.garch.core.parser.service.grails.Dependencies

class GrailsArchitecture extends Architecture {
	
	String grailsVersion
	String appName
	String appVersion
	String appGroup
	Dependencies dependencies
	
	String describe(){	
	   return fullyQualifiedName
	}
	
	@Override
	String getName(){
		return fullyQualifiedName 
	}
	
	String getFullyQualifiedName(){
		return "$appGroup:$appName:$appVersion"
	}
}
