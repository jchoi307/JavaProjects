package p1530;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
*
* @author Matt
*/
public class FrameBuild extends JFrame {
    
    private JPanel panel1, panel2;
    private final int FRAME_WIDTH = 470;
    private final int FRAME_HEIGHT = 575;
    private JLabel takeOffLabel, landLabel, takeOffQLabel, landQLabel;
    private JTextField takeOffTxt, landTxt;
    private JTextArea takeOffQ, landQ, airStrip;
    private JButton addTOQ, addLQ, nextPlane;
    private JScrollPane takeOffScroll, landScroll, stripScroll;
    private Border inputBorder, displayBorder;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem itemExit;
    private Queue<String> takeOff;
    private Queue<String> land;
    private Listener listener;
    
    public FrameBuild(){
        this.takeOff = new LinkedList<String>();
        this.land = new LinkedList<String>();
        this.listener = new Listener();
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addMenu();
        this.createComp();
        this.setLayout(new GridLayout(2,1));
    }
    public void addMenu(){
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(listener);
        fileMenu.add(itemExit);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }
    public void createComp(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        takeOffLabel = new JLabel("Plane Taking Off:");
        landLabel = new JLabel("Plane Landing:");
        takeOffQLabel = new JLabel("Taking Off:");
        landQLabel = new JLabel("Landing:");
        
        takeOffTxt = new JTextField();
        landTxt = new JTextField();
        
        takeOffQ = new JTextArea(12,12);
        landQ = new JTextArea(12,12);
        airStrip = new JTextArea(10,35);
        takeOffQ.setLineWrap(true);
        takeOffQ.setWrapStyleWord(true);
        takeOffQ.setEditable(false);
        landQ.setLineWrap(true);
        landQ.setWrapStyleWord(true);
        landQ.setEditable(false);
        airStrip.setLineWrap(true);
        airStrip.setWrapStyleWord(true);
        airStrip.setEditable(false);
        
        takeOffScroll = new JScrollPane(takeOffQ);
        landScroll = new JScrollPane(landQ);
        stripScroll = new JScrollPane(airStrip);
        
        addTOQ = new JButton("Add to Queue");
        addTOQ.addActionListener(listener);
        addLQ = new JButton("Add to Queue");
        addLQ.addActionListener(listener);
        nextPlane = new JButton("Next Plane in Queue");
        nextPlane.addActionListener(listener);

        inputBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Traffic Input"),
            BorderFactory.createEmptyBorder(5,3,5,3));
        displayBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Traffic Display"),
            BorderFactory.createEmptyBorder(5,3,5,3));

        GroupLayout p1Layout = new GroupLayout(panel1);
        p1Layout.setAutoCreateGaps(true);
        p1Layout.setAutoCreateContainerGaps(true);
        p1Layout.setHorizontalGroup(
            p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(takeOffLabel)
                    .addComponent(takeOffTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTOQ, GroupLayout.Alignment.CENTER)
                    .addComponent(landLabel)
                    .addComponent(landTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLQ, GroupLayout.Alignment.CENTER))
                .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(takeOffQLabel)
                    .addComponent(takeOffScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(landQLabel)
                    .addComponent(landScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(takeOffLabel)
                        .addComponent(takeOffTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addTOQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(landLabel)
                        .addComponent(landTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addLQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(p1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(p1Layout.createSequentialGroup()
                            .addComponent(takeOffQLabel)
                            .addComponent(takeOffScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(p1Layout.createSequentialGroup()
                            .addComponent(landQLabel)
                            .addComponent(landScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );
        GroupLayout p2Layout = new GroupLayout(panel2);
        p2Layout.setAutoCreateGaps(true);
        p2Layout.setAutoCreateContainerGaps(true);
        p2Layout.setHorizontalGroup(
            p2Layout.createSequentialGroup()
                .addGroup(p2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(stripScroll, GroupLayout.Alignment.CENTER)
                    .addComponent(nextPlane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        p2Layout.setVerticalGroup(
            p2Layout.createSequentialGroup()
                .addComponent(stripScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(nextPlane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        panel1.setLayout(p1Layout);
        panel1.setBorder(inputBorder);
        panel1.add(takeOffLabel);
        panel1.add(takeOffTxt);
        panel1.add(addTOQ);
        panel1.add(landLabel);
        panel1.add(landTxt);
        panel1.add(takeOffQLabel);
        panel1.add(landQLabel);
        panel1.add(addLQ);
        panel1.add(takeOffScroll);
        panel1.add(landScroll);

        panel2.setLayout(p2Layout);
        panel2.setBorder(displayBorder);
        panel2.add(stripScroll);
        panel2.add(nextPlane);
        
        this.add(panel1);
        this.add(panel2);
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JMenuItem){
                JMenuItem item = (JMenuItem)e.getSource();
                if(item == itemExit){
                    System.exit(0);
                }
            }
            else if(e.getSource() instanceof JButton){
                JButton press = (JButton)e.getSource();
                if(press == addTOQ){
                    if(takeOffTxt.getText().length() > 0){
                        takeOff.add(takeOffTxt.getText());
                        takeOffTxt.setText(null);
                    }
                }
                else if(press == addLQ){
                    if(landTxt.getText().length() > 0){
                        land.add(landTxt.getText());
                        landTxt.setText(null);
                    }
                }
                else if(press == nextPlane){
                    if(land.peek() != null){
                        airStrip.append(land.remove() + " has successfully landed at the airport.\n");
                    }
                    else if(takeOff.peek() != null){
                        airStrip.append(takeOff.remove() + " has successfully taken off from the airport.\n");
                    }
                    else{
                        airStrip.append("There are no planes in queue to land or take off!\n");
                    }
                }
            }
            takeOffQ.setText("");
            landQ.setText("");
            if(takeOff.peek() != null){
                for(String c : takeOff){
                    takeOffQ.append(c + "\n");
                }
            }
            if(land.peek() != null){
                for(String c : land){
                    landQ.append(c + "\n");
                }
            }
        }
    }
}