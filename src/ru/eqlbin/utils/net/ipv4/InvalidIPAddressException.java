package ru.eqlbin.utils.net.ipv4;

public class InvalidIPAddressException extends IPv4Exception {

    private static final long serialVersionUID = 1L;

    public InvalidIPAddressException() {}

    public InvalidIPAddressException(String message) {
        super(message);
    }

    public InvalidIPAddressException(Throwable cause) {
        super(cause);
    }

    public InvalidIPAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIPAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
