package org.garch.core.parser.service

import org.junit.Test

class GrailsArchitecture extends Architecture {
	
	String grailsVersion
	String appName
	String version

	String describe(){	
	   return "$grailsVersion $appName $version"
	}
}
