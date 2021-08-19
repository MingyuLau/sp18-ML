public class LinkedListDeque<T>{

    public class TNode{
        public TNode prev;
        public T value;
        public TNode next;

        public TNode(TNode p, T x, TNode n){
            prev = p;
            value = x;
            next = n;
        }
    }

    private int size = 0;
    private TNode last;
    private TNode sentinel;

    public LinkedListDeque(){
        sentinel = new TNode(null,null,null);
        last = sentinel;
        sentinel.prev = last;
        sentinel.next = sentinel;
    }
    public void addFirst(T item){
        sentinel.next = new TNode(sentinel, item, sentinel);
        last = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        last.next = new TNode(last, item, sentinel);
        last = last.next;
        size += 1;
    }

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }else{
            return false;
        }
    }

    public int size(){return size;}

    public void printDeque(){
        TNode pointer = sentinel;
        int cnt;
        for(cnt = 0; cnt < size; cnt++){
            pointer = pointer.next;
            System.out.print(pointer.value + " ");

        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }else{
            sentinel.next = sentinel.next.next;
            sentinel = sentinel.next.prev;
            size -= 1;
            return sentinel.next.value;
        }
    }

}
