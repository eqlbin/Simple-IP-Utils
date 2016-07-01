package ru.eqlbin.utils.net.ipv4;

public class InvalidSubnetMaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidSubnetMaskException() {}

    public InvalidSubnetMaskException(String message) {
        super(message);
    }

    public InvalidSubnetMaskException(Throwable cause) {
        super(cause);
    }

    public InvalidSubnetMaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSubnetMaskException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
