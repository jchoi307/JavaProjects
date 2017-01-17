/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassmap;
import java.util.*;
/**
 *
 * @author Matt
 */
public class InClassMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] names = {"One", "Three", "Two", "One", "One", "Three", "Five", "Six", "Six", "Four", "Four", "Four", "Four"};
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer ONE = new Integer(1);
        for(int i = 0, n = names.length; i<n; i++){
            String key = names[i];
            Integer freq = map.get(key);
            if(freq == null){
                freq = ONE;
            }
            else{
                int value = freq.intValue();
                freq = value + 1;
            }
            map.put(key, freq);
        }
        System.out.println(map);
        Map sortedMap = new TreeMap(map);
        System.out.println(sortedMap);
        System.out.println("Now to sort by value...");
        ValueComparator cbv = new ValueComparator(map);
        TreeMap<String,Integer> sortedByValueMap = new TreeMap<String,Integer>(cbv);
        sortedByValueMap.putAll(map);
        System.out.println(sortedByValueMap);
    }
    
}
class ValueComparator implements Comparator<String>{
    Map<String,Integer> baseMap;
    public ValueComparator(Map<String,Integer> base){
        this.baseMap = base;
    }
    public int compare(String a, String b){
        if(baseMap.get(a) <= baseMap.get(b)){
            return -1;
        }
        else{
            return 1;
        }
    }
}
