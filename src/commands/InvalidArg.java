package commands;

public class InvalidArg extends RuntimeException {
    InvalidArg(String message) {
        super(message);
    }
}
