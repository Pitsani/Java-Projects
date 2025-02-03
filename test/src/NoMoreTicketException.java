public class NoMoreTicketException extends RuntimeException {
    private String eventName;
    public NoMoreTicketException(String eventName) {
        super();
        this.eventName = eventName;
    }
    public String getMessage() {
        return "There is no more tickets for: " + eventName;
    }
}
