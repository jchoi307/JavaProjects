/*
 * Created by Matt Puckett on Feb 5, 2015
 */

/**
 *
 * @author Matt
 */
import java.util.ArrayList;
public class ListMethodsLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(9);
        list1.add(22);
        list1.add(38);
        list1.add(56);
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(7);
        list2.add(8);
        list2.add(23);
        list2.add(47);
        list2.add(55);
        list1.add(60);
        ArrayList<Integer> tempList = ListMethods.merge(list1, list2);
        
        
        if(tempList.isEmpty()){
            System.out.println("Empty!");
        }
        else{
            for(Integer i : tempList){
                System.out.println(i);
            }
        }
    }
    
}
