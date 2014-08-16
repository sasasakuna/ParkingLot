package parking.exception;

public class InvalidTicketException extends Exception{

    public InvalidTicketException() {
        super();
    }

    public InvalidTicketException(String s) {
        super(s);
    }

    public InvalidTicketException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidTicketException(Throwable throwable) {
        super(throwable);
    }
}
