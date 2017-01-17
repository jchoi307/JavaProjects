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
public class My_Stack {
    
    private Object[] buffer;
    private int currentSize;
    
    public My_Stack(){
        
        final int INITIAL_CAP = 10;
        this.buffer = new Object[INITIAL_CAP];
        this.currentSize = 0;
        
    }
    public void push(Object val){
        
        growBuffer();
        buffer[currentSize] = val;
        currentSize++;
        
    }
    public Object pop(){
        
        Object popped = buffer[currentSize];
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            currentSize--;
            return buffer[currentSize];
        }
        
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    private void growBuffer(){
        if(currentSize == buffer.length){
            Object newBuffer[] = new Object[buffer.length * 2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
        }
    }
    public Object peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return buffer[currentSize-1];
        }
    }
    
}
