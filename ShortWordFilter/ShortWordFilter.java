import java.util.*;

public class ShortWordFilter implements Filter 
{
   public boolean accept(Object x)
   {
      return x.toString().length() < 5;
   }
   public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f)
   {
      ArrayList<Object> finished = new ArrayList<Object>();
      for (Object object : objects)
      {
         if (f.accept(object))
         {
            finished.add(object);
         }
      }
         return finished;
   }
}