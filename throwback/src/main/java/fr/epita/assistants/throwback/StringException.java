package fr.epita.assistants.throwback;

public abstract class StringException extends Exception {
    StringException(String stringArgument) {
        super(String.format("StringException: %s", stringArgument));
    }
}
