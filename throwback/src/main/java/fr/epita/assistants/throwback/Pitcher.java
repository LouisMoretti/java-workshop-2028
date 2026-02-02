package fr.epita.assistants.throwback;

public class Pitcher {
    private static boolean checkInt(String message) {
        int i = 0;
        if (message.charAt(0) == '-')
            i++;
        if (i >= message.length())
            return false;
        for (; i < message.length(); i++) {
            char c = message.charAt(i);
            if (!(c >= '0' && c <= '9'))
                return false;
        }

        return true;
    }

    private static boolean checkSentence(String message) {
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '.' || c == ',' || c == '\'' || c == ' '))
                return false;
        }

        return true;
    }

    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException {
        if (message == null || message.isEmpty()) {
            throw new ShortStringException(message);
        } else if (checkInt(message)) {
            if (message.charAt(0) == '-') throw new NegativeIntegerException(message);
            else throw new PositiveIntegerException(message);
        } else if (checkSentence(message)) {
            if (message.length() >= 100) throw new LongStringException(message);
            else throw new ShortStringException(message);
        } else {
            throw new UnknownException(message);
        }
    }
}
