public class Billfold
{   
   private Card card1, card2;
   
   public Billfold()
   {
      card1 = null;
      card2 = null;
   }
   public void addCard(Card x)
   {   
      if(card1 == null)
      {   
         card1 = x;
      }
      else if(card2 == null)
      {
         card2 = x;
      }
   }
   public String format()
   {   
      if(card1 != null)
      {   
         if(card2 != null)
         {   
            card1.format();
            card2.format();
         }
         else
         {
            card1.format();
         }
      }
      else
      {   
         return "";
      }
      return "";
   }
   public int getExpiredCardCount()
   {   
      if(card1 != null && card2 != null)
      {   
         if(card1.isExpired() == true && card2.isExpired() == false)
         {   
            System.out.println("Card 1 has expired, but Card 2 has not.");
            return 1;
         }
         else if(card1.isExpired() == false && card2.isExpired() == false)
         {
            System.out.println("Neither Card has expired.");
            return 0;
         }
         else if(card1.isExpired() == false && card2.isExpired() == true)
         {   
            System.out.println("Card 1 has not expired, but Card 2 has.");
            return 1;
         }
         else if(card1.isExpired() == true && card2.isExpired() == true)
         {
            System.out.println("Both Cards have expired.");
            return 2;
         }
         else
         {   
            System.out.println("Error");
         }
      }
      else if(card1 != null && card2 == null)
      {   
         if(card1.isExpired() == true)
         {   
            System.out.println("Have only 1 Card, and it has expired.");
            return 0;
         }
         else if(card1.isExpired() == false)
         {   
            System.out.println("Have only 1 Card,and it has not expired.");
            return 1;
         }
         else
         {   
            System.out.println("Error");
         }
      }
      else if(card1 == null)
      {   
         System.out.println("No cards available.");
      }
      else
      {   
         System.out.println("Error");
      }
      return 0;
   }
}