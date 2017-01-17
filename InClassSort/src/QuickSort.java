/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
public class QuickSort {
    public static int partition(int[] a, int left, int right){
        int i = left; int j = right;
        //int pivot = a[(i + j)/2];
        int pivot = a[left];
        int tmp;
        
        while(i <= j){
            while(a[i] < pivot){
                i++;
            }
            while(a[j] > pivot){
                j--;
            }
            if(i <= j){
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++; j--;
            }
        }
        return i;
    }
    public static void quickSort(int[] a, int left, int right){
        int p = partition(a, left, right);
        if(left < p - 1){
            quickSort(a, left, p - 1);
        }
        if(p < right){
            quickSort(a, p, right);
        }
    }
}
