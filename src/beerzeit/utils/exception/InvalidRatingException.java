package beerzeit.utils.exception;

/**
 * Created by pedro on 27/11/16.
 */
public class InvalidRatingException extends Exception {
    public InvalidRatingException() {
        super("Avaliação tem que ser entre 1 e 5");
    }
}
