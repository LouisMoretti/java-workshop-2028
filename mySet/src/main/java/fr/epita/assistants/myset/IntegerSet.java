package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Objects;

public class IntegerSet {
    ArrayList<Integer> base;

    public IntegerSet() {
        this.base = new ArrayList<>();
    }

    private int findPlace(Integer i) {
        int min = 0;
        int max = base.size() - 1;
        int mid = max / 2;

        while (min < max) {
            mid = (min + max) / 2;
            if (i.intValue() == base.get(mid).intValue()) {
                return mid;
            } else if (i < base.get(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return mid;
    }

    public void insert(Integer i) {
        base.add(findPlace(i), i);
    }

    public void remove(Integer i) {
        int place = findPlace(i);
        if (!Objects.equals(base.get(place), i))
            return;

        base.remove(place);
    }

    public boolean has(Integer i) {
        return base.contains(i);
    }

    public boolean isEmpty() {
        return base.isEmpty();
    }

    public Integer min() {
        return base.getFirst();
    }

    public Integer max() {
        return base.getLast();
    }

    public int size() {
        return base.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
        return null;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        return null;
    }
}
