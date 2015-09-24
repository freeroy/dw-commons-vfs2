package org.developerworld.commons.vfs2.impl;

import java.io.File;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.vfs2.CacheStrategy;
import org.apache.commons.vfs2.FileContentInfoFactory;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FilesCache;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.FileReplicator;
import org.apache.commons.vfs2.provider.TemporaryFileStore;
import org.developerworld.commons.vfs2.FileSystemManagerFactory;

/**
 * 通用文件系统管理器工厂
 * 
 * @author Roy Huang
 * @version 20140317
 * 
 */
public class StandardFileSystemManagerFactory implements
		FileSystemManagerFactory<StandardFileSystemManager> {

	public StandardFileSystemManager buildFileSystemManager(
			Map<String, Object> config) throws FileSystemException {
		StandardFileSystemManager rst = new StandardFileSystemManager();
		if (config.containsKey("classLoader"))
			rst.setClassLoader((ClassLoader) config.get("classLoader"));
		if (config.containsKey("configUri"))
			rst.setConfiguration((String) config.get("configUri"));
		if (config.containsKey("filesCache"))
			rst.setFilesCache((FilesCache) config.get("filesCache"));
		if (config.containsKey("cacheStrategy"))
			rst.setCacheStrategy((CacheStrategy) config.get("cacheStrategy"));
		if (config.containsKey("fileContentInfoFactory"))
			rst.setFileContentInfoFactory((FileContentInfoFactory) config
					.get("fileContentInfoFactory"));
		if (config.containsKey("fileObjectDecorator"))
			rst.setFileObjectDecorator((Class) config
					.get("fileObjectDecorator"));
		if (config.containsKey("replicator"))
			rst.setReplicator((FileReplicator) config.get("replicator"));
		if (config.containsKey("temporaryFileStore"))
			rst.setTemporaryFileStore((TemporaryFileStore) config
					.get("temporaryFileStore"));
		if (config.containsKey("logger"))
			rst.setLogger((Log) config.get("logger"));
		rst.init();
		// 这里需要后期再执行
		if (config.containsKey("baseFile"))
			rst.setBaseFile((File) config.get("baseFile"));
		return rst;
	}

}
