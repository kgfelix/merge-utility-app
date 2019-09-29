package app.factory;

import app.SystemConstants;
import app.entity.CSVFile;
import app.entity.FileSystem;
import app.entity.HTMLFile;
import app.entity.PDFFile;
import app.entity.TXTFile;

/**
 * Class that implements a "Factory" design pattern, which allows you to create
 * a "FileSystem" object without exposing the creation logic to the client and
 * referring us to the newly created object using a common interface.
 *
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public class FileSystemFactory {

    /**
     * Static method that creates a "FileSystem" object according to the file type
     * sent as a parameter
     * 
     * @param fileType: String  with the name of the file type
     * @return: An implementation of FileSystem interface
     */
    public static FileSystem create(String fileType) {

        if (SystemConstants.FILE_TYPE_PDF.equalsIgnoreCase(fileType)) {
            return new PDFFile();
        } else if (SystemConstants.FILE_TYPE_CSV.equalsIgnoreCase(fileType)) {
            return new CSVFile();
        } else if (SystemConstants.FILE_TYPE_TXT.equalsIgnoreCase(fileType)) {
            return new TXTFile();
        } else if (SystemConstants.FILE_TYPE_HTML.equalsIgnoreCase(fileType)) {
            return new HTMLFile();
        }
        return null;
    }

}