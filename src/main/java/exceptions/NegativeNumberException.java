package exceptions;

public class NegativeNumberException extends RuntimeException {


    public static final String NEGATIVES_NOT_ALLOWED = "negatives not allowed:";

    public NegativeNumberException(String numbers) {
        super(NEGATIVES_NOT_ALLOWED + numbers);
    }

}
