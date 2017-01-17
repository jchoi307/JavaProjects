/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouplayouttest;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Matt
 */
public class Build extends JFrame {
    private JPanel panel1, panel2, panel3, panel4;
    private final int FRAME_WIDTH = 450;
    private final int FRAME_HEIGHT = 520;
    private JLabel takeOffLabel, landLabel;
    private JTextField takeOffTxt, landTxt;
    private JTextArea takeOffQ, landQ, airStrip;
    private JButton addTOQ, addLQ, nextPlane;
    private JScrollPane takeOffScroll, landScroll, stripScroll;
    private Border inputBorder, displayBorder;
    
    public Build(){
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.createComp();
        this.setLayout(new GridLayout(2,2));
    }
    public void createComp(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        takeOffLabel = new JLabel("Plane Taking Off:");
        landLabel = new JLabel("Plane Landing:");
        
        takeOffTxt = new JTextField();
        landTxt = new JTextField();
        
        takeOffQ = new JTextArea(30, 1);
        landQ = new JTextArea(30, 1);
        airStrip = new JTextArea(15, 1);
        
        addTOQ = new JButton("Add to Queue");
        addLQ = new JButton("Add to Queue");
        nextPlane = new JButton("Next Plane in Queue");
        
        takeOffScroll = new JScrollPane(takeOffQ);
        landScroll = new JScrollPane(landQ);
        stripScroll = new JScrollPane(airStrip);
        
        inputBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Traffic Input"),
            BorderFactory.createEmptyBorder(5,10,5,10));
        displayBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Traffic Display"),
            BorderFactory.createEmptyBorder(5,10,5,10));
        
        GroupLayout p1Layout = new GroupLayout(panel1);
        p1Layout.setAutoCreateGaps(true);
        p1Layout.setAutoCreateContainerGaps(true);
        p1Layout.setHorizontalGroup(
                p1Layout.createSequentialGroup()
                    .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(takeOffLabel)
                        .addComponent(takeOffTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addTOQ, GroupLayout.Alignment.CENTER))
        );
        p1Layout.setVerticalGroup(
                p1Layout.createSequentialGroup()
                    .addComponent(takeOffLabel)
                    .addComponent(takeOffTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTOQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        GroupLayout p3Layout = new GroupLayout(panel3);
        p3Layout.setAutoCreateGaps(true);
        p3Layout.setAutoCreateContainerGaps(true);
        p3Layout.setHorizontalGroup(
                p3Layout.createSequentialGroup()
                    .addGroup(p3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(landLabel)
                        .addComponent(landTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addLQ, GroupLayout.Alignment.CENTER))
        );
        p3Layout.setVerticalGroup(
                p3Layout.createSequentialGroup()
                    .addComponent(landLabel)
                    .addComponent(landTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        GroupLayout p2Layout = new GroupLayout(panel2);
        p2Layout.setAutoCreateGaps(true);
        p2Layout.setAutoCreateContainerGaps(true);
        p2Layout.setHorizontalGroup(
                p2Layout.createSequentialGroup()
                    .addComponent(takeOffQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(landQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        p2Layout.setVerticalGroup(
                p2Layout.createSequentialGroup()
                    .addGroup(p2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(takeOffQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(landQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        GroupLayout p4Layout = new GroupLayout(panel4);
        p4Layout.setAutoCreateGaps(true);
        p4Layout.setAutoCreateContainerGaps(true);
        p4Layout.setHorizontalGroup(
                p4Layout.createSequentialGroup()
                    .addGroup(p4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(airStrip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextPlane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        p4Layout.setVerticalGroup(
                p4Layout.createSequentialGroup()
                    .addComponent(airStrip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextPlane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        
        panel1.setLayout(p1Layout);
        panel1.add(takeOffLabel);
        panel1.add(takeOffTxt);
        panel1.add(addTOQ);
        
        panel2.setLayout(p2Layout);
        panel2.add(takeOffQ);
        panel2.add(landQ);
        
        panel3.setLayout(p3Layout);
        panel3.add(landLabel);
        panel3.add(landTxt);
        panel3.add(addLQ);
        
        panel4.setLayout(p4Layout);
        panel4.add(airStrip);
        panel4.add(nextPlane);
        
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        
    }
}
