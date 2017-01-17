/*
 * Created by Matt Puckett on Feb 19, 2015
 */
package recursivestrcount;

/**
 *
 * @author Matt
 */
public class CharCount {
    public static int count(String str, char c){
        int x = 0;
        if(str.isEmpty()){
            return x;
        }
        else{
            if(str.charAt(0) == c){
                x++;
            }
            x += count(str.substring(1, str.length()), c);
        }
        return x;
    }
}
