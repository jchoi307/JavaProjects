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
public class ClassTest01 {
    public static void main(String[] args){
        Counter testlul = new Counter();
        Scanner input = new Scanner(System.in);
        
        testlul.count();
        testlul.count();
        testlul.count();
        //testlul.getValue();
        
        while(input.hasNext()){
            String lol = input.nextLine();
            System.out.println(lol);
            break;
        }
        
    }
    
}
