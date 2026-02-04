package fr.epita.assistants.linkedlist;

public class LinkedList<T extends Comparable<T>> {

    private static class Node<T extends Comparable<T>> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            next = null;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    Node<T> HEAD;
    int size;

    /**
     * Initializes the list.
     **/
    public LinkedList() {
        HEAD = null;
        size = 0;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        size++;

        if (HEAD == null) {
            HEAD = new Node<>(e);
            return;
        }

        if (HEAD.element.compareTo(e) > 0) {
            HEAD = new Node<>(e, HEAD);
            return;
        }

        Node<T> tmp = HEAD;
        while (tmp.next != null) {
            if (tmp.next.element.compareTo(e) > 0)
                break;
            tmp = tmp.next;
        }

        tmp.next = new Node<>(e, tmp.next);
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if the given index is invalid.
     **/
    public T get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> tmp = HEAD;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }

        return tmp.element;
    }

    /**
     * Removes the first occurrence of the specified element in the list if
     * it exists.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (HEAD == null || e == null) {
            return null;
        }

        if (HEAD.element.equals(e)) {
            T ret = HEAD.element;
            HEAD = HEAD.next;

            size--;
            return ret;
        }

        Node<T> tmp = HEAD;
        while (tmp.next != null && !tmp.next.element.equals(e)) {
            tmp = tmp.next;
        }

        if (tmp.next == null) {
            return null;
        }

        T ret = tmp.next.element;
        tmp.next = tmp.next.next;

        size--;
        return ret;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        HEAD = null;
        size = 0;
    }
}
