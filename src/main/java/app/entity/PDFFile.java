package app.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import app.SystemConstants;

/**
 * Representation of a PDF File. Contains the implementation of the methods
 * responsible for handling this type of file.
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public class PDFFile implements FileSystem {

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

	/**
	 * Merge between one or more files of the same type
	 * 
	 * @param targeFileName: target file name
	 * @param sourceFiles:   List os source files split by spaces
	 * @return: message with the result of merge
	 */
	public String merge(String targeFileName, String sourceFiles) {

		// Default message
		String returnMsg = SystemConstants.MSG_SYS_ERR;
		// Attribute that temporarily stores the name of the source file being parsed
		String fileNameTmp = "";
		// Indicates whether the processing file is valid
		boolean fileValid = true;

		/**
		 * Validates if the destination file has a name and is valid.
		 */
		if (targeFileName == null || !Paths.get(targeFileName).isAbsolute()) {
			fileValid = false;
			returnMsg = SystemConstants.MSG_DEST_NOT_VALID;
		}

		try {

			//Utility for merge PDF files
			PDFMergerUtility ut = new PDFMergerUtility();

			/** Interact on all source files to verify that they exist and are valid */
			for (String p : sourceFiles.split(" ")) {
				fileNameTmp = p;
				Path pathTemp = Paths.get(fileNameTmp);
				/**If not a valid file returns an error */
				if (!Files.exists(pathTemp)) {
					returnMsg = SystemConstants.MSG_INVALID_FILE + ": "+fileNameTmp;
					fileValid = false;
					break;
				}
				// Add source file to merge process
				ut.addSource(pathTemp.toFile());
			}
			/**
			 * If all files are valid execute merge process and 
			 * return success
			 */
			if (fileValid) {
				ut.setDestinationFileName(targeFileName);
				ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
				returnMsg = SystemConstants.MSG_SUCCESS;
			}

		} catch (FileNotFoundException e) {
			returnMsg = SystemConstants.MSG_SYS_ERR + ": " + e.getMessage();
		} catch (IOException e) {
			returnMsg = SystemConstants.MSG_SYS_ERR + ": " + e.getMessage();

		}
		return returnMsg;
	}

}