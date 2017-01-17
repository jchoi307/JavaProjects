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
/**
   This is a simplified implementation of an array list.
*/
public class My_ArrayList
{
   private Object[] buffer;
   private int currentSize;

   /**
      Constructs an empty array list.
   */
   public My_ArrayList() 
   {
      final int INITIAL_SIZE = 10;
      buffer = new Object[INITIAL_SIZE];
      currentSize = 0;
   }

   /**
      Gets the size of this array list.
      @return the size
   */
   public int size() { return currentSize; }

   /**
      Throws an IndexOutOfBoundsException if the checked index is out of bounds
      @param n the index to check
   */
   private void checkBounds(int n)
   {
      if (n < 0 || n >= currentSize) 
      {
         throw new IndexOutOfBoundsException();
      }
   }
      /**
      Gets the element at a given position.
      @param pos the position
      @return the element at pos
   */
   public Object get(int pos)
   {
      checkBounds(pos);
      return buffer[pos];
   }

   /**
      Sets the element at a given position.
      @param pos the position
      @param element the new value
   */
   public void set(int pos, Object element)
   {
      checkBounds(pos);
      buffer[pos] = element;
   }

   /**
      Removes the element at a given position.
      @param pos the position
      @return the removed element
   */
   public Object remove(int pos)
   {      
      checkBounds(pos);

      Object removed = buffer[pos];

      for (int i = pos + 1; i < currentSize; i++)
      {
         buffer[i - 1] = buffer[i];
      }

      currentSize--; 

      return removed;
   }

   /**
      Adds an element after a given position.
      @param pos the position
      @param newElement the element to add
   */
   public boolean add(int pos, Object newElement)
   {
      growBufferIfNecessary();
      currentSize++;

      checkBounds(pos);

      for (int i = currentSize - 1; i > pos; i--)
      {
         buffer[i] = buffer[i - 1];
      }

      buffer[pos] = newElement;
      return true;
   }

   /**
      Adds an element after the end of the array list
      @param newElement the element to add
   */
   public boolean addLast(Object newElement)
   {
      growBufferIfNecessary();
      currentSize++;
      
      buffer[currentSize - 1] = newElement;
      return true;
   }

   /**
      Grows the buffer if the current size equals the buffer's capacity.
   */
   private void growBufferIfNecessary()
   {
      if (currentSize == buffer.length)
      {
         Object[] newBuffer = new Object[2 * buffer.length];
         for (int i = 0; i < buffer.length; i++) 
         { 
            newBuffer[i] = buffer[i]; 
         }      
         buffer = newBuffer;
      }
   }
   @Override
   public String toString(){
       String arrayTotal = "[";
       
       for(int i = 0; i < currentSize - 1; i++){
           arrayTotal += buffer[i] + " - ";
       }
       arrayTotal += buffer[currentSize-1] + "]";
       return arrayTotal;
       
   }
}
