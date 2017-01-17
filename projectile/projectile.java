import java.util.*;
import java.math.*;

public class projectile{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      final double vi = in.nextDouble();
      double v = vi;
      double g = 9.81;
      final double DELTA_T = 0.01;
      double t2 = 0;
      double s = v * DELTA_T;
      int t = 0;
      boolean velo = false;
      
      for (int i=0; ;i++) {
         
         s = s + Math.abs(v) * DELTA_T;
         v = v - g * DELTA_T;
         t2 += DELTA_T;
         
         if (i == 100){
            t++;
            System.out.println("current position at " + t + " second : " + s);
            System.out.println("cuttent velocity at " + t + " second : " + v);
            System.out.println();
            i = 0;
         }
         if (v <= 0){
            velo = true;
            System.out.println("Final position at " + Math.round(t2*100d)/100d + " second : " + s);
            System.out.println("Final velocity at " + Math.round(t2*100d)/100d + " second : " + v);
            System.out.println("by the equation, s(t) = -1/2gt^2 + vi*t");
            System.out.println("s(t) = " + ((-0.5)*g*t*t + vi*t));
            break;    
         }     
      }      
   }
}