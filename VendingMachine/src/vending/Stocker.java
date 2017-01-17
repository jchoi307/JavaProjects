package vending;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
public class Stocker {
    
    Scanner input = new Scanner(System.in);
    public Stocker(){
        
    }
    /**
     * 
     * @return 
     */
    public int[] stockWallet(){
        int[] stock = new int[4];
        System.out.println("Fill your wallet with how much money you have -");
        System.out.print("Enter the number of nickels you have: ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[0] = input.nextInt();
        } while(stock[0] < 0);
        System.out.print("\nEnter the number of dimes you have: ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[1] = input.nextInt();
        } while(stock[1] < 0);
        System.out.print("\nEnter the number of quarters you have: ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[2] = input.nextInt();
        } while(stock[2] < 0);
        System.out.print("\nFinally, enter the number of $1 bills you have: ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[3] = input.nextInt();
        } while(stock[3] < 0);
        return stock;
    }
    /**
     * 
     * @return 
     */
    public int[] stockMachine(){
        int[] stock = new int[3];
        boolean verify = false;
        System.out.println("Please stock your vending machine -");
        System.out.print("How many bottles of soda are you depositing? ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[0] = input.nextInt();
        } while(stock[0] < 0);
        System.out.print("\nHow many bottles of water are you depositing? ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[1] = input.nextInt();
        } while(stock[2] < 0);
        System.out.print("\nFinally, how many bottles of juice are you depositing? ");
        do{
            while(!input.hasNextInt()){
                System.out.print("\nPlease enter a valid, positive number: ");
                input.next();
            }
            stock[2] = input.nextInt();
        } while(stock[2] < 0);
        return stock;
    }
    
}
