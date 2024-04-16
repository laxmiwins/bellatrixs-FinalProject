package com.cucumberproject.config;

import com.cucumberproject.utilities.FileUtil;

public class Configuration {
	FileUtil file=new FileUtil();
	public String getAppUrl(String env) {
		
		return file.getProperty("/src/test/resources/config.properties","app."+env+".url");
	}

	public String getBrowserName() {
		return file.getConfiguration("browser_name");
		
	}

	public String getExecutionMode() {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/test/resources/config.properties", "execution_mode");
	}
	
	
}
