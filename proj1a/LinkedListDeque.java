/**
 * Deque(usually pronounced like "deck") is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<T> {
    private class TNode {
        private TNode prev;
        private T value;
        private TNode next;

        public TNode(TNode p, T x, TNode n) {
            prev = p;
            value = x;
            next = n;
        }
    }

    private int size;
    private TNode last;
    private TNode sentinel;

    public LinkedListDeque() {
        sentinel = new TNode(null, (T) new Object(), null);
        last = sentinel;
        sentinel.prev = last;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        TNode newNode = new TNode(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        last.next = new TNode(last, item, sentinel);
        last = last.next;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {return size;}

    public void printDeque() {
        TNode pointer = sentinel;
        int cnt;
        for(cnt = 0; cnt < size; cnt++) {
            pointer = pointer.next;
            System.out.print(pointer.value + " ");
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        } else {
            sentinel.next = sentinel.next.next;
            sentinel = sentinel.next.prev;
            size -= 1;
            return sentinel.next.value;
        }
    }

}
