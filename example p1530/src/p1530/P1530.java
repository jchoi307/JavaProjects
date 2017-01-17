/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1530;
/**
*
* @author Matt
*/
import java.util.*;
public class P1530 {
/**
* @param args the command line arguments
*/
    public static void main(String[] args) {
        // TODO code application logic here
        FrameBuild prob1530 = new FrameBuild();
        prob1530.setTitle("Airport Traffic Control");
        prob1530.setVisible(true);
    }
    /*
    public static void menu(Queue<String> flyOut, Queue<String> flyIn){
        Scanner in = new Scanner(System.in);
        Queue<String> takeOff = flyOut;
        Queue<String> land = flyIn;
        String menuTxt = "Type 'takeOff x' to add a plane to the Take Off Queue. \n"
            + "Type 'land x' to add a plane to the Landing Queue. \n"
            + "Type 'next' to allow a plane to either land or fly \n"
            + "Type 'exit' to exit the program";
        System.out.println(menuTxt);
        String input = "";
        while(!"exit".equals(input)){
            System.out.println("Enter your command: ");
            input = in.nextLine();
            if(input.contains("takeOff")){
                String temp = input.substring(8);
                takeOff.add(temp);
                System.out.println(temp + " has been added to the Take Off Queue");
            }
            else if(input.contains("land")){
                String temp = input.substring(5);
                land.add(temp);
                System.out.println(temp + " has been aded to the Landing Queue");
            }
            else if(input.contains("next")){
                if(land.peek() != null){
                    System.out.println(land.remove() + " has successfully landed at the airport.");
                }
                else if (takeOff.peek() != null){
                    System.out.println(takeOff.remove() + " has successfully taken off from the airport.");
                }
                else{
                    System.out.println("There are no planes in queue to land or take off!");
                }
            }
            else if(input.contains("exit")){
                break;
            }
            else{
                System.out.println("Enter a valid command");
            }
        }
    }
    */
}