package fr.epita.assistants.throwback;

public class PositiveIntegerException extends IntegerException {
    PositiveIntegerException(String stringArgument) {
        super(String.format("PositiveIntegerException: %s", stringArgument));
    }
}
