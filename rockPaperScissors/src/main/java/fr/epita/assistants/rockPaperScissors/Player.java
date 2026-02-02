package fr.epita.assistants.rockPaperScissors;

public final class Player {
    String name;
    int choice;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public HandShape getPlayerHandShape() {
        return new HandShape(choice);
    }
}
