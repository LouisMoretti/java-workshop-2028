package fr.epita.assistants.rockPaperScissors;

import java.util.Random;

public class Bot {
    final String name;

    public Bot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final HandShape getBotHandShape() {
        Random random = new Random();
        int choice = random.nextInt() % 3;
        return new HandShape(choice);
    }
}
