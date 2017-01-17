package vending;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joon
 */
import java.util.Scanner;
public class Machine {
    
    private int soda, water, juice;
    private double sodaPrice, waterPrice, juicePrice;
    Scanner input = new Scanner(System.in);
    
    public Machine(){
        
    }
    /**
     * 
     * @param deposit 
     */
    public Machine(int[] deposit){
        this.soda = deposit[0];
        this.water = deposit[1];
        this.juice = deposit[2];
    }
    /**
     * 
     * @param total 
     */
    public void setSoda(double total){
        if(this.soda >= 1){
            if(total >= this.sodaPrice){
                this.soda -= 1;
                System.out.println("You have purchased a soda!");
            }
            else{
                System.out.println("You have not entered enough money, try again.");
            }
        }
        else{
            System.out.println("The vending machine is out of soda.");
        }
    }
    /**
     * 
     * @param total 
     */
    public void setWater(double total){
        if(this.water >= 1){
            if(total >= this.waterPrice){
                this.water -= 1;
                System.out.println("You have purchased a water!");
            }
            else{
                System.out.println("You have not entered enough money, try again.");
            }
        }
        else{
            System.out.println("The vending machine is out of water.");
        }
    }
    /**
     * 
     * @param total 
     */
    public void setJuice(double total){
        if(this.juice >= 1){
            if(total >= this.juicePrice){
                this.juice -= 1;
                System.out.println("You have purchased a juice!");
            }
            else{
                System.out.println("You have not entered enough money, try again.");
            }
        }
        else{
            System.out.println("The vending machine is out of juice.");
        }
    }
    public void getStock(){
        System.out.println("Current vending machine stock:");
        System.out.println("Soda: " + this.soda);
        System.out.println("Water: " + this.water);
        System.out.println("Juice: " + this.juice);
    }
    public void getPrice(){
        System.out.println("Current vending machine prices:");
        System.out.println("Soda: $" + this.sodaPrice);
        System.out.println("Water: $" + this.waterPrice);
        System.out.println("Juice: $" + this.juicePrice);
    }
    public void setPrice(){
        System.out.println("Please set the prices for each drink in your vending machine -");
        System.out.print("How much are you charging for soda? $");
        do{
            while(!input.hasNextDouble()){
                System.out.print("\nPlease enter a valid price: $");
                input.next();
            }
            this.sodaPrice = input.nextDouble();
        } while(this.sodaPrice <= 0);
        System.out.print("\nHow much are you charging for water? $");
        do{
            while(!input.hasNextDouble()){
                System.out.print("\nPlease enter a valid price: $");
                input.next();
            }
            this.waterPrice = input.nextDouble();
        } while(this.waterPrice <= 0);
        System.out.print("\nHow much are you charging for juice? $");
        do{
            while(!input.hasNextDouble()){
                System.out.print("\nPlease enter a valid price: $");
                input.next();
            }
            this.juicePrice = input.nextDouble();
        } while(this.juicePrice <= 0);
    }
}
