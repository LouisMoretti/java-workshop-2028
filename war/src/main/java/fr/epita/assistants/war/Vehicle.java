package fr.epita.assistants.war;

public class Vehicle extends Combatant {
    private String name;
    private int defense;

    public Vehicle(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    @Override
    public void printState() {
        System.out.printf("I have %d defense points.\n", defense);
    }

    @Override
    void attack(Soldier s) {
        s.kill();
    }

    @Override
    void attack(Vehicle v) {
        v.defense /= 2;
    }

    @Override
    void scream() {
        System.out.printf("I'm %s!\n", name);
    }
}
