package fr.epita.assistants.creatureInterface;

public class Fish extends Creature implements Swimmer {
    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.printf("I'm a %s and I'm swimming.", this.getClass().getSimpleName());
    }

    @Override
    public boolean getSwimmingState() {
        return true;
    }

    @Override
    public void emerge() {
        throw new RuntimeException(name + " died.");
    }
}
