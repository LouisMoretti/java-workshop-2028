package fr.epita.assistants.myset;

import java.util.ArrayList;

public class GenericSet<T extends Comparable<T>> {
    ArrayList<T> base;

    public GenericSet() {
        this.base = new ArrayList<>();
    }

    public void insert(T i) {
        int len = base.size();
        int j = 0;
        for (; j < len; j++) {
            if (base.get(j) == i) return;
            if (base.get(j).compareTo(i) > 0) break;
        }

        base.add(j, i);
    }

    public void remove(T i) {
        base.remove(i);
    }

    public boolean has(T i) {
        return base.contains(i);
    }

    public boolean isEmpty() {
        return base.isEmpty();
    }

    public T min() {
        return base.getFirst();
    }

    public T max() {
        return base.getLast();
    }

    public int size() {
        return base.size();
    }

    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> res = new GenericSet<>();

        int size1 = a.size();
        int size2 = b.size();

        for (int i = 0, j = 0; i < size1 && j < size2; ) {
            T aFirst = a.base.get(i);
            T bFirst = b.base.get(j);
            if (aFirst == bFirst) {
                res.insert(a.base.get(i));
                i++;
                j++;
            } else if (aFirst.compareTo(bFirst) < 0) {
                i++;
                if (i >= size1) break;
            } else {
                j++;
                if (j >= size2) break;
            }

        }

        return res;
    }

    public static <T extends Comparable<T>> GenericSet<T> union(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> res = new GenericSet<>();

        int size = a.size();
        for (int i = 0; i < size; i++) {
            res.insert(a.base.get(i));
        }

        size = b.size();
        for (int i = 0; i < size; i++) {
            res.insert(b.base.get(i));
        }

        return res;
    }
}
