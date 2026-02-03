package fr.epita.assistants;

import fr.epita.assistants.creatureInterface.*;

public class Main {
    public static void main(String[] args) {
        Mage mage = new Mage("Icien", 100);
        Fish fish = new Fish("Bob");
        Mermaid bob = new Mermaid(mage, fish);


        bob.greet(mage);
        mage.greet(bob);
        bob.addSpell(Spell.FIREBALL);
        bob.addSpell(Spell.TIDAL_WAVE);
        System.out.println(bob.getMana());
        bob.regenMana(150);
        System.out.println(bob.getMana());
        bob.castSpell(Spell.TIDAL_WAVE);
        bob.castSpell(Spell.HEAL);
        bob.regenMana(17);
        System.out.println(bob.getMana());
        bob.castSpell(Spell.TIDAL_WAVE);
        System.out.println(bob.getMana());
        bob.hello();

        Spell.HEAL.what();
    }
}