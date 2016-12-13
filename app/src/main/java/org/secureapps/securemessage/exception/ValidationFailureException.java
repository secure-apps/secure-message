package org.secureapps.securemessage.exception;

/**
 * Created by jayanga on 12/14/16.
 */
public class ValidationFailureException extends Exception {

    public ValidationFailureException() {
        super();
    }

    public ValidationFailureException(String message) {
        super(message);
    }

    public ValidationFailureException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
