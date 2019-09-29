package app.entity;

/**
 * FileSystem is an abstract base class (interface) which defines the methods
 * for implementing a simple file system. Defines the required methods that
 * application file types must implement.
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public interface FileSystem {

    public abstract String copy();

    public abstract String move();

    public abstract String delete();

    /**
     * 
     * Method responsible for converting the current file type to another type.
     * 
     * @param destination
     * @return
     */
    public abstract String convert(FileSystem destination);

    /**
     * Merge between one or more files of the same type
     * 
     * @param targeFileName: target file name
     * @param sourceFiles:   Lisr os source files split by spaces
     * @return: message with the result of merge
     */
    public abstract String merge(String targeFileName, String sourceFiles);

}