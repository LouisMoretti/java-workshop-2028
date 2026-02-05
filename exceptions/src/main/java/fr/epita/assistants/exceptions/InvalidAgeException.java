package fr.epita.assistants.exceptions;

public class InvalidAgeException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param age the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InvalidAgeException(int age) {
        super("InvalidAgeException: " + age);
    }
}
