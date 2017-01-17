/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matt
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveTA {
    
    //Scanner in = new Scanner(System.in);
    File saveFile = new File("students.txt");
    private ArrayList<String> records;
    
    public SaveTA() {
        try{
            PrintWriter sOut = new PrintWriter(saveFile);
            sOut.print("");
            sOut.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public SaveTA(String output) {
        /* Converting output string to arraylist<string> for sorting by grad & undergrad
        Scanner strIn = new Scanner(output);
        records = new ArrayList<String>();
        while(strIn.hasNext()){
            records.add(strIn.next());
        }
        */
        
        try{
            PrintWriter sOut = new PrintWriter(saveFile);
            sOut.print(output);
            sOut.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}

