package app;

import java.util.LinkedHashSet;
import java.util.Set;

import app.entity.FileSystem;
import app.entity.Option;
import app.factory.FileSystemFactory;

/**
 * Class responsible for processing the commands given in the console and
 * assigning them to execute the appropriate class for the command.
 *
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public class CommandLine {

	// **************************************************
	// Attributes
	// **************************************************

	/**
	 * Contains the value representing the main command entered on the command line
	 * as "merge", "convert, etc."
	 */
	private String mainCommand;

	/**
	 * Attribute containing the options of the given command, with their arguments.
	 */
	private Set<Option> options;

	/**
	 * Default constructor. Initialize initial attributes
	 */
	public CommandLine() {
		this.options = new LinkedHashSet<Option>();
	}

	// ******************************
	// Private methods
	// ******************************

	/**
	 * The function of the parse method is to identify and convert the command line
	 * arguments to the following attributes "Main Command", "Command Options" and
	 * "Arguments".
	 * 
	 * Returns an empty String on success in the parse process. Returns an error
	 * message if it indicates a failure.
	 */
	private String parse(final String... arguments) {

		/*
		 * Validates if the user entered the arguments in the command line.
		 */
		if (arguments.length == 0) {
			return SystemConstants.MSG_NO_COMMAND;
		}

		this.mainCommand = arguments[0];
		/**
		 * If the option is "h", displays the text and help and aborts processing.
		 */
		if ("-h".equals(this.mainCommand)) {
			return SystemConstants.MSG_COMMAND_HELP;
		}
		/*
		 * Identifies the main command and validates if it is valid.
		 */
		else if (!SystemConstants.availableCommands.contains(this.mainCommand)) {
			return SystemConstants.MSG_COMMAND_INVALID + " " + this.mainCommand;
		}

		int listSize = arguments.length;

		/*
		 * identifies command options "-t", "-f", "-s" etc.
		 */
		Option option = null;
		for (int i = 1; i < listSize; ++i) {
			String current = arguments[i];
			if (current.startsWith("-")) {
				String key = current.substring(1);
				/*
				 * Validates if options are valid
				 */
				if (!SystemConstants.availableOptions.contains(key)) {
					return SystemConstants.MSG_NO_OPTION + " " + key;
				}
				/**
				 * Create object for option
				 */
				option = new Option(key);
			} else {
				/**
				 * Save option arguments
				 */
				option.addParam(current);
			}
			updateOptions(option);
		}

		return "";
	}

	/**
	 * Creates an <Option> object if none exists with the key (Option Name) entered
	 * or updates the object with a new argument if it already exists.
	 * 
	 * @param option
	 */
	private void updateOptions(Option option) {
		this.options.remove(option);
		this.options.add(option);
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Method that returns all arguments of an option of a given command.
	 * 
	 * @param key: Name or letter identifying an option
	 * @return String: with all arguments of one option
	 */
	public String getArguments(String key) {
		for (Option one : options) {
			if (one.getKey().equals(key)) {
				return one.getParams();
			}
		}
		return null;
	}

	/**
	 * Method that processes a user-entered command.
	 * 
	 * @param args: Command Line Arguments
	 * @return Message with processing result
	 */
	public String processAction(final String... args) {

		/*
		 * Performs parse if it encounters any failure messages for processing and
		 * returns the failure message.
		 */
		String parseMsgResult = parse(args);
		if (!parseMsgResult.trim().equals("")) {
			return parseMsgResult;
		}

		/*
		 * Validates whether the source file type was entered. This information is
		 * required to create the correct class for command execution.
		 */
		String argsOpType = this.getArguments(SystemConstants.OPTION_FILE_TYPE);
		if (argsOpType == null) {
			return SystemConstants.MSG_NO_TYPE_FILE;
		}

		/*
		 * Here the DESIGN PATTERN "Factory" is used. The OOP concept is used to
		 * instantiate the proper implementation of FileSystem interface.
		 * 
		 * Returns an error if no implementation is found for the given type and file.
		 */
		FileSystem fileSystem = FileSystemFactory.create(argsOpType);
		if (fileSystem == null) {
			return SystemConstants.MSG_UNSUPPORTED_FORMAT;
		}

		/**
		 * Process command given at command line
		 */
		switch (this.mainCommand) {
		/**
		 * Runs the MERGE command
		 */
		case SystemConstants.COMMAND_MERGE:
			return fileSystem.merge(this.getArguments(SystemConstants.OPTION_TARGET),
					this.getArguments(SystemConstants.OPTION_SOURCE));
		default:
			return SystemConstants.MSG_NO_OPTION + " " + this.mainCommand;
		}
	}

	/*
	 * Returns the main command, selected in the parse method.
	 */
	public String getMainCommand() {
		return mainCommand;
	}

}