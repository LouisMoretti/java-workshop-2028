package fr.epita.assistants.throwback;

public abstract class IntegerException extends Exception {
    IntegerException(String stringArgument) {
        super(String.format("IntegerException: %s", stringArgument));
    }
}
