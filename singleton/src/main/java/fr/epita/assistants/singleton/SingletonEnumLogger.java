package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public enum SingletonEnumLogger implements Logger {
    INSTANCE;

    int infoCount = 0;
    int warnCount = 0;
    int errorCount = 0;

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
