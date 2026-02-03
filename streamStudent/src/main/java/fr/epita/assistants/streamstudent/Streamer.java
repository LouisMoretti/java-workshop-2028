package fr.epita.assistants.streamstudent;

import java.util.Optional;
import java.util.stream.Stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(integerStringPair -> integerStringPair.getKey() <= 100
                        && integerStringPair.getKey() >= 0)
                .filter(integerStringPair ->
                        integerStringPair.getValue().matches("[^._]+(.|_)[^._]+"));
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted((p1, p2) ->
        {
            int c = p1.getKey().compareTo(p2.getKey());
            if (c != 0)
                return c;
            return p1.getValue().compareTo(p2.getValue());
        });
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(integerStringPair -> {
            if (integerStringPair.getValue().toLowerCase() != integerStringPair.getValue()) {
                return new Pair<>(integerStringPair.getKey() / 2, integerStringPair.getValue().toLowerCase());
            }
            return integerStringPair;
        });
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.max((p1, p2) ->
        {
            int c = p1.getKey().compareTo(p2.getKey());
            if (c != 0)
                return c;
            return p2.getValue().compareTo(p1.getValue());
        });
    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(integerStringPair -> {
            if (integerStringPair.getValue().toLowerCase().startsWith("ma")
                    || (integerStringPair.getValue().toLowerCase().startsWith("l")
                    && integerStringPair.getValue().toLowerCase().endsWith("x"))) {
                return new Pair<>(integerStringPair.getKey() * 2 > 100 ? 100 : integerStringPair.getKey() * 2,
                        integerStringPair.getValue());
            }
            return integerStringPair;
        });
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(integerStringPair -> {
                    int len = integerStringPair.getValue().length();
                    String base = integerStringPair.getValue();
                    String encrypted = base.substring(len / 2 + 1, len) + base.substring(0, len / 2 + 1);
                    return new Pair<>(integerStringPair.getKey(), encrypted);
                }
        );
    }
}
