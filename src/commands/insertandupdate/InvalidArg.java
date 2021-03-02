package commands.insertandupdate;

public class InvalidArg extends RuntimeException {
    InvalidArg(String message) {
        super(message);
    }
}
