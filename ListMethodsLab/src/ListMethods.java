/*
 * Created by Matt Puckett on Feb 5, 2015
 */

/**
 *
 * @author Matt
 */
import java.util.ArrayList;
public class ListMethods {
    public static ArrayList<Integer> makeList(int n){
        ArrayList<Integer> tempList = null;
        if(n <= 0){
            tempList = new ArrayList<>();
        }
        else{
            tempList = makeList(n - 1);
            tempList.add(n);
       }
        return tempList;
    }
    public static ArrayList<Integer> reverseList(ArrayList<Integer> list){
        ArrayList<Integer> rList = deepClone(list);
        if(rList.isEmpty() || rList.size() == 1){
            return rList;
        }
        else{
            Integer tempInt = rList.remove(0); //remove(0) removes the value at index 0 and places it in tempInt, same thing as using get() then remove()
            rList = reverseList(rList);
            rList.add(tempInt);
        }
        return rList;
    }
    public static ArrayList<Integer> even(ArrayList<Integer> tList){
        ArrayList<Integer> list = deepClone(tList);
        if(list.isEmpty()){
            return list;
        }
        else{
            Integer tempInt = list.remove(0);
            list.remove(0);
            list = even(list);
            list.add(0, tempInt);
        }
        return list;
    }
    public static ArrayList<Integer> odd(ArrayList<Integer> tList){
        ArrayList<Integer> list = deepClone(tList);
        if(list.isEmpty()){
            return list;
        }
        else{
            list.remove(0);
            Integer tempInt = list.remove(0);
            list = odd(list);
            list.add(0, tempInt);
        }
        return list;
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> list1Clone = deepClone(list1);
        ArrayList<Integer> list2Clone = deepClone(list2);
        ArrayList<Integer> mergeClone = new ArrayList<>();
        if(list1Clone.size() > list2Clone.size()){
            if(list2Clone.isEmpty()){
                return list1Clone;
            }
            else{
                Integer tempInt1 = list1Clone.remove(list1Clone.size()-1);
                Integer tempInt2 = list2Clone.remove(list2Clone.size()-1);
                list1Clone = merge(list1Clone, list2Clone);
                if(tempInt1.intValue() > tempInt2.intValue()){
                    list1Clone.add(tempInt2);
                    list1Clone.add(tempInt1);
                }
                else{
                    list1Clone.add(tempInt1);
                    list1Clone.add(tempInt2);
                }
                if(list1Clone.get(list1Clone.size() - 3) >= list1Clone.get(list1Clone.size() - 2)){
                    list1Clone.add((list1Clone.size() - 2), list1Clone.remove(list1Clone.size() - 3));
                }
            }
            mergeClone = list1Clone;
        }
        else if(list1Clone.size() < list2Clone.size()){
            if(list1Clone.isEmpty()){
                return list2Clone;
            }
            else{
                Integer tempInt1 = list1Clone.remove(list1Clone.size()-1);
                Integer tempInt2 = list2Clone.remove(list2Clone.size()-1);
                list2Clone = merge(list1Clone, list2Clone);
                if(tempInt1.intValue() > tempInt2.intValue()){
                    list2Clone.add(tempInt2);
                    list2Clone.add(tempInt1);
                }
                else{
                    list2Clone.add(tempInt1);
                    list2Clone.add(tempInt2);
                }
                if(list2Clone.get(list2Clone.size() - 3) >= list2Clone.get(list2Clone.size() - 2)){
                    list2Clone.add((list2Clone.size() - 2), list2Clone.remove(list2Clone.size() - 3));
                }
            }
            mergeClone = list2Clone;
        }
        else if(list1Clone.size() == list2Clone.size()){
            if(list1Clone.size() == 1 && list2Clone.size() == 1){
                Integer tempInt1 = list1Clone.remove(list1Clone.size() - 1);
                Integer tempInt2 = list2Clone.remove(list2Clone.size() - 1);
                if(tempInt1.intValue() > tempInt2.intValue()){
                    list1Clone.add(tempInt2);
                    list1Clone.add(tempInt1);
                }
                else{
                    list1Clone.add(tempInt1);
                    list1Clone.add(tempInt2);
                }
                return list1Clone;
            }
            else{
                Integer tempInt1 = list1Clone.remove(list1Clone.size()-1);
                Integer tempInt2 = list2Clone.remove(list2Clone.size()-1);
                list1Clone = merge(list1Clone, list2Clone);
                if(tempInt1.intValue() > tempInt2.intValue()){
                    list1Clone.add(tempInt2);
                    list1Clone.add(tempInt1);
                }
                else{
                    list1Clone.add(tempInt1);
                    list1Clone.add(tempInt2);
                }
                if(list1Clone.get(list1Clone.size() - 3) >= list1Clone.get(list1Clone.size() - 2)){
                    list1Clone.add((list1Clone.size() - 2), list1Clone.remove(list1Clone.size() - 3));
                }
            }
            mergeClone = list1Clone;
        }
        return mergeClone;
    }
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList){
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : tList){
            list.add(new Integer(i));
        }
        return list;
    }
}
