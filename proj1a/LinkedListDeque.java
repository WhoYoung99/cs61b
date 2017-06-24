/**
 * Created by WhoYoung99 on 6/24/17.
 * Implement double linked list, with constant time add & remove methods
 */
public class LinkedListDeque<Object> {

    /**
     * Component of LinkedList, will support generic type
     * take three input: (node's content, previous node, next node)
     */
    public class IntNode {
        private Object item;
        private IntNode prev;
        private IntNode next;

        private IntNode(Object i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public int size;
    public IntNode sentinel;
    public IntNode node;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next= sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(Object i) {
        sentinel = new IntNode(null, null, null);
        node = new IntNode(i, sentinel, sentinel);
        sentinel.prev = node;
        sentinel.next = node;
        size = 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Adds an item to the front of the Deque.
     */
    public void addFirst(Object i) {
        node = new IntNode(i, sentinel, sentinel.next);
        sentinel.next = node;
        node.next.prev = node;
        size += 1;
    }

    /**
     * Adds an item to the back of the Deque.
     */
    public void addLast(Object i) {
        node = new IntNode(i , sentinel.prev, sentinel);
        sentinel.prev = node;
        node.prev.next = node;
        size += 1;
    }

    /**
     * Removes and returns the item at the front of the Deque.
     * If no such item exists, returns null.
     */
    public Object removeFirst() {
        node = sentinel.next;
        sentinel.next = node.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return node.item;
    }

    /**
     * Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null.
     */
    public Object removeLast() {
        node = sentinel.prev;
        sentinel.prev = node.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return node.item;
    }

    /**
     * Returns the number of items in the Deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the Deque from first to last, separated by a space.
     */
    public void printDeque() {
        node = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public Object get(int index) {
        int i = 0;
        node = sentinel.next;
        while (i != index) {
            node = node.next;
            i += 1;
        }
        return node.item;
    }
}
