public class DuplicateElementException extends Exception {
    //Should it be RunTimeException?
    public DuplicateElementException() {
        super("There can not be Duplicate elements");
    }

    public DuplicateElementException(String message) {
        super(message);
    }
}

