package app;

import java.util.Arrays;
import java.util.List;

/**
 * Class static attributes that represent the messages, file type, and
 * parameters supported by the system.
 *
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public class SystemConstants {

	// **************************************************
	// Constants
	// **************************************************

	/**
	 * Representation of system supported file types
	 */
	public static final String FILE_TYPE_PDF = "pdf";
	public static final String FILE_TYPE_TXT = "txt";
	public static final String FILE_TYPE_CSV = "csv";
	public static final String FILE_TYPE_HTML = "html";

	/**
	 * System Default Messages
	 */
	public static final String MSG_TRY_H = "Try -h for more information";
	public static final String MSG_NO_COMMAND = "There were no commandline arguments passed \n" + MSG_TRY_H;
	public static final String MSG_COMMAND_INVALID = "Invalid command \n" + MSG_TRY_H;
	public static final String MSG_NO_OPTION = "Unknown option \n" + MSG_TRY_H;
	public static final String MSG_NO_TYPE_FILE = "File Format - Not Entered \n" + MSG_TRY_H;
	public static final String MSG_UNSUPPORTED_FORMAT = "Unsupported format \n" + MSG_TRY_H;
	public static final String MSG_INVALID_FILE = "Invalid source file";
	public static final String MSG_SYS_ERR = "General system error";
	public static final String MSG_SUCCESS = "SUCCESSFUL execution";
	public static final String MSG_FUNC_NOT_IMPL = "Functionality not implemented";
	public static final String MSG_DEST_NOT_VALID = "Destination file is not valid";
	public static final String MSG_COMMAND_HELP = "usage: <command name> [-] <option> <arguments> \n"
			+ "Available commands: merge, copy, move, delete, convert \n\n" + "Available Options: \n"
			+ "-h,\t\t\t\t\t help \n" + "-f, \t<file type> \t\t\t source file type \n"
			+ "-t, \t<target file name> \t\t new file that will be create \n"
			+ "-s, \t<source file names> \t\t list list of source files";
	/**
	 * System Supported Commands
	 */
	public static final String COMMAND_MERGE = "merge";

	/** Command Options */
	public static final String OPTION_SOURCE = "s";
	public static final String OPTION_TARGET = "t";
	public static final String OPTION_HELP = "h";
	public static final String OPTION_FILE_TYPE = "f";

	/** List of commands supported by the system */
	public static final List<String> availableCommands = Arrays.asList(COMMAND_MERGE);
	/** List of command Options */
	public static final List<String> availableOptions = Arrays.asList(OPTION_SOURCE, OPTION_TARGET, OPTION_HELP,
			OPTION_FILE_TYPE);
	

}
