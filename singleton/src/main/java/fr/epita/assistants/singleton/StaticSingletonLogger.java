package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {
    int infoCount, warnCount, errorCount;

    private StaticSingletonLogger() {
        infoCount = 0;
        warnCount = 0;
        errorCount = 0;
    }

    private static class InstanceHolder {
        private static final StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
    }

    public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        String log = Logger.getFormattedLog(level, message);
        System.err.println(log);

        if (level == Level.INFO) {
            infoCount++;
        } else if (level == Level.WARN) {
            warnCount++;
        } else {
            errorCount++;
        }
    }

    @Override
    public int getInfoCounter() {
        return infoCount;
    }

    @Override
    public int getWarnCounter() {
        return warnCount;
    }

    @Override
    public int getErrorCounter() {
        return errorCount;
    }

    @Override
    public void reset() {
        infoCount = 0;
        warnCount = 0;
        errorCount = 0;
    }
}
