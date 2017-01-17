import java.io.IOException;
import java.util.Scanner;


public class ProductDatabase 
{
   public static void main(String[] args) throws IOException
   {
      Scanner in = new Scanner(System.in);
      ProductRecords records = new ProductRecords();
      try
      {
         records.open("ProductRecords.bin");
            
         boolean done = false;
         while(!done)
         {
            System.out.print("\nProduct name : ");
            String newName = in.next().toLowerCase();
            char[] cName = new char[30];
            newName.getChars(0, newName.length(), cName, 0);
            System.out.print("Set Price of product : ");
            double newPrice = in.nextDouble();
            System.out.print("Set Quantity of product : ");
            int newQuant = in.nextInt();
            
            int position = records.find(cName);
            
            Product product;
            if(position >= 0)
            {
               product = records.read(position);
               product.setPrice(newPrice);
               product.setQuant(newQuant);
               System.out.println("\nUpdate Product : " + product.getProduct());
            } 
            else
            {
               product = new Product(cName, newPrice, newQuant);
               position = records.size();
               System.out.println("\nNew Product : " + product.getProduct());
            }
            records.write(position, product);
                
            System.out.print("Done? (Y/N): ");
            String input = in.next();
            if(input.equalsIgnoreCase("Y")){ done = true; }
         }
      }
      finally
      {
         records.close();
      }
   }    
}