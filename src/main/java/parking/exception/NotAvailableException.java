package parking.exception;

public class NotAvailableException extends Exception{

    public NotAvailableException() {
        super();
    }

    public NotAvailableException(String s) {
        super(s);
    }

    public NotAvailableException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotAvailableException(Throwable throwable) {
        super(throwable);
    }
}
