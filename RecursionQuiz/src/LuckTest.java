/*
 * Created by Matt Puckett on Feb 10, 2015
 */

/**
 *
 * @author Matt
 */
public class LuckTest {
    public static boolean isLucky(int test){
        boolean luck;
        String testString = "" + test;
        if(testString.length() == 0){
            luck = false;
        }
        else if(testString.charAt(0) == '8'){
            luck = true;
        }
        else{
            String testString2 = testString.substring(1, (testString.length()-1));
            int testInt = Integer.parseInt(testString2);
            luck = isLucky(testInt);
        }
        return luck;
    }  
}
