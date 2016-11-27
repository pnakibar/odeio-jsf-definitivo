package beerzeit.utils.exception;

/**
 * Created by pedro on 27/11/16.
 */
public class InvalidUserException extends Exception {
    public InvalidUserException() {
        super("Email e/ou senha errados");
    }
}
