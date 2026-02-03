package fr.epita.assistants.creatureInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mermaid extends Creature implements Swimmer, Magical, Speaker {
    int mana;
    List<Spell> spells;

    /**
     * The name of the Mermaid is the name of the BaseHuman (with
     * only the first letter being uppercase) concatenated with the
     * Fish name (without uppercase letters).
     * <p>
     * If the BaseHuman is a Mage, all the mage’s spells that are learnable by
     * a mermaid become the mermaid’s spells.
     * Furthermore, for each spell the mermaid cannot learn, it should print
     * to the standard output:
     * "<name> forgot the spell <spellName>."
     * <p>
     * Its swimmingState depends only on the human’s swimmingState.
     * Its initial mana is 0.
     */
    public Mermaid(BaseHuman baseHuman, Fish fish) {
        super(baseHuman.getName().substring(0, 1).toUpperCase() + baseHuman.getName().substring(1).toLowerCase() + fish.getName().toLowerCase());

        this.mana = 0;
        this.spells = new ArrayList<>();
        if (baseHuman instanceof Mage) {
            for (Spell spell : ((Mage) baseHuman).getSpells()) {
                if (spell.getSpellType() == SpellType.FIRE) {
                    System.out.printf("%s forgot the spell %s.\n", name, spell.name());
                } else {
                    addSpell(spell);
                }
            }
        }

        this.isSwimming = baseHuman.getSwimmingState();
    }

    /**
     * Get the mana of the creature.
     *
     * @return The mana of the creature
     */
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

        if (spell.getSpellType() == SpellType.FIRE) {
            System.out.printf("Mermaid cannot learn %s spells.\n", spell.name());
        } else {
            spells.add(spell);
        }
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

    /**
     * Regenerate an amount of mana.
     *
     * @param mana The amount of mana to regenerate
     */
    @Override
    public void regenMana(int mana) {
        if (getSwimmingState()) {
            this.mana += (int) (mana * 0.9);
        } else {
            this.mana += mana;
        }
    }

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    @Override
    public void hello() {
        System.out.printf("Hello, my name is " + name + " and I'm a " + this.getClass().getSimpleName() + ".\n");
    }

    /**
     * Greets the contact
     * The default implementation greets the contact based on its type
     *
     * @param contact the creature to greet
     */
    @Override
    public void greet(Speaker contact) {
        if (contact instanceof Mermaid) {
            System.out.printf("Dear " + ((Mermaid) contact).name + ", welcome.\n");
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
        System.out.printf("I'm a %s and I'm swimming.\n", this.getClass().getSimpleName());
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
