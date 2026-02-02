package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.factorial(5) + " Expected: " + expected);
        String yaki1 = "yk r h best";
        String yaki2 = "aiaete";
        String expected2 = "yaki are the best";
        if (!Classics.combine(yaki1, yaki2).equals(expected2)) {
            System.err.println("Error combine(\"" + yaki1 + "\", \"" + yaki2 + "\")" +
                    "-> Actual: " + Classics.combine(yaki1, yaki2) + " Expected: " + expected2);
        }

        // FIXME: Add more tests here
    }
}
