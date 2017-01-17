/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
public class BubbleSort {
    
    public static int[] sort(int[] a){
        int temp;
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 1; j < a.length - i; j++){
                if(a[j-1] > a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
