/*
 * Created by Matt Puckett on Feb 12, 2015
 */

/**
 *
 * @author Matt
 */
import java.util.Scanner;
public class Hanoi {
    
    public void solve(int n, String start, String aux, String end){
        if(n == 1){
            System.out.println(start + " -> " + end);
        }
        else{
            solve(n - 1, start, end, aux);
            System.out.println(start + " -> " + end);
            solve(n - 1, aux, start, end);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Hanoi tower = new Hanoi();
        System.out.print("Enter number of discs: ");
        int discs = in.nextInt();
        tower.solve(discs, "A", "B", "C");
    }
}
