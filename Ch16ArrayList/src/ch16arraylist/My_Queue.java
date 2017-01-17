/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16arraylist;
import java.util.*;
/**
 *
 * @author Matt
 */
public class My_Queue {
    
    private Object[] buffer;
    private int front, back, currentSize;
    
    public My_Queue(){
        
        final int INITIAL_CAP = 10;
        this.buffer = new Object[INITIAL_CAP];
        this.front = 0;
        this.back = 0;
        this.currentSize = 0;
        
    }
    public void add(Object val){
        
        growBuffer();
        currentSize++;
        buffer[back] = val;
        back = (back+1)%buffer.length;
        
    }
    public Object remove(){
        
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        Object removed = buffer[front];
        front = (front+1)%buffer.length;
        currentSize--;
        return removed;
        
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    private void growBuffer(){
        if(currentSize == buffer.length){
            Object newBuffer[] = new Object[buffer.length * 2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[(front+1)%buffer.length];
            }
            buffer = newBuffer;
        }
    }
}
