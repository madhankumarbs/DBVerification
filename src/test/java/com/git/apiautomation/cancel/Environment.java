package com.git.apiautomation.cancel;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:Resources/${env}/ConfigDetails.properties",
	"classpath:Resources/${env}/ConfigDetails.properties" // mention the property file name
})
public interface Environment extends Config {

	String CANCELQUERY();

	String CONSTRING();

	String USR();
	
	String PWD();
	
	String HOST();
	
	String PATH();
	
	int PORT();
	
	String CLPARAM();
}