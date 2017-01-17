/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortlinkedlist;

/**
 *
 * @author Matt
 */
public class House implements Comparable<House> {
    String type;
    int size;
    public House(String t, int s){
        type = t;
        size = s;
    }
    public House(){
        type = null;
        size = 0;
    }
    public String getType(){
        return this.type;
    }
    @Override
    public int compareTo(House n){
        if(this.size > n.size){
            return 1;
        }
        else if(this.size < n.size){
            return -1;
        }
        else{
            return 0;
        }
    }
}
