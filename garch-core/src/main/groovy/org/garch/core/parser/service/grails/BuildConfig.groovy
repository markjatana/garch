package org.garch.core.parser.service.grails

class BuildConfig {

	Dependencies dependencies = new Dependencies()
	
 	void log(String level){
		 
	}
	
	void inherits(String scope){
		
	}
	 
    void checksums(Boolean hasChecksum){ // Whether to verify checksums on resolve
	   
    }

    void repositories(Closure clos){
	   
    }
   
   
	void dependencies(Closure depsClos){
		depsClos.setDelegate(dependencies)
		depsClos()
	}

 
 	void plugins(Closure pluginsClos) {
	 
	}
}