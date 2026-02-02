package fr.epita.assistants.throwback;

public class ShortStringException extends StringException {
    ShortStringException(String stringArgument) {
        super(String.format("ShortStringException: %s (length: %d)", stringArgument, stringArgument.length()));
    }
}
