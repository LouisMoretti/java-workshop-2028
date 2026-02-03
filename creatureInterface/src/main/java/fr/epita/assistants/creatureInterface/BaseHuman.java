package fr.epita.assistants.creatureInterface;

public abstract class BaseHuman extends Creature implements Swimmer, Speaker {
    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    public BaseHuman(String name) {
        super(name);
    }

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    @Override
    public void hello() {
        System.out.printf("Hello, my name is " + name + " and I'm a " + this.getClass().getSimpleName() + ".\n");
    }

    @Override
    public void greet(Speaker contact) {
        if (contact instanceof Human) {
            System.out.printf("Hello " + ((Human) contact).name + ", how are you?\n");
        } else {
            Speaker.super.greet(contact);
        }
    }

    private boolean isSwimming = false;

    /**
     * Prints "I'm a {CreatureClassName} and I'm swimming."
     */
    @Override
    public void swim() {
        System.out.printf("I'm a %s and I'm swimming.", this.getClass().getSimpleName());
        isSwimming = true;
    }

    /**
     * Returns true if the creature is swimming.
     * It is up to the implementing class to determine the conditions for swimming.
     *
     * @return True if the creature is swimming
     */
    @Override
    public boolean getSwimmingState() {
        return isSwimming;
    }

    /**
     * Emerges from the water.
     */
    @Override
    public void emerge() {
        isSwimming = false;
    }
}
