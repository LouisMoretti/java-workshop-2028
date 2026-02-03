package fr.epita.assistants.creatureInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mage extends BaseHuman implements Magical{
    int mana;
    List<Spell> spells;

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    public Mage(String name, int mana) {
        super(name);
        this.mana = mana;
        this.spells = new ArrayList<>();
    }

    @Override
    public void greet(Speaker contact) {
        if (contact instanceof Mage) {
            System.out.printf("I welcome you, " + ((Mage) contact).name + ".\n");
        } else {
            super.greet(contact);
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

    /**
     * Get the spells of the creature.
     *
     * @return The spells of the creature
     */
    @Override
    public Collection<Spell> getSpells() {
        return spells;
    }

    /**
     * Add a spell to the creature.
     * If the spell is already present, it will not be added.
     * Be sure to check that the creature <strong>can</strong> learn the spell before adding it.
     * Prints a message if the creature cannot learn the spell.
     *
     * @param spell The spell to add
     */
    @Override
    public void addSpell(Spell spell) {
        if (spells.contains(spell))
            return;

        spells.add(spell);
    }

    /**
     * Cast a spell.
     * If the creature knows the spell and has enough mana, the spell is cast.
     * Otherwise, prints a message indicating the reason.
     *
     * @param spell The spell to cast
     */
    @Override
    public void castSpell(Spell spell) {
        if (!spells.contains(spell)) {
            System.out.printf("%s does not know %s.\n", name, spell.name());
        } else if (spell.getManaCost() >= mana) {
            System.out.printf("%s does not have enough mana.\n", name);
        } else {
            mana -= spell.getManaCost();
            System.out.printf("%s casts %s.\n", name, spell.name());
        }
    }

    @Override
    public void regenMana(int mana) {
        if (getSwimmingState()) {
            this.mana += (int) (mana * 0.9);
        } else {
            this.mana += mana;
        }
    }
}
