/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortlinkedlist;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
/**
 *
 * @author Matt
 */
public class SortLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<House> houseList = new LinkedList<>();
        houseList.add(new House("extra large", 400));
        houseList.add(new House("medium", 200));
        houseList.add(new House("small", 100));
        houseList.add(new House("large", 300));
        for(House printHouse : houseList){
            System.out.println(printHouse.getType());
        }
        System.out.println("-----Sort Ascending-----");
        houseList = sortHouseListAsc(houseList);
        for(House printHouse : houseList){
            System.out.println(printHouse.getType());
        }
        System.out.println("-----Sort Descending-----");
        houseList = sortHouseListDesc(houseList);
        for(House printHouse : houseList){
            System.out.println(printHouse.getType());
        }
    }
    //Remember to check out / try Collections.sort method & Collections.reverseOrder();
    public static LinkedList<House> sortHouseListAsc(LinkedList<House> list){
        LinkedList<House> sortedList = new LinkedList<>();
        sortedList = list;
        //ListIterator<House> iter = sortedList.listIterator();
        House tempHouse = new House();
        for(int i = 0; i < sortedList.size() - 1; i++){
            for(int j = 1; j < sortedList.size() - i; j++){
                if(sortedList.get(j-1).compareTo(sortedList.get(j)) == 1){
                    tempHouse = sortedList.get(j-1);
                    sortedList.set(j-1, sortedList.get(j));
                    sortedList.set(j, tempHouse);
                }
            }
        }
        return sortedList;
    }
    public static LinkedList<House> sortHouseListDesc(LinkedList<House> list){
        LinkedList<House> sortedList = new LinkedList<>();
        sortedList = list;
        //ListIterator<House> iter = sortedList.listIterator();
        House tempHouse = new House();
        for(int i = 0; i < sortedList.size() - 1; i++){
            for(int j = 1; j < sortedList.size() - i; j++){
                if(sortedList.get(j-1).compareTo(sortedList.get(j)) == -1){
                    tempHouse = sortedList.get(j-1);
                    sortedList.set(j-1, sortedList.get(j));
                    sortedList.set(j, tempHouse);
                }
            }
        }
        return sortedList;
    }
}
