/*
 * Created by Matt Puckett on Feb 19, 2015
 */
package rectanglectest;

/**
 *
 * @author Matt
 */
public class ComparableRectangle extends Rectangle implements Comparable<Rectangle> {
    public ComparableRectangle(int L, int W){
        super(L, W);
    }
    @Override
    public int compareTo(Rectangle x){
        if(super.getArea() == x.getArea()){
            return 0;
        }
        else if(super.getArea() > x.getArea()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
