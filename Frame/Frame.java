import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Frame extends JFrame
{
   private JFrame frame;
   private JLabel nameLabel, majorLabel, degreeLabel;
   private final int FRAME_HEIGHT = 400;
   private final int FRAME_WIDTH = 600; 
   private JButton createStu, createGrad, save;
   private JTextField name, major, degree;
   private JTextArea display;
   private JScrollPane displayScroll;
   private Listener listener;
   ArrayList<Stu> stulist;
   public Frame(){
   listener = new Listener();   
   stulist = new ArrayList<Stu>();
   frame = new JFrame();
   frame.setLayout(new GridLayout(1,2));
   frame.setSize(600,400);
   this.createComponents();
   frame.setVisible(true);
   frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   private void createComponents()
   {
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      save = new JButton("Save");
      display = new JTextArea(15,20);
      displayScroll = new JScrollPane(display);
      createStu = new JButton("Create Student");
      createStu.addActionListener(listener);
      createGrad = new JButton("Create Grad");
      panel1.setSize(300,400);
      nameLabel = new JLabel("Name");
      majorLabel = new JLabel("Major");
      degreeLabel = new JLabel("Degree");
      name = new JTextField();
      major = new JTextField();
      degree = new JTextField();    
      panel1.setLayout(new GridLayout(4,2));
      panel1.add(nameLabel);
      panel1.add(name);
      panel1.add(majorLabel);
      panel1.add(major);
      panel1.add(degreeLabel);
      panel1.add(degree);
      frame.add(panel1);
      panel1.add(createStu);
      panel1.add(createGrad);
      panel2.add(displayScroll);
      frame.add(panel2);
      panel2.add(save);
      
   }
   
   class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getActionCommand().equals("Create Student"))
         {
            Stu tempstu = new Stu(name.getText(),major.getText());
            stulist.add(tempstu);
            display.append(tempstu.toString()+"\n");
            displayScroll.updateUI();
            
         }
         if(e.getActionCommand().equals("Save"))
         {
            Stu2Save.save(display.getText());
         }
      }
   
   }
}