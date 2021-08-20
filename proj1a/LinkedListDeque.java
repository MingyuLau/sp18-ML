/**
 * Deque(usually pronounced like "deck") is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T value;
        private Node next;

        public Node(LinkedListDeque<T>.Node prev, T value, LinkedListDeque<T>.Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node sentinel;

    /** This is a constructor. */
    public LinkedListDeque() {
        sentinel = new Node(null, (T) new Object(), null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the Deque. */
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /** Adds an item of type T to the back of the Deque. */
    public void addLast(T item) {
        Node newNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from the first to last,separated by a space. */
    public void printDeque() {
        for (Node i = sentinel.next; i != sentinel; i = i.next) {
            if (i.next == sentinel) {
                System.out.println(i.value);
                break;
            }
            System.out.println(i.value + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return sentinel.next.value;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (size < index) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.value;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (size < index) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(LinkedListDeque<T>.Node node, int i) {
        if (i == 0) {
            return node.value;
        }
        return getRecursive(node.next, i - 1);
    }

}