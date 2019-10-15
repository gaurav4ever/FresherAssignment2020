package assignment1.exceptions;

class InvalidCommandLineArgument extends RuntimeException {
    public InvalidCommandLineArgument(String message) {
        super(message);
    }
    public InvalidCommandLineArgument() {
    }
}
