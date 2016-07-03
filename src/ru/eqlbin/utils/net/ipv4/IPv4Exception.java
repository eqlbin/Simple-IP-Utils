package ru.eqlbin.utils.net.ipv4;

public class IPv4Exception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IPv4Exception() {}

    public IPv4Exception(String message) {
        super(message);
    }

    public IPv4Exception(Throwable cause) {
        super(cause);
    }

    public IPv4Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public IPv4Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
