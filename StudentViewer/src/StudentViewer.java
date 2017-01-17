/**
 *
 * @author Matt
 */

import javax.swing.*;

public class StudentViewer {
    public static void main(String[] args){
        FrameMgr frameMain = new FrameMgr();
        frameMain.setTitle(FrameMgr.School + " Student Viewer");
        frameMain.setSize(550, 445);
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);
        
    }
    
}
