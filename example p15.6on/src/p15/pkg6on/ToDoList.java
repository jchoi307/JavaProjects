/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p15.pkg6on;
import java.util.*;
/**
 *
 * @author Matt
 */
public class ToDoList {
    
    public PriorityQueue<Task> baseList;
    public Comparator<Task> pCompare;
    public String listTitle;
    
    public ToDoList(){
        pCompare = new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                return (int)(t1.getPriority() - t2.getPriority());
            }
        };
        baseList = new PriorityQueue<Task>(11, pCompare);
    }
    public void addToList(Task t){
        baseList.add(t);
    }
    public Task nextInList(){
        if(this.baseList.peek() != null){
            return this.baseList.poll();
        }
        else{
            return new Task(0, "There are no more tasks");
        }
    }
    public void setTitle(String title){
        this.listTitle = title;
    }
    public String getTitle(){
        return this.listTitle;
    }
    public void viewAll(){
        for(Task t : this.baseList){
            System.out.println(t.toString());
        }
    }
}
