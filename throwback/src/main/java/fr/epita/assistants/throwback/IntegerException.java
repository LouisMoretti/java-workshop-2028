package fr.epita.assistants.throwback;

public abstract class IntegerException extends Exception {
    IntegerException(String stringArgument) {
        System.err.printf("IntegerException: %s", stringArgument);
    }
}
