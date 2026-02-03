package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer> {
    Set<Observer<Swimmer>> observers;
    String name;
    SwimmerStatus status;

    public Swimmer(String name) {
        this.name = name;
        observers = new HashSet<>();
        status = SwimmerStatus.OK;

        System.out.printf(name + " goes into the sea.\n");
    }

    public String getName() {
        return name;
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    public void setStatus(SwimmerStatus status) {
        this.status = status;

        if (status == SwimmerStatus.DROWNING) {
            System.out.printf(name + ": I'm drowning, help!!\n");
        } else if (status == SwimmerStatus.WAVING) {
            System.out.printf(name + ": Waves towards the shore.\n");
        }
        fire(this);
    }

    /**
     * Get all registered observers.
     *
     * @return The set of observers
     */
    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return observers;
    }

    /**
     * Register observers.
     *
     * @param observers Observers to register
     */
    @Override
    public void register(Observer<Swimmer>... observers) {
        for (Observer<Swimmer> observer : observers) {
            this.observers.add(observer);
        }
    }

    /**
     * Unregister the given observer.
     *
     * @param observer The observer to deactivate
     */
    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }

    /**
     * Notify all registered observers of the given event.
     *
     * @param event The event to notify observers with.
     */
    @Override
    public void fire(Swimmer event) {
        for (Observer<Swimmer> observer : observers) {
            observer.onEvent(event);
        }
    }
}
