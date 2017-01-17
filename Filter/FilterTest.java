import java.util.*;

public class FilterTest
{
   public static void main(String [] args)
   {
      ArrayList<Object> list = new ArrayList<Object>();
      list.add(6756);
      list.add(978892);
      list.add("iphone");
      list.add("galaxy note");
      list.add("nokia");
      list.add("dell");
      list.add("asus");
      list.add(true);
      list.add(false);
      ShortWordFilter filter = new ShortWordFilter();
      ArrayList<Object> results = filter.collectAll(list, filter);
      System.out.println(results);
    }
}