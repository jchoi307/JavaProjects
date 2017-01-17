/*
 * Created by Matt Puckett on Feb 19, 2015
 */
package rectanglectest;

/**
 *
 * @author Matt
 */
public class Rectangle {
    private int length;
    private int width;
    public Rectangle(int L, int W){
        this.length = L;
        this.width = W;
    }
    public int getArea(){
        return this.length*this.width;
    }
}
