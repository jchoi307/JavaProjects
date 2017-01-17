public class CallingCard extends Card
{   
   private int cardNumber;
   private int PIN;
   
   public CallingCard()
   {
      super();
      cardNumber = 0;
      PIN = 0;
   }   
   public CallingCard(String name, int cn, int pin)
   {   
      super(name);
      cardNumber = cn;
      PIN = pin;
   }
   public String format()
   {
      String result = super.format();
      result += "\nCallingCard: [ Card number = " + cardNumber + ", PIN = " + PIN + " ]";
      return result;
   }
}