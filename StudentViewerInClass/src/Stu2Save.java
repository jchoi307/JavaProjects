/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Stu2Save {
      //  private Scanner db;
 //   private File file;

    public static void save(ArrayList<Stu> stu) {
        String stutxt = "";
        if (stu.size() > 0)
        {
        File file = new File("studentdb.txt");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(file, true));
            for (Stu tempstu : stu) {
               if (!(tempstu instanceof Grad))
                stutxt += String.format(tempstu.toString() + "%n");
            }
            for (Stu tempstu : stu) {
               if (tempstu instanceof Grad)
                stutxt += String.format(tempstu.toString() + "%n");
            }
            
            write.write(stutxt);
            write.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        }
    }
}
