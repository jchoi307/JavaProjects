/*
 * Created by Matt Puckett on Feb 10, 2015
 */

/**
 *
 * @author Matt
 */
public class SelectionSorter {
    public static void sort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int miniPos = minimumPosition(a, i);
            ArrayUtil.swap(a, miniPos, i);
        }
    }
    public static int minimumPosition(int[] a, int from){
        int miniPos = from;
        for(int i = from + 1; i < a.length; i++){
            if(a[i] < a[miniPos]){
                miniPos = i;
            }
        }
        return miniPos;
    }
    
}
