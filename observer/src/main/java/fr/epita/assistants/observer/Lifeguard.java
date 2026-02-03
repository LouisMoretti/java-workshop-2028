package fr.epita.assistants.observer;

import java.util.Set;

public class Lifeguard implements Observable.Observer<Swimmer> {
    String name;

    public Lifeguard(String name) {
        this.name = name;

        System.out.printf(name + " begins to keep an eye on the swimmers.\n");
    }

    /**
     * Notification callback.
     *
     * @param event The event being sent
     */
    @Override
    public void onEvent(Swimmer event) {
        if (event.status == SwimmerStatus.DROWNING) {
            System.out.printf(name + ": I will save you " + event.name + "!\n");
        } else if (event.status == SwimmerStatus.TOO_FAR) {
            System.out.printf(name + ": " + event.name + "! You are too far, come back!\n");
        }
    }
}
