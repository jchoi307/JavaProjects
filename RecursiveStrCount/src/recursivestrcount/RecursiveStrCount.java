/*
 * Created by Matt Puckett on Feb 19, 2015
 */
package recursivestrcount;

/**
 *
 * @author Matt
 */
public class RecursiveStrCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "bcbcbcblolooj";
        int x = CharCount.count(str, 'j');
        System.out.println(x);
    }
    
}
