/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p15.pkg1;
import java.util.*;
/**
 *
 * @author Matt
 */
public class P151 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> employeeNames = new LinkedList<String>();
        employeeNames.add("John");
        employeeNames.add("Jane");
        employeeNames.add("Emma");
        employeeNames.add("Matt");
        employeeNames.add("Leah");
        employeeNames.add("Scott");
        employeeNames.add("Chris");
        employeeNames.add("Jaymi");
        employeeNames.add("Robby");
        //System.out.println(employeeNames);
        //System.out.println(employeeNames.size());
        //downsize(employeeNames, 2);
        reverse(employeeNames);
        //System.out.println(employeeNames);
        String toReverse = "Marry had a little lamb.";
        String reversed = reverseString(toReverse);
        //System.out.println(reversed);
        int testNum = 1792;
        splitNum(testNum);
    }
    public static void downsize(LinkedList<String> employeeNames, int n){
        //int[] iter = new int[employeeNames.size() / n];
        int k = employeeNames.size() / n;
        //int j = n;
        /*
        for(int i = 0; i < iter.length; i++){
            iter[i] = j - 1;
            System.out.println(iter[i]);
            j += n;
        }
        */
        /*
        for(int i = 0; i < iter.length; i++){
            employeeNames.remove(iter[iter.length - i - 1]);
        }
          */      
        for(int i = k; i > 0; i--){
            employeeNames.remove((i*n)-1);
        }
    }
    public static void reverse(LinkedList<String> strings){
        for(int i = strings.size() - 1; i >= 0; i--){
            strings.add(i, strings.removeFirst());
        }
    }
    public static String reverseString(String toReverse){
        String sentence = toReverse;
        Scanner input = new Scanner(sentence);
        Stack container = new Stack();
        while(input.hasNext()){
            String temp = input.next();
            if(temp.charAt(temp.length() - 1) == '.'){
                container.push(temp.substring(0, temp.length()-1));
                break;
            }
            else{
                container.push(temp.toLowerCase());
            }
        }
        sentence = (String)container.pop();
        sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
        while(!container.empty()){
            sentence = sentence + " " + (String)container.pop();
        }
        sentence = sentence + ".";
        return sentence;
    }
    public static void splitNum(int n){
        Stack<Integer> nums = new Stack<>();
        int x = n;
        while(x > 10){
            nums.push(new Integer(x%10));
            x = x/10;
        }
        nums.push(new Integer(x));
        while(nums.size() > 0){
            System.out.print(nums.pop() + " ");
        }
    }
}
