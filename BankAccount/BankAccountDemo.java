import java.util.Scanner;

/**
   This program simulates a bank with checking and savings accounts.
*/
public class AccountDemo
{
   public static void main(String[] args)
   {
      // Create accounts

      final int ACCOUNTS_SIZE = 10;
      BankAccount[] accounts = new BankAccount[ACCOUNTS_SIZE];
      for (int i = 0; i < accounts.length / 2; i++)
      {      
         accounts[i] = new CheckingAccount();
      }
      
      for (int i = accounts.length / 2; i < accounts.length; i++)
      {      
         SavingsAccount account = new SavingsAccount();
         account.setInterestRate(0.75);
         accounts[i] = account;
      }

      // Execute commands

      Scanner in = new Scanner(System.in);
      boolean done = false;
      while (!done)
      {
         System.out.print("D)eposit  W)ithdraw  M)onth end  Q)uit: "); 
         String input = in.next();
         if (input.equals("D") || input.equals("W")) // Deposit or withdrawal
         {
            System.out.print("Enter account number and amount: ");
            int num = in.nextInt();
            double amount = in.nextDouble();

            if (input.equals("D")) { accounts[num].deposit(amount); }
            else { accounts[num].withdraw(amount); }

            System.out.println("Balance: " + accounts[num].getBalance());
         }
         else if (input.equals("M")) // Month end processing
         {
            for (int n = 0; n < accounts.length; n++)
            {
               accounts[n].monthEnd();
               System.out.println(n + " " + accounts[n].getBalance());
            }
         }
         else if (input == "Q")
         {
            done = true;
         }
      }
   }
}

///////////////////
/**
   A bank account has a balance and a mechanism for applying interest or fees at 
   the end of the month.
*/
public class BankAccount
{
   private double balance;

   /**
      Constructs a bank account with zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Makes a deposit into this account.
      @param amount the amount of the deposit
   */
   public void deposit(double amount)
   {
      balance = balance + amount;
   }
   
   /**
      Makes a withdrawal from this account, or charges a penalty if
      sufficient funds are not available.
      @param amount the amount of the withdrawal
   */
   public void withdraw(double amount)
   {
      balance = balance - amount;
   }
   
   /**
      Carries out the end of month processing that is appropriate
      for this account.
   */
   public void monthEnd() 
   {
   }
   
   /**
      Gets the current balance of this bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }
}
////////////
/**
   A savings account earns interest on the minimum balance.
*/
public class SavingsAccount extends BankAccount
{
   private double interestRate;
   private double minBalance; 

   /**
      Constructs a savings account with a zero balance.
   */
   public SavingsAccount()
   {
      interestRate = 0;
      minBalance = 0;
   }

   /**
      Sets the interest rate for this account.
      @param rate the monthly interest rate in percent
   */
   public void setInterestRate(double rate)
   {
      interestRate = rate;
   }

   public void withdraw(double amount)
   {
      super.withdraw(amount);
      double balance = getBalance();
      if (balance < minBalance)
      {
         minBalance = balance;
      }
   }
   
   public void monthEnd()
   {
      double interest = minBalance * interestRate / 100;
      deposit(interest);
      minBalance = getBalance();
   }
}
//////////////////
/**
   A checking account has a limited number of free deposits and withdrawals.
*/
public class CheckingAccount extends BankAccount
{
   private int withdrawals;

   /**
      Constructs a checking account with a zero balance.
   */
   public CheckingAccount()
   {
      withdrawals = 0;
   }

   public void withdraw(double amount)
   {
      final int FREE_WITHDRAWALS = 3;
      final int WITHDRAWAL_FEE = 1;
      
      super.withdraw(amount);  
      withdrawals++;
      if (withdrawals > FREE_WITHDRAWALS)
      {
         super.withdraw(WITHDRAWAL_FEE);  
      }
   }

   public void monthEnd()
   {
      withdrawals = 0;
   }
}

////////////////////////