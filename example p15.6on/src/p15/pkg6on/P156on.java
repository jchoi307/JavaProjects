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
public class P156on {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        menu();
    }
    public static void menu(){
        
        ToDoList list = new ToDoList();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your basic To Do List! Please follow the commands listed below to begin.");
        System.out.println("Please start off by naming your To Do List: ");
        list.setTitle(in.nextLine());
        String menuTop = "Type 'add' if you'd like to add a new item to your To Do List.\n"
                + "Type 'next' if you'd like to view the next item in your To Do List.\n"
                + "Type 'viewall' if you'd like to view all items currently in your To Do List.\n"
                + "Type 'exit' if you'd like to exit the program.\n";
        System.out.println(menuTop);
        String input = in.next();
        loop: do{
            switch(input){
                case "add" : {
                    System.out.print("Please select a priority number (1 - 9) for this item: ");
                    int p = in.nextInt();
                    while(p < 1 || p > 9){
                        System.out.print("Please select a valid priority number (1 - 9) for this item: ");
                        p = in.nextInt();
                    }
                    in.nextLine();
                    System.out.println("Please describe your task: ");
                    String d = in.nextLine();
                    list.addToList(new Task(p, d));
                    break;
                }
                case "next" : {
                    System.out.println(list.nextInList() + "\n");
                    break;
                }
                case "viewall" : {
                    list.viewAll();
                    break;
                }
                case "exit" : {
                    break loop;
                }
                default : {
                    break;
                }
            }
            System.out.println(menuTop);
            input = in.next();
        }while(!"exit".equals(input));
        System.out.println("Thank you!");
    }
    
}
