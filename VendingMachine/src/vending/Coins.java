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
public class Coins {
    
    private int nickel, dime, quarter, bill;
    private int[] change;
    Scanner input = new Scanner(System.in);
    
    public Coins(){
        
    }
    /**
     * 
     * @param wallet 
     */
    public Coins(int[] wallet){
        this.nickel = wallet[0];
        this.dime = wallet[1];
        this.quarter = wallet[2];
        this.bill = wallet[3];
        change = new int[]{0,0,0,0};
    }
    public void insertNickel(){
        if(this.nickel > 0){
            this.nickel -= 1;
            change[0] += 1;
        }
        else{
            System.out.println("You do not have any nickels in your wallet!");
        }
    }
    public void insertDime(){
        if(this.dime > 0){
            this.dime -= 1;
            change[1] += 1;
        }
        else{
            System.out.println("You do not have any dimes in your wallet!");
        }
    } 
    public void insertQuarter(){
        if(this.quarter > 0){
            this.quarter -= 1;
            change[2] += 1;
        }
        else{
            System.out.println("You do not have any quarters in your wallet!");
        }
    }
    public void insertBill(){
        if(this.bill > 0){
            this.bill -= 1;
            change[3] += 1;
        }
        else{
            System.out.println("You do not have any bills in your wallet!");
        }
    }
    public void returnCoins(){
        double sum = getTotalInMachine();
        this.nickel += change[0];
        this.dime += change[1];
        this.quarter += change[2];
        this.bill += change[3];
        clearChange();
        System.out.println("You have ejected $" + sum + " from the machine back into your wallet.");
    }
    /**
     * 
     * @return 
     */
    public double getTotalInMachine(){
        double total = change[0]*(.05) + change[1]*(.10) + change[2]*(.25) + change[3];
        return total;
    }
    /**
     * 
     * @return 
     */
    public double getTotalInWallet(){
        double total = this.nickel*(.05) + this.dime*(.10) + this.quarter*(.25) + this.bill;
        
        return total;
    }
    public void clearChange(){
        this.change = new int[]{0,0,0,0};
    }
}
