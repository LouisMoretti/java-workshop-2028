package fr.epita.assistants;

import fr.epita.assistants.logger.Logger;
import fr.epita.assistants.singleton.SingletonEnumLogger;

public class Main {
    public static void main(String[] args) {
        final var logger = SingletonEnumLogger.INSTANCE; // or StaticSingletonLogger.getInstance()

        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());

        logger.log(Logger.Level.INFO, "Logger instantiated");
        logger.log(Logger.Level.WARN, "This is a warning message");

        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());

        logger.log(Logger.Level.ERROR, "This is an error message");

        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());

        logger.reset();

        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());
    }
}