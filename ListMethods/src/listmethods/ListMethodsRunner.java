import java.util.ArrayList;

public class ListMethodsRunner
{
   public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(100);
      tempList = ListMethods.reverseList(tempList);
      for (Integer i : tempList)
      {
         System.out.println(i);
      }
   }
}