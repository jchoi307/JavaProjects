/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicatesarray;
import java.util.*;
/**
 *
 * @author Matt
 */
public class RemoveDuplicatesArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {2,2,4,5,2,6,8,9,2,8,9};
        int[] b = new int[a.length];
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(!isThere(b, a[i])){
                b[count] = a[i];
                count++;
            }
        }
        for(int g : b){
            System.out.println(g);
        }
    }
    public static boolean isThere(int[] x, int num){
        for(int item : x){
            if(item == num){
                return true;
            }
        }
        return false;
    }
    
}
