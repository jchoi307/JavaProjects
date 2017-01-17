/*
 * Created by Matt Puckett on Feb 5, 2015
 */

/**
 *
 * @author Matt
 */
import java.util.*;
public class ListMethods {
    public ListMethods(){}
    public static ArrayList<Integer> makeList(int n){
        ArrayList<Integer> tempList = null;
        if(n <= 0){
            tempList.add(tempList.size()+1);
            return tempList;
        }
        else{
            tempList = makeList(n-1);
            return  tempList;
        }
    }
}
