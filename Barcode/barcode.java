import java.util.*;

/**
Write a program that reads in a bar code (with : denoting half bars and | denoting
full bars) and prints out the zip code it represents. Print an error message if the bar
code is not correct.
*/

public class barcode
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("input barcode: ");
      String bar = in.next();
     
      String value = "";
      int sum = 0;
      if (bar.length() == 32)
      {
         if (bar.charAt(0)== '|' && bar.charAt(31) == '|')
         {
            value = barCompare(bar, 1) + barCompare(bar, 6) + barCompare(bar, 11) + barCompare(bar, 16) + barCompare(bar, 21);
            sum = Integer.parseInt(barCompare(bar, 1)) + Integer.parseInt(barCompare(bar, 6)) + Integer.parseInt(barCompare(bar, 11)) 
                  + Integer.parseInt(barCompare(bar, 16)) + Integer.parseInt(barCompare(bar, 21)) + Integer.parseInt(barCompare(bar, 26));
            if (sum % 10 == 0)
            {
               System.out.println(value);
            }else{
               System.out.println("Wrong input");
            }
         }else{
            System.out.println("Wrong input");
         }
      }else{
         System.out.println("Wrong input");
      }
   }
   public static String barCompare(String s, int a)
   {
      if (s.substring(a,a+5).equals(":::||")) {return "1";}
      if (s.substring(a,a+5).equals("::|:|")) {return "2";}
      if (s.substring(a,a+5).equals("::||:")) {return "3";}
      if (s.substring(a,a+5).equals(":|::|")) {return "4";}
      if (s.substring(a,a+5).equals(":|:|:")) {return "5";}
      if (s.substring(a,a+5).equals(":||::")) {return "6";}
      if (s.substring(a,a+5).equals("|:::|")) {return "7";}
      if (s.substring(a,a+5).equals("|::|:")) {return "8";}
      if (s.substring(a,a+5).equals("|:|::")) {return "9";}
      if (s.substring(a,a+5).equals("||:::")) {return "0";}
      return "0";
   }
}