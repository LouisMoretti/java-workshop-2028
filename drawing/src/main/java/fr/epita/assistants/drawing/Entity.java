package fr.epita.assistants.drawing;

public abstract class Entity implements Drawable {
    private long id;
    private static long SEQUENCE;

    public Entity() {
        this.id = SEQUENCE;
        SEQUENCE++;
    }

    public long getId() {
        return id;
    }
}
