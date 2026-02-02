package fr.epita.assistants.throwback;

public abstract class StringException extends Exception {
    StringException(String stringArgument) {
        System.err.printf("StringException: %s", stringArgument);
    }
}
