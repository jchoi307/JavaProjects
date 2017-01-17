/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
public class BinarySearch {
    
    public static int search(int[] a, int low, int high, int value){
        if(low <= high){
            int mid = (low + high)/2;
            if(a[mid] == value){
                return mid;
            }
            else if(a[mid] < value){
                return search(a, mid + 1, high, value);
            }
            else{
                return search(a, low, mid - 1, value);
            }
        }
        else{
            return -1;
        }
        
    }
    
}
