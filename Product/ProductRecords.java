import java.io.IOException;
import java.io.RandomAccessFile;

public class ProductRecords
{    
   private RandomAccessFile file;
   public static final int NAME_SIZE = 60;
   public static final int PRICE_SIZE = 8;
   public static final int QUANT_SIZE = 4;
   public static final int RECORD_SIZE = NAME_SIZE + PRICE_SIZE + QUANT_SIZE;
   
   public ProductRecords()
   {
      file = null;
   }
   
   public void open(String fileName) throws IOException
   {
      if(file != null){ file.close(); }
      file = new RandomAccessFile(fileName, "rw");
   }
   
   public int size() throws IOException
   {
      return (int)(file.length()/RECORD_SIZE); 
   }
   
   public void close() throws IOException
   {
      if(file != null){ file.close(); }
      file = null;
   }
   
   public Product read(int n) throws IOException
   {
      file.seek(n*RECORD_SIZE);
      char[] tempName = new char[30];
      for(int i = 0; i < 30; i++)
      {
         tempName[i] = file.readChar();
      }
      double tempPrice = file.readDouble();
      int tempQuant = file.readInt();
      return new Product(tempName, tempPrice, tempQuant);
   }
    
   public int find(char[] name) throws IOException
   {
      for(int i = 0; i < size(); i++)
      {
         file.seek(i*RECORD_SIZE);
         char[] tempName = new char[30];
         for(int j = 0; j < 30; j++)
         {
            tempName[j] = file.readChar();
         }
         if(name == tempName)
         { System.out.println(i); 
         return i; }
         break;
      }
      return -1;
   }
    
   public void write(int n, Product tempProd) throws IOException
   {
      file.seek(n*RECORD_SIZE);
      
      for(int i = 0; i < 30; i++)
      {
         file.writeChar(tempProd.getName()[i]);
      }
      file.writeDouble(tempProd.getPrice());
      file.writeInt(tempProd.getQuant());
   }
}