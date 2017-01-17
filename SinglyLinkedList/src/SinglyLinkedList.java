
import java.util.NoSuchElementException;

/**
 * Your implementation of a SinglyLinkedList
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if(data == null){throw new IllegalArgumentException();}
        else if (index == size) addToBack(data);
        else {
            if (index < 0 || index >= size){throw new IndexOutOfBoundsException();}
            LinkedListNode<T> tmp = head;
            for(int i = 0; i < index-1; i++){
                tmp = tmp.getNext();
            }
            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
            newNode.setNext(tmp.getNext());
            tmp.setNext(newNode);
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){throw new IndexOutOfBoundsException();}
        LinkedListNode<T> node = head;
        for(int i = 0; i < index; i++){
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size){throw new IndexOutOfBoundsException();}
        LinkedListNode<T> tmp = head;
        LinkedListNode<T> removing;
        if (index == 0) {
            removing = head;
            head = removing.getNext();
        }
        else {
            for(int i = 0; i < index-1; i++){
                tmp = tmp.getNext();
            }
            removing = tmp.getNext();
            tmp.setNext(removing.getNext());
        }
        size--;
        return removing.getData();
    }

    @Override
    public void addToFront(T data) {
        if(data == null){throw new IllegalArgumentException();}
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        newNode.setNext(head);
        size++;
    }

    @Override
    public void addToBack(T data) {
        if(data == null){throw new IllegalArgumentException();}
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        LinkedListNode<T> tmp = head;

        if (size == 0) head = newNode;
        else {
            for(int i = 0; i < size-1; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
        }
        size++;
    }

    @Override
    public T removeFromFront() {
        LinkedListNode<T> first = head.getNext();
        head.setNext(first.getNext());
        size--;
        return first.getData();
    }

    @Override
    public T removeFromBack() {
        if(isEmpty()){
            return null;
        }else {
            LinkedListNode<T> tmp = head;
            int occur = 0;
            for (int i = 0; i < size - 1; i++) {
                tmp = tmp.getNext();
                occur++;
            }
            LinkedListNode<T> end = tmp.getNext();
            LinkedListNode<T> prev = tmp;
            tmp.setNext(null);
            size--;
            return end.getData();
        }
    }

    @Override
    public int removeFirstOccurrence(T data) {
        if(data == null){throw new IllegalArgumentException();}
        LinkedListNode<T> tmp = head;
        int i = 0;
        while (i < size){
            if(tmp.getData().equals(tmp.getNext().getData())){
                tmp.setNext(tmp.getNext().getNext());
                size--;
                throw new NoSuchElementException();
            }else{
                tmp = tmp.getNext();
                i++;
            }
        }
        return i;
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

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}
