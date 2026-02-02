package fr.epita.assistants.rockPaperScissors;

import java.util.Arrays;
import java.util.List;

/*
    Note that this kind of class should be replaced with an Enum.
    Enums will be introduced later in the workshop.
 */

public class HandShape {
    final static private List<String> shapesValues = Arrays.asList("ROCK", "PAPER", "SCISSORS");
    final private int index;

    public HandShape(final int index) {
        this.index= index;
    }

    public String getName(){
        return shapesValues.get(index);
    }

    int getIndex() {
        return index;
    }
}