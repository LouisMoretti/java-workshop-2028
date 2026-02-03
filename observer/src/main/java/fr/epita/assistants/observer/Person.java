package fr.epita.assistants.observer;

public class Person implements Observable.Observer<Swimmer> {
    String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * Notification callback.
     *
     * @param event The event being sent
     */
    @Override
    public void onEvent(Swimmer event) {
        System.out.printf(name + ": Waves back at " + event.name + ".\n");
    }
}
