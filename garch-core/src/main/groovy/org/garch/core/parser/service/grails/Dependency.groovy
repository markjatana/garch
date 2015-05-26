package org.garch.core.parser.service.grails;

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
public class Dependency {
	
	def group
	def name
	def version
	
	def getFullyQualifiedName(){
		return "$group:$name:$version"
	}
}
