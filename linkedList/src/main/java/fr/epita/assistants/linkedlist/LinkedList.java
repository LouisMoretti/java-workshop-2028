package fr.epita.assistants.linkedlist;

public class LinkedList<T extends Comparable<T>> {
    T element;
    LinkedList<T> next;

    /**
     * Initializes the list.
     **/
    public LinkedList() {
        element = null;
        next = null;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        if (element == null) {
            element = e;
        } else {
            if (next == null)
                next = new LinkedList<>();
            next.insert(e);
        }
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if the given index is invalid.
     **/
    public T get(int i) {
        if (i == 0) {
            if (element == null)
                throw new IndexOutOfBoundsException();
            return element;
        } else if (next == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return next.get(i - 1);
        }
    }

    /**
     * Removes the first occurrence of the specified element in the list if
     * it exists.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (element == null)
            return null;

        if (element == e) {
            element = next == null ? null : next.element;
            next = next == null ? null : next.next;
            return e;
        }

        if (next == null)
            return null;

        return next.remove(e);
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        if (element == null) {
            return 0;
        } else if (next == null) {
            return 1;
        } else {
            return 1 + next.size();
        }
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        if (next != null)
            next.clear();
        element = null;
        next = null;
    }
}
