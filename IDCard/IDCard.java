class IDCard extends Card
{   
   private String ID;
   
   public IDCard()
   {
      super();
      ID = "";
   }
   public IDCard(String name, String id2)
   {   
      super(name);
      ID = id2;
   }
   public String format()
   {
      return super.format() + "\n ID: " + ID;
   }
   public String toString()
   {
      return super.toString() + "[ID = " + ID + "]";
   }
   public boolean equals(Object obj)
   {
      if (!super.equals(obj))
      {
         return false;
      }
      IDCard card = (IDCard) obj;
      return ID.equals(card.ID);
   }
}