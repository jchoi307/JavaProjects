public class Card
{   
   public String name;
   public Card()
   {   
      name = "";
   }
   public Card(String n)
   {   
      name = n;
   }
   public String getName()
   {
      return name;
   }
   public boolean isExpired()
   {   
      return false;
   }
   public String format()
   {   
      return "Card holder: " + name;
   }
   public String toString()
   {   
      String temp = "Card[name=" + name + "]";
      return temp;
   }
   public boolean equals(Object obj)
   {   
      if (obj == null)
      {
         return false;
      }
      if (!getClass().equals(obj.getClass()))
      {
         return false;
      }
      Card card = (Card) obj;
      return name.equals(card.name);
   }
}