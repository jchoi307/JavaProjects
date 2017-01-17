public class driversLicense extends Card
{   
   private int expYear;
   
   driversLicense(String name, int exp)
   {   
      super(name);
      expYear = exp;
   }
   public boolean isExpired()
   {   
      if(expYear >= 2014)
      {   
         return false;
      }
      else
      {
         return true;
      }
   }
}