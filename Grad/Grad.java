public class Grad extends Stu{
   private String degree;
   public Grad(String name,String major, String degree)
   {
      super(name,major);
      
      this.degree = degree;
   }
   public String getDegree()
   {
      return degree;
   }
   public String toString()
   {
      return "Student: " + getName() + ", " + "Major: " + getMajor() + ", " + "Degree: " + degree;
   }
}
