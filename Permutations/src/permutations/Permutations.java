/*
 * Created by Matt Puckett on Feb 12, 2015
 */
package permutations;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Matt
 */
public class Permutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(String s : permutations("eat")){
            System.out.println(s);
        }
    }
    public static ArrayList<String> permutations(String word){
        ArrayList<String> result = new ArrayList<>();
        if(word.length() == 0){
            result.add(word);
            return result;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                String shorter = word.substring(0, i) + word.substring(i + 1);
                ArrayList<String> shorterPermutations = permutations(shorter);
                for(String s : shorterPermutations){
                    result.add(word.charAt(i) + s);
                }
            }
        }
        return result;
    }
    
}
