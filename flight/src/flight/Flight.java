/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight;

/**
 *
 * @author Joon
 */
import java.util.*;

public class Flight{
   public static void main(String[] args){
   
      PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
      String[] list = new String[1000];
      Scanner in = new Scanner(System.in);
      System.out.println("Type 'takeOff flightsymbol' to add a plane to the Queue. \n"
                        + "Type 'land flightsymbol' to add a plane to the Queue. \n"
                        + "Type 'next' to finishes the current takeoff or landing and enables the next one \n"
                        + "Type 'exit' to exit the program");
      String input = "";
      int i = 0;
      
      while(!"exit".equals(input)){
         System.out.println("Enter your command: ");
         i++;
         input = in.nextLine();
           
            if(input.contains("takeOff")){
               int queuenum = i+100;
               pQueue.add(queuenum);
               String temp = input.substring(8,input.length());
               list[queuenum] = temp;
               
            }else if(input.contains("land")){
               int queuenum = i;
               pQueue.add(queuenum);
               String temp = input.substring(5,input.length());
               list[queuenum] = temp;
               
            }else if(input.contains("next")){
               if(pQueue.peek() != null){
                  if(pQueue.peek() < 100){
                  System.out.println(list[pQueue.remove()] + " has landed.");
                  } else {
                  System.out.println(list[pQueue.remove()] + " has taken off.");
                  }
                  
               } else {
                    System.out.println("There are no planes to land or take off.");
               }
               
            } else if(input.contains("exit")) {
                break;
                
            }else{
                System.out.println("Error");
            }
        }
    }   
}
