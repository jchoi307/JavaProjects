/*
 * Created by Matt Puckett on Feb 10, 2015
 */

/**
 *
 * @author Matt
 */
import java.util.Arrays;
public class InClassSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = ArrayUtil.randomIntArray(21, 30);
        System.out.println(Arrays.toString(a));
        
        StopWatch timer = new StopWatch();
        timer.start();
        InsertionSort.sort(a);
        timer.stop();
        System.out.println(Arrays.toString(a));
        System.out.println("Elapsed time: " + timer.getElapsedTime() + " ms");
        System.out.println(BinarySearch.search(a, 0, a.length - 1, 25));
    }
    
}
