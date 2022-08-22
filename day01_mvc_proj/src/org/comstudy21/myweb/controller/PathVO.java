package org.comstudy21.myweb.controller;

public class PathVO {
	private String path;
	private String fileName;
	private String dirName;
	private String suffix;
	private String prefix;
	public PathVO() {
	      this("","","","","");
	   }

	public PathVO(String path, String fileName, String dirName, String suffix, String prefix) {
	      this.path = path;
	      this.fileName = fileName;
	      this.dirName = dirName;
	      this.suffix = suffix;
	      this.prefix = prefix;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@Override
	   public String toString() {
	      return "path=" + path + 
	            "\nfileName=" + fileName + 
	            "\ndirName=" + dirName + 
	            "\nsuffix=" + suffix + 
	            "\nprefix=" + prefix;
	   }

}
