package fr.epita.assistants.myset;

import java.util.ArrayList;

public class IntegerSet {
    ArrayList<Integer> base;

    public IntegerSet() {
        this.base = new ArrayList<>();
    }

//    private int findPlace(Integer i) {
//        int min = 0;
//        int max = base.size() - 1;
//        int mid = max / 2;
//
//        while (min < max) {
//            mid = (min + max) / 2;
//            if (i.intValue() == base.get(mid).intValue()) {
//                return mid;
//            } else if (i < base.get(mid)) {
//                max = mid - 1;
//            } else {
//                min = mid + 1;
//            }
//        }
//
//        return mid;
//    }

    public void insert(Integer i) {
        int len = base.size();
        int j = 0;
        for (; j < len; j++) {
            if (base.get(j) == i) return;
            if (base.get(j) > i) break;
        }

        base.add(j, i);

//        int place = findPlace(i);
//        if (base.size() > place && i == base.get(place))
//            return;
//
//        base.add(place, i);
    }

    public void remove(Integer i) {
        base.remove(i);
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
        IntegerSet res = new IntegerSet();

        int size1 = a.size();
        int size2 = b.size();

        for (int i = 0, j = 0; i < size1 && j < size2; ) {
            Integer aFirst = a.base.get(i);
            Integer bFirst = b.base.get(j);
            if (aFirst == bFirst) {
                res.insert(a.base.get(i));
                i++;
                j++;
            } else if (aFirst < bFirst) {
                i++;
                if (i >= size1) break;
            } else {
                j++;
                if (j >= size2) break;
            }

        }

        return res;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet res = new IntegerSet();

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
