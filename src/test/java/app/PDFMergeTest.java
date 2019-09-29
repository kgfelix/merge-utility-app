package app;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test Class for File Merge Process
 *
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-26
 */
public class PDFMergeTest {

    /**
     * Test that validates if the merge process was performed successfully.
     */
    @Test
    public void testMergeTwoFilesSuccess() {
        String[] args = { "merge", "-f", "pdf", "-t", "c:\\svn\\maria.pdf", "-s", "c:\\svn\\teste4.pdf",
                "c:\\svn\\file.pdf" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("SUCCESSFUL"));
    }

    /**
     * Test text of help option (-h)
     */
    @Test
    public void testHelpOption() {
        String[] args = { "-h" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("Available commands: merge, copy, move, delete, convert"));
    }

    /**
     * Test that validates the error message if the user does not enter the
     * destination file name with the -t option
     */
    @Test
    public void testMergeMissingDestination() {
        String[] args = { "merge", "-f", "pdf", "-s", "c:\\svn\\teste4.pdf", "c:\\svn\\file.pdf" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("Destination file is not valid"));
    }

    /**
     * 
     * Test that validates the error message if the user does not enter valid
     * destination files for merge. The names of the destination files are given in
     * the -s option.
     */
    @Test
    public void testMergeMissingSource() {
        String[] args = { "merge", "-f", "pdf", "-t", "c:\\svn\\maria.pdf", "-s", "c:\\svn\\teste45.pdf",
                "c:\\svn\\file55.pdf" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("Invalid source file"));
    }

    /**
     * Test that validates if parameter indicating source file type was not sent
     */
    @Test
    public void testMissingFileFormat() {
        String[] args = { "merge", "-s", "c:\\svn\\teste4.pdf", "c:\\svn\\file.pdf" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("File Format - Not Entered"));
    }

    /**
     * 
     * Test that validates the error message when the command name is sent wrong.
     */
    @Test
    public void testInvalidCommand() {
        String[] args = { "mere", "-f", "-t", "c:\\svn\\maria.pdf", "-s", "c:\\svn\\teste4.pdf", "c:\\svn\\file.pdf" };
        final String testString = (new CommandLine()).processAction(args);
        Assert.assertTrue(testString.contains("Invalid command"));
    }

}