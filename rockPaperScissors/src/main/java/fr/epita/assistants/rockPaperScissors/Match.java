package fr.epita.assistants.rockPaperScissors;

import java.lang.module.FindException;

public final class Match {
    private static int matchCount;
    private final int currentMatchNumber;
    final String player1;
    final String player2;
    final HandShape handShape1;
    final HandShape handShape2;

    public Match(String player1, String player2, HandShape handShape1, HandShape handShape2) {
        matchCount++;
        this.currentMatchNumber = matchCount;
        this.player1 = player1;
        this.player2 = player2;
        this.handShape1 = handShape1;
        this.handShape2 = handShape2;
    }

    public static int getMatchCount() {
        return matchCount;
    }

    public int getCurrentMatchNumber() {
        return currentMatchNumber;
    }

    public static void resetMatchCount() {
        matchCount = 0;
    }

    public void runMatch() {
        System.out.printf("Let's start match number %d!\n", currentMatchNumber);
        System.out.print("Rock, Paper, Scissors!\n");
        System.out.printf("%s is playing: %s\n", player1, handShape1.getName());
        System.out.printf("%s is playing: %s\n", player2, handShape2.getName());

        if (handShape1.getIndex() == handShape2.getIndex()) {
            System.out.print("DRAW!\n");
        }
        else {
            String winner = ((handShape1.getIndex() - 1) % 3) == handShape2.getIndex() ? player1 : player2;
            System.out.printf("The winner is %s!\n", winner);
        }
    }
}
