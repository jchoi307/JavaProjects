import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularDoublyLinkedList
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class CircularDoublyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    /**
     * Creates an empty circular doubly-linked list.
     */
    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Creates a circular doubly-linked list with
     * {@code data} added to the list in order.
     * @param data The data to be added to the LinkedList.
     * @throws java.lang.IllegalArgumentException if {@code data} is null or any
     * item in {@code data} is null.
     */
    public CircularDoublyLinkedList(T[] data) {
        LinkedListNode<T[]> newNode = new LinkedListNode<T[]>(data);
        newNode.setNext(null);
    }

    @Override
    public void addAtIndex(int index, T data) {
        if(index < 0 || index < size) {throw new IndexOutOfBoundsException();}
        if(data == null) {throw new IllegalArgumentException();}
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        LinkedListNode<T> tmp = head;
        if(isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            head = newNode;
        } else {
            for (int i = 1; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
            newNode.setPrevious(tmp);
            newNode.setNext(tmp.getNext());
            tmp.getNext().setPrevious(newNode);
            size++;
        }
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        LinkedListNode<T> tmp = head;
        for(int i = 1; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        if(index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        LinkedListNode<T> tmp = head;
        LinkedListNode<T> removing;
        if(index == 0) {
            removing = head;
            head = removing.getNext();
        } else {
            for(int i = 1; i < index; i++){
                tmp = tmp.getNext();
            }
            removing = tmp.getNext();
            tmp.setNext(removing.getNext());
            removing.getNext().setPrevious(tmp);
        }
        size--;
        return removing.getData();
    }

    @Override
    public void addToFront(T data) {
        if(data == null) {throw new IllegalArgumentException();}
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if(isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            head = newNode;
        } else {
            head.setNext(newNode);
            newNode.setPrevious(head);
            newNode.setNext(head.getNext());
            head.getNext().setPrevious(newNode);
        }
        size++;
    }

    @Override
    public void addToBack(T data) {
        if(data == null) {throw new IllegalArgumentException();}
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        LinkedListNode<T> tmp = head;
        if(isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            head = newNode;
        } else {
            for(int i = 1; i < size; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
            newNode.setPrevious(tmp);
        }
        size++;
    }

    @Override
    public T removeFromFront() {
        if(isEmpty()) {return null;}
        LinkedListNode<T> first = head.getNext();
        head.setNext(first.getNext());
        size--;
        return first.getData();
    }

    @Override
    public T removeFromBack() {
        if(isEmpty()) {
            return null;
        } else {
            LinkedListNode<T> tmp = head;
            for (int i = 1; i < size; i++) {
                tmp = tmp.getNext();
            }
            LinkedListNode<T> end = tmp.getNext();
            tmp.setNext(null);
            size--;
            return end.getData();
        }
    }

    @Override
    public int removeFirstOccurrence(T data) {
        if(data == null) {throw new IllegalArgumentException();}
        if(isEmpty()) {throw new NoSuchElementException();}
        LinkedListNode<T> tmp = head;
        int i = 1;
        while (i < size){
            if(tmp.getData().equals(tmp.getNext().getData())){
                tmp.setNext(tmp.getNext().getNext());
                size--;
            }else{
                tmp = tmp.getNext();
                i++;
            }
        }
        return i;
    }

    @Override
    public boolean removeAllOccurrences(T data) {

    }

    @Override
    public Object[] toArray() {
        LinkedListNode<T> tmp = head;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++){
            array[i] = tmp.getData();
            tmp = tmp.getNext();
        }
        return array;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            removeFromFront();
        }
    }

    /* DO NOT MODIFY THIS METHOD */
    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }
}
