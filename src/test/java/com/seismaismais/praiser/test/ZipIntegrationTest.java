package com.seismaismais.praiser.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.seismaismais.praiser.util.FileUtil;
import com.seismaismais.praiser.util.FolderZiper;


public class ZipIntegrationTest {

	@Test
	public void init() throws Exception {

		ClassLoader classLoader = getClass().getClassLoader();
		
		String name = FileUtil.generateUniqueFileName();
		File fileSrc = new File(classLoader.getResource("template/download/offline").getFile());
		File fileDest = new File("/Users/georgeg/Desktop/praizer/"+name);
		
		FileUtils.copyDirectory(fileSrc, fileDest);
		
		FolderZiper.zipFolder("/Users/georgeg/Desktop/praizer/" + name, "/Users/georgeg/Desktop/praizer/" + name + ".zip");
		
		FileUtils.forceDelete(fileDest);
		
	}
}
