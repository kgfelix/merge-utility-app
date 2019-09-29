package app.entity;

import app.SystemConstants;

/**
 * Representation of a TXT File.
 * Contains the implementation of the methods responsible for 
 * handling this type of file.
 * 
 * @author      Kleber Felix
 * @version     1.0
 * @since       2019-09-27
 */
public class TXTFile implements FileSystem {

	public String copy() {
		return SystemConstants.MSG_FUNC_NOT_IMPL;
	}

	public String move() {
		return SystemConstants.MSG_FUNC_NOT_IMPL;
	}

	public String delete() {
		return SystemConstants.MSG_FUNC_NOT_IMPL;
	}

	public String convert(FileSystem destination) {
		return SystemConstants.MSG_FUNC_NOT_IMPL;
	}

	public String merge(String targeFileName, String sourceFiles) {
		return SystemConstants.MSG_FUNC_NOT_IMPL;
	}	

}