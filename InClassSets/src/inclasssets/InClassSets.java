/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasssets;

import java.util.*;
/**
 *
 * @author Matt
 */
public class InClassSets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Set<String> set1h = new HashSet<>();
        addTo(set1h);
        System.out.println(set1h);
        System.out.println("Changing to TreeSet");
        Set<String> set2t = new TreeSet<>(set1h);
        System.out.println(set2t);
        
    }
    public static Set<String> addTo(Set<String> addWords){
        Set<String> wordsAdded = addWords;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Add words to the set, enter -1 to stop: ");
        for(int i = 0; i < 5; i++){
            wordsAdded.add(input.nextLine());
        }
        return wordsAdded;
    }
    
}
