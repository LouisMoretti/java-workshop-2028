package fr.epita.assistants.creatureInterface;

import java.util.List;

/**
 * This interface provides communication methods for the objects of the class
 * that implements it. Classes adopting this interface instantiate objects
 * capable of communication.
 */
public interface Speaker {
    /**
     * Returns the name of the object that can speak
     */
    String getName();

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    void hello();

    /**
     * Greets the contact
     * The default implementation greets the contact based on its type
     * @param contact the creature to greet
     */
    default void greet(Speaker contact) {
        if (contact instanceof Mage) {
            System.out.printf("Salutations " + ((Mage) contact).name + ", keeper of Arcane secrets.\n");
        } else if (contact instanceof Human) {
            System.out.printf("Salutations " + ((Human) contact).name + " the human.\n");
        } else {
            System.out.printf("Salutations " + ((Mermaid) contact).name + ", keeper of the Seas.\n");
        }
    }


    /**
     * Allows all speakers in the collection to say hello as explained in the hello() method
     * @param speakers the list of creatures that can speak
     */
    static void helloAll(List<Speaker> speakers) {
        for (Speaker speaker : speakers) {
            speaker.hello();
        }
    }
}
