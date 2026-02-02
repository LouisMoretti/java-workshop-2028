package fr.epita.assistants.throwback;

public class Pitcher {
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
        int x = Integer.parseInt(message);
        if (x != 0 || message.equals("0")) {
            if (x >= 0) throw new PositiveIntegerException(message);
            else throw new NegativeIntegerException(message);
        } else if (checkSentence(message)) {
            if (message.length() >= 100) throw new LongStringException(message);
            else throw new ShortStringException(message);
        } else {
            throw new UnknownException(message);
        }
    }
}
