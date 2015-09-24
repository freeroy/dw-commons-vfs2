package org.developerworld.commons.vfs2.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.developerworld.commons.vfs2.FileSystemManagerFactory;
import org.junit.Test;

/**
 * 项目应用测试
 * @author Roy Huang
 * @version 20140314
 *
 */
public class StandardFileSystemManagerFactoryTest {
	
	@Test
	public void testGetFile() throws IOException{
		FileSystemManagerFactory<StandardFileSystemManager> fileSystemManager = buildFileSystemManagerFactory();
		Map<String,Object> config=new HashMap<String,Object>();
		config.put("baseFile",new File("e:/"));
		StandardFileSystemManager manager=fileSystemManager.buildFileSystemManager(config);
		try{
			System.out.println(manager.resolveFile("c://"));
			System.out.println(manager.resolveFile("abc/aaa/c.jsp"));
		}
		finally{
			manager.close();
		}
	}

	private FileSystemManagerFactory<StandardFileSystemManager> buildFileSystemManagerFactory(){
		Map<String,Object> config=new HashMap<String,Object>();
		config.put("baseFile",new File("e:/"));
		StandardFileSystemManagerFactory fileSystemManagerFactory =new StandardFileSystemManagerFactory();
		return fileSystemManagerFactory;
	}
}
