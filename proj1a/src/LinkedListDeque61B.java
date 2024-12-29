import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private class StuffNode{
        StuffNode prev;
        T item;
        StuffNode next;
        public StuffNode(StuffNode p, T i, StuffNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
    private StuffNode sentinel;
    private int size;
    /**
     *     public LinkedListDeque61B(T x){
     *         StuffNode sentinel = new StuffNode(null, null, null);
     *         StuffNode first = new StuffNode(sentinel, x, sentinel);
     *         sentinel.next = first;
     *         sentinel.prev = first.next;
     *     }
     */

    public LinkedListDeque61B(){
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        StuffNode first = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        StuffNode last = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        StuffNode p = sentinel.next;
        for (int i = 0; i < size; i++){
            returnList.add(p.item);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        StuffNode temp = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return temp.item;
    }

    @Override
    public T removeLast() {
        StuffNode temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return temp.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size-1){
            return null;
        }
        else {
            StuffNode temp = sentinel.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.item;
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index > size-1){
            return null;
        }
        else {
            StuffNode p = sentinel.next;
            return getRecursive(p, index);
        }
    }

    private T getRecursive(StuffNode p, int index){
        if (index == 0){
            return p.item;
        }
        else return getRecursive(p.next, index-1);
    }
}
