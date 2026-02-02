package fr.epita.assistants.throwback;

public class UnknownException extends Exception {
    UnknownException(String stringArgument) {
        System.err.printf("UnknownException: %s", stringArgument);
    }
}
