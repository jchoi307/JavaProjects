/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
public class LinearSearch {
    
    public static int search(int[] a, int value){
        for(int i = 0; i < a.length; i++){
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }
    
}
