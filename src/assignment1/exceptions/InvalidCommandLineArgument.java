package assignment1.exceptions;

public class InvalidCommandLineArgument extends RuntimeException {
    public InvalidCommandLineArgument(String message) {
        super(message);
    }
    public InvalidCommandLineArgument() {
    }
}
