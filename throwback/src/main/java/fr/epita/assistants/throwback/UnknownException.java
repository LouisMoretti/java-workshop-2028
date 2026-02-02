package fr.epita.assistants.throwback;

public class UnknownException extends Exception {
    UnknownException(String stringArgument) {
        super(String.format("UnknownException: %s", stringArgument));
    }
}
