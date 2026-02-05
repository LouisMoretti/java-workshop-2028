package fr.epita.assistants.exceptions;

public class InvalidNameException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param name the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InvalidNameException(String name) {
        super("InvalidNameException: " + name);
    }
}
