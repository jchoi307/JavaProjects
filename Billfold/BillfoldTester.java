class BillfoldTester
{   
   public static void main(String[] args)
   {  
      Card DL, IC, CC;
      Billfold b1 = new Billfold();
      System.out.println("before add : " + b1.getExpiredCardCount());
      b1.addCard(new DriverLicense("Choi", 2009));
      System.out.println("after add 1 : " + b1.getExpiredCardCount());
      b1.addCard(new DriverLicense("Nat", 2016));
      System.out.println("after add 2 : " + b1.getExpiredCardCount());
      IC = new IDCard("Joon", "N2207");
      CC = new CallingCard("Gyu", 8, 25);
      System.out.println(IC.format());
      System.out.println(IC.toString());
      System.out.println(CC.format());
   }
}