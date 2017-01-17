package textindexer;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;


public class TextIndexer {
    private static TreeMap<String, TreeSet<Integer>> textIndex = new TreeMap<>();
    private static int pageNum = 1;
    
    
    public static void main(String[] args) throws FileNotFoundException{
        processIndex();
        printIndex();
    }
    private static void processIndex() throws FileNotFoundException {
        Scanner in = new Scanner(new File("twain-adventures-27.txt"));
        in.useDelimiter("[^A-Za-z']+");
        int wordCount = 0;
        String inc;
        while(in.hasNext()){
            inc = in.next().toLowerCase();
            if(!textIndex.containsKey(inc)){
                textIndex.put(inc, new TreeSet<Integer>());
                textIndex.get(inc).add(pageNum);
            } else {
                textIndex.get(inc).add(pageNum);
            }
            wordCount++;
            if(wordCount == 250){
                pageNum++;
                wordCount = 0;
            }
        }
        in.close();
    }
    private static void printIndex(){
        for(String temp : textIndex.keySet()){
            System.out.print(temp + ": " + textIndex.get(temp) + "\n");
        }
        System.out.println(pageNum);
    }
}
