package org.developerworld.commons.vfs2;

import java.util.Map;

import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;

/**
 * 
 * 文件系统管理器工厂
 * 
 * @author Roy Huang
 * @version 20140315
 * 
 * @param <T>
 */
public interface FileSystemManagerFactory<T extends FileSystemManager> {

	/**
	 * 构建文件系统管理器
	 * 
	 * @param config
	 * @return
	 * @throws FileSystemException
	 */
	public T buildFileSystemManager(Map<String, Object> config)
			throws FileSystemException;

}
