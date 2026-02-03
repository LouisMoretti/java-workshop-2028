package fr.epita.assistants;

import fr.epita.assistants.observer.Lifeguard;
import fr.epita.assistants.observer.Swimmer;
import fr.epita.assistants.observer.SwimmerStatus;

public class Main {

    public static void main(String[] args) {
        final var swimmer = new Swimmer("Swimmer");
        final var swimmer2 = new Swimmer("Swimmer2");
        final var lifeguard = new Lifeguard("Lifeguard");
        final var lifeguard2 = new Lifeguard("Lifeguard2");

        swimmer.register(lifeguard);
        swimmer.register(lifeguard2);

        swimmer2.register(lifeguard);
        swimmer2.register(lifeguard2);

        swimmer.setStatus(SwimmerStatus.DROWNING);

        swimmer2.setStatus(SwimmerStatus.TOO_FAR);
    }
}
