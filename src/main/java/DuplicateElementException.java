public class DuplicateElementException extends Exception {
    public DuplicateElementException() {
        super("There can not be Duplicate elements");
    }

    public DuplicateElementException(String message) {
        super(message);
    }
}

