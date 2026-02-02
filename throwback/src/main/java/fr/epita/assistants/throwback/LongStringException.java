package fr.epita.assistants.throwback;

public class LongStringException extends StringException {
    public LongStringException(String stringArgument) {
        super(String.format("LongStringException: %s (length: %d)", stringArgument, stringArgument.length()));
    }
}
