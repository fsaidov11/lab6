package common.exceptions;

public class InvalidDataFromFileException extends Exception {
    /**
     * Constructs {@code InvalidDataFromFileException} object.
     */
    public InvalidDataFromFileException() {
    }

    /**
     * Constructs {@code InvalidDataFromFileException} object.
     *
     * @param message contains detailed information about the mistake.
     */
    public InvalidDataFromFileException(String message) {
        super(message);
    }
}
