package vending;

import java.util.Scanner;
public class VendingMachine {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        Stocker stock = new Stocker();
        System.out.println("Welcome to the vending machine!");
        
        Coins wallet = new Coins(stock.stockWallet());
        Machine vendor = new Machine(stock.stockMachine());
        vendor.setPrice();
        menu(wallet, vendor);
        
    }
    /**
     * 
     * @param wallet
     * @param vendor 
     */
    public static void menu(Coins wallet, Machine vendor){
        Scanner input = new Scanner(System.in);
        boolean doneOuter = false, doneInner = false;
        int insert = 0, select = 0;
        String ls = System.getProperty("line.separator");
        String menuOuter = "Choose an operation by entering the correct number:" + ls + "1. Deposit a nickel into the machine"
                + ls + "2. Deposit a dime into the machine" + ls + "3. Deposit a quarter into the machine" + ls 
                + "4. Deposit a $1 bill into the machine" + ls + "5. Return all money inserted" + ls + "6. How much money do I have in my wallet?"
                + ls + "7. How much money is currently in the machine?" + ls + "8. Show me the prices of each selection"
                + ls + "9. Show me how many of each selection are left in the machine" + ls + "10. Select your product(s) from the vending machine"
                + ls + "11. Walk away (end program)";
        System.out.println(menuOuter);
        while(doneOuter == false){
            do{
                System.out.print("\nPlease enter a valid selection: ");
                while(!input.hasNextInt()){
                    System.out.print("\nPlease enter a valid selection: ");
                    input.next();
                }
                insert = input.nextInt();
            } while(insert < 1 || insert > 11);
            
            switch(insert){
                case 1: {
                    wallet.insertNickel();
                    break;
                }
                case 2: {
                    wallet.insertDime();
                    break;
                }
                case 3: {
                    wallet.insertQuarter();
                    break;
                }
                case 4: {
                    wallet.insertBill();
                    break;
                }
                case 5: {
                    wallet.returnCoins();
                    break;
                }
                case 6: {
                    System.out.println("$" + wallet.getTotalInWallet());
                    break;
                }
                case 7: {
                    System.out.println("$" + wallet.getTotalInMachine());
                    break;
                }
                case 8: {
                    vendor.getPrice();
                    break;
                }
                case 9: {
                    vendor.getStock();
                    break;
                }
                case 10: {
                    System.out.println("Please select your product(s) from this list by entering the correct number.");
                    System.out.println("1. Purchase a soda");
                    System.out.println("2. Purchase a water");
                    System.out.println("3. Purchase a juice");
                    System.out.println("4. Show me the prices of each selection");
                    System.out.println("5. Show me how many of each selection are left in the machine");
                    System.out.println("6. Return to the previous menu");
                    while(doneInner == false){
                        do{
                            System.out.print("\nPlease enter a valid selection: ");
                            while(!input.hasNextInt()){
                                System.out.print("\nPlease enter a valid selection: ");
                                input.next();
                            }
                            select = input.nextInt();
                        } while(select < 1 || select > 6);
                        
                        switch(select){
                            case 1: {
                                vendor.setSoda(wallet.getTotalInMachine());
                                wallet.clearChange();
                                break;
                            }
                            case 2: {
                                vendor.setWater(wallet.getTotalInMachine());
                                wallet.clearChange();
                                break;
                            }        
                            case 3: {
                                vendor.setJuice(wallet.getTotalInMachine());
                                wallet.clearChange();
                                break;
                            }
                            case 4: {
                                vendor.getPrice();
                                break;
                            }
                            case 5: {
                                vendor.getStock();
                                break;
                            }
                            case 6: {
                                doneInner = true;
                                wallet.clearChange();
                                System.out.println(menuOuter);
                                break;
                            }
                            default: break;
                        }
                        
                    }
                    doneInner = false;
                    break;
                }
                case 11: {
                    doneOuter = true;
                    break;
                }
                default: break;
            }
            
        }
    }
}
