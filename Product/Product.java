public class Product 
{
   private char[] name;
   private double price;
   private int quantity;
    
   public Product(char[] name, double price, int quantity)
   {
      this.name = new char[30];
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }
   
   public void setPrice(double newPrice)
   {
      this.price = newPrice;
   }
   
   public void setQuant(int newQuant)
   {
      this.quantity = newQuant;
   }
   
   public char[] getName()
   {
      return this.name;
   }
   
   public double getPrice()
   {
      return this.price;
   }
   
   public int getQuant()
   {
      return this.quantity;
   } 
    
   public String getProduct()
   {
      String sName = new String(this.name);
      return sName + "\n"+"Price per Unit: $" + this.price + "\nQuantity: " + this.quantity;
   }
}