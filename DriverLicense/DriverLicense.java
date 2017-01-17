import java.util.*;

public class DriverLicense extends Card
{   
   private int expYear;
   
   public DriverLicense()
   {
      super();
      expYear = 0;
   }
   public DriverLicense(String name, int exp)
   {   
      super(name);
      expYear = exp;
   }
   public boolean isExpired()
   {  
      GregorianCalendar calendar = new GregorianCalendar();
      int currentYear = calendar.get(Calendar.YEAR);
      if(expYear >= currentYear)
      {   
         return false;
      }
      else
      {
         return true;
      }
   }
   public String format()
   {
      return "Driver License holder : " + getName() + "\nExpiration Year : " + expYear;
   }
}