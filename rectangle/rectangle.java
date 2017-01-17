import java.util.Scanner;

/*
   This Program will ask the user for the lengths of a sides of a rectangle.
   Then print 1. The area and perimeter of the rectangle
              2. The length of the diagonal (use the Pythagorean Theorem)
*/
public class rectangle
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      //Get the value of width and height of rectangle from user.
      
      System.out.print("Enter the width of rectangle: ");
      double width = in.nextDouble();
      System.out.print("Enter the height of rectangle: ");
      double height = in.nextDouble();
      
      //Calculate area
      double area = width * height;
      
      //Calculate perimeter
      double perimeter = 2*width + 2*height;
      
      // Calculate the length of the diagonal
      double diagonal = Math.sqrt(width*width + height*height);
      
      //print out values
      System.out.println("The area of your rectangle is: " + area);
      System.out.println("The perimeter of your rectangle is: " + perimeter);
      System.out.println("The length of the diagonal of your rectangle is: " + diagonal);
   }
}