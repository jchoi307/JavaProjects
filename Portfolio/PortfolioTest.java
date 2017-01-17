public class PortfolioTest
{
    public static void main(String [] args)
    {
        Portfolio money = new Portfolio();
        money.deposit(500, "S");
        money.withdraw(250, "S");
        money.transfer(100, "S");
        System.out.println("money in checking: " + money.getBalance("C"));
        System.out.println("money in savings: " + money.getBalance("S"));
    }

}