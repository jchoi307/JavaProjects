/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ArrayTest01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<String> blah = new ArrayList<String>();
        
        System.out.println("Enter 5 strings: ");
        for(int i = 0; i < 5; i++){
            blah.add(input.nextLine());
        }
        System.out.println("Array full!");
        
        for(String element : blah){
            System.out.println(element);
        }
        
    }
    
}
