public class Portfolio 
{
   BankAccount checking;
   BankAccount savings;
   
   public Portfolio()
   {
      checking = new BankAccount();
      savings = new BankAccount();
   }
   
   public void deposit(double amount, String account)
   {
      if (account.equals("C"))
      {
         checking.deposit(amount);
      }
      else if (account.equals("S"))
      {
         savings.deposit(amount);
      }
   }

   public void withdraw(double amount, String account)
   {
      if (account.equals("C"))
      {
         checking.withdraw(amount);
      }
      else if (account.equals("S"))
      {
         savings.withdraw(amount);
      }
   }


   public void transfer(double amount, String account)
   {
      if (account.equals("C"))
      {
         checking.withdraw(amount);
         savings.deposit(amount);
      }
      else if (account.equals("S"))
      {
         savings.withdraw(amount);
         checking.deposit(amount);
      }
   }

   public double getBalance(String account)
   {
      if (account.equals("C"))
      {
         return checking.getBalance();
      }
      else
      {
         return savings.getBalance();
      }
   }
}