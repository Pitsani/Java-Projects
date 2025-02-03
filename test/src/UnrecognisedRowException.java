public class UnrecognisedRowException extends Exception {

    private String message;

    public UnrecognisedRowException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
