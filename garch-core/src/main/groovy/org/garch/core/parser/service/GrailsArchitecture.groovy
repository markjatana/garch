package org.garch.core.parser.service

import org.junit.Test

class GrailsArchitecture extends Architecture {
	
	String grailsVersion
	String appName
	String appVersion

	String describe(){	
	   return "$grailsVersion $appName $appVersion"
	}
}
