
import java.util.ArrayList;
import java.util.Scanner;

public class p917 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        ArrayList<Object> startList = new ArrayList<>();
        Filter filter = new ShortWordFilter();
        
        System.out.println("Enter 10 strings into your list for sorting -");
        for(int i = 0; i < 10; i++){
            System.out.print("Enter a string: ");
            startList.add(input.nextLine());
        }
        
        System.out.println("Now for the sorting -");
        startList = collectAll(startList, filter);
        for(Object i : startList){
            System.out.println(i);
        }
        
    }
    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f){
        
        for(int i = 1; i <= objects.size(); i++){
            if(f.accept(objects.get(i))){
                objects.remove(i);
            }
        }
        objects.trimToSize();
        return objects;
        
    }
}
