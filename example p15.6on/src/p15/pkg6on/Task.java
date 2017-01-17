/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p15.pkg6on;

/**
 *
 * @author Matt
 */
public class Task {
    
    public int priority;
    public String description;
    
    public Task(int p, String d){
        this.priority = p;
        this.description = d;
    }
    public int getPriority(){
        return this.priority;
    }
    public String getDescription(){
        return this.description;
    }
    @Override
    public String toString(){
        String str = "[" + this.priority + "] " + this.description + ".";
        return str;
    }
}
