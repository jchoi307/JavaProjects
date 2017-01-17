/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
public class InsertionSort {
    public static void sort(int[] a){
        for(int i = 1; i < a.length; i++){
            int next = a[i];
            int j = i;
            while(j > 0 && a[j - 1] > next){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = next;
        }
    }
}
