import java.util.*;
import java.io.*;


public class Indexer{
    private static TreeMap<String, TreeSet<Integer>> Index = new TreeMap<>();
    private static int pageNum = 1;
    
    
    public static void main(String[] args)throws IOException{
        Indexer();
        print();
    }
    
    private static void Indexer()throws IOException{
        Scanner s = null;
        
        s = new Scanner(new BufferedReader(new FileReader("BNW summary.txt")));
        
        if(s != null) {
                  
            s.useDelimiter("[^A-Za-z']+");
            int Count = 0;
            String stl;
        
            while(s.hasNext()){
               stl = s.next().toLowerCase();
            
               if(!Index.containsKey(stl)){
                  Index.put(stl, new TreeSet<Integer>());
                  Index.get(stl).add(pageNum);
                  
               } else {
                  Index.get(stl).add(pageNum);
               }
               Count++;
            
               if(Count == 250){ //average number of words on a page
                  pageNum++;
                  Count = 0;
               }
            }
        } else {
            s.close();
        }
    }
    
    private static void print(){
        for(String temp : Index.keySet()){
            System.out.print(temp + ": " + Index.get(temp) + "\n");
            
        }
    }
}
