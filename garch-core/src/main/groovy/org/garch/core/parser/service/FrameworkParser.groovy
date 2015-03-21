package org.garch.core.parser.service

import java.io.File;

abstract class FrameworkParser {

	abstract Architecture generateArch(File projectLocations)

	abstract Boolean isParseable(File dir)
	
}
