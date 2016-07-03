package ru.eqlbin.utils.net.ipv4;

public class InvalidRoutingPrefixLengthException extends IPv4Exception {

    private static final long serialVersionUID = 1L;

    public InvalidRoutingPrefixLengthException() {}

    public InvalidRoutingPrefixLengthException(String message) {
        super(message);
    }

    public InvalidRoutingPrefixLengthException(Throwable cause) {
        super(cause);
    }

    public InvalidRoutingPrefixLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRoutingPrefixLengthException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
