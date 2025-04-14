package markova.exceptions;

public class NetworkConnectionException extends Exception {
    public NetworkConnectionException() {
            super();
    }
    public NetworkConnectionException(String message) {
            super(message);
    }
    public NetworkConnectionException(Throwable cause) {
        super(cause);
    }
    public NetworkConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
