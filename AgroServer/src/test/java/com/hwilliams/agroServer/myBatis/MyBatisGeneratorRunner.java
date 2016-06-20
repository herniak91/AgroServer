package com.hwilliams.agroServer.myBatis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorRunner {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando myBatisGenerator");
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("C:/Users/Hernan/AgroApp/git/AgroServer/AgroServer/src/main/resources/myBatis/myBatisGeneratorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("Finalizacion myBatisGenerator");
	}

}
