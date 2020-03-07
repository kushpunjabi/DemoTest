package com.technocredits.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileOperation {
	Properties prop;

	public PropertyFileOperation(String path) throws IOException {
		// open file
		File file = new File(path);
		// enable readable mode
		FileInputStream input = new FileInputStream(file);
		// load prob file into memory
		prop = new Properties();
		prop.load(input);

	}

	public String readProp(String key) throws IOException {
		// get value for given key
		String value = prop.getProperty(key);
		// return value
		return value;

	}
	
	

}
