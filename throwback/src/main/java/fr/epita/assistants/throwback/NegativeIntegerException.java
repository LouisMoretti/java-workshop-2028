package fr.epita.assistants.throwback;

public class NegativeIntegerException extends IntegerException {
    NegativeIntegerException(String stringArgument) {
        super(String.format("NegativeIntegerException: %s", stringArgument));
    }
}
