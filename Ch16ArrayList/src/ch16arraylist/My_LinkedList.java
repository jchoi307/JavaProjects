/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16arraylist;

/**
 *
 * @author Matt
 */
public class My_LinkedList {
    
    private My_Node first;
    private int currentSize;
    
    private class My_Node {
        
        public Object data;
        public My_Node next;
        
    }
    
    public My_LinkedList(){
        first = null;
        currentSize = 0;
    }
    public Object getFirst(){
        if(first == null){ throw new java.util.NoSuchElementException(); }
        return first.data;
    }
    public Object removeFirst(){
        if(first == null){ throw new java.util.NoSuchElementException(); }
        Object element = first.data;
        first = first.next;
        currentSize--;
        return element;
    }
    public void addFirst(Object element){
        My_Node newNode = new My_Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
        currentSize++;
    }
    public int size(){
        My_Node temp = first;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int recCount(){
        return recCount(first);
    }
    public int recCount(My_Node n){
        int count = 0;
        if(n == null){
            return count;
        }
        count = recCount(n.next);
        count++;
        return count;
    }
    public int sizeRec(My_Node n){
        int count = 0;
        if(n == null){ return count; }
        count++;
        return count += sizeRec(n.next);
    }
    public int sizeRec(){
        return sizeRec(first);
    }
    public void addLast(Object element){
        My_Node temp = first;
        My_Node p = new My_Node();
        while(temp != null){
            p = temp;
            temp = temp.next;
        }
        My_Node newNode = new My_Node();
        newNode.data = element;
        p.next = newNode;
        currentSize++;
    }
    public Object getLast(){
        My_Node temp = first;
        My_Node p = new My_Node();
        while(temp != null){
            p = temp;
            temp = temp.next;
        }
        return p.data;
    }
    public void add(int index, Object element){
        My_Node temp = first, p = new My_Node(), prev = new My_Node();
        p.data = element;
        if(index == 0){
            p.next = first;
            first = p;
        }
        else{
            if(index > this.size()-1){
                throw new java.lang.IndexOutOfBoundsException();
            }
            for(int i = 0; i < index; i++){
                prev = temp;
                temp = temp.next;
            }
            p.next = temp;
            prev.next = p;
        }
        currentSize++;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void printListReverse(){
        printListReverse(first);
    }
    public void revPrint(){
        revPrint(first);
    }
    public void revPrint(My_Node n){
        if(n == null){
            return;
        }
        else{
            revPrint(n.next);
            System.out.println(n.data);
        }
    }
    public void printListReverse(My_Node n){
        if(n.next == null){ System.out.println(n.data); }
        else{
            My_Node item = n.next;
            printListReverse(item);
            System.out.println(n.data);
        }
    }
    public My_Node reverse(){
        first = reverse(first);
        return first;
    }
    public My_Node reverse(My_Node n){
        if(n == null){ return null; }
        if(n.next == null) { return n; }
        My_Node temp = n.next;
        n.next = null;
        My_Node list = reverse(temp);
        temp.next = n;
        return list;
    }
    public My_ListIterator listIterator(){
        return new LinkedListIterator();
    }
    class LinkedListIterator implements My_ListIterator{
        private My_Node position;
        private My_Node previous;
        private boolean isAfterNext;

        /**
             Constructs an iterator that points to the front
             of the linked list.
        */
        public LinkedListIterator()
        {  
            position = null;
            previous = null;
            isAfterNext = false;
        }
      
        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        @Override
        public Object next()
        {  
            if (!hasNext()) { throw new java.util.NoSuchElementException(); }
            previous = position; // Remember for remove
            isAfterNext = true;

            if (position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }

            return position.data;
        }
      
        /**
             Tests if there is an element after the iterator position.
             @return true if there is an element after the iterator position
        */
        @Override
        public boolean hasNext()
        {  
            if (position == null)
            {
                return first != null;
            }
            else
            {
                return position.next != null;
            }
        }
      
        /**
            Adds an element before the iterator position
            and
            * moves the iterator past the inserted element.
            @param element the element to add
        */
        @Override
        public void add(Object element)
        {  
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {  
                My_Node newNode = new My_Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;
        }
      
        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        @Override
        public void remove()
        {  
            if (!isAfterNext) { throw new IllegalStateException(); }

            if (position == first)
            {
                removeFirst();
            }
            else 
            {  
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        }

        /**
            Sets the last traversed element to a different value. 
            @param element the element to set
        */
        @Override
        public void set(Object element)
        {
            if (!isAfterNext) { throw new IllegalStateException(); }
            position.data = element;
        }
    }
}

