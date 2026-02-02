package fr.epita.assistants.war;

public class Soldier extends Combatant {
    private int health;
    private int damage;
    private String scream;

    Soldier() {
        health = 15;
        damage = 3;
        scream = "No pity for losers!";
    }

    protected Soldier(int health, int damage, String scream) {
        this.health = health;
        this.damage = damage;
        this.scream = scream;
    }

    public void kill() {
        health = 0;
    }

    @Override
    public void printState() {
        System.out.printf("I have %d health points.\n", health);
    }

    @Override
    void attack(Soldier s) {
        s.health -= damage;
    }

    @Override
    void attack(Vehicle v) {
        System.out.print("I can't fight this.\n");
    }

    @Override
    void scream() {
        System.out.printf("%s\n", scream);
    }
}
