/*
 * Created by Matt Puckett on Feb 19, 2015
 */
package rectanglectest;

/**
 *
 * @author Matt
 */
public class RectangleCTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ComparableRectangle x = new ComparableRectangle(5, 4);
        ComparableRectangle y = new ComparableRectangle(5, 5);
        System.out.println(x.compareTo(y));
    }
    
}
