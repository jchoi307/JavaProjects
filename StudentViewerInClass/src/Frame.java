import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Frame extends JFrame {
   private JLabel nameLabel, majorLabel, degreeLabel, schoolLabel;
   private final int FRAME_HEIGHT = 440;
   private final int FRAME_WIDTH = 640; 
   private JButton createStu, createGrad, save;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenuItem itemSave, itemExit;
   private JTextField name, major, degree, schoolTF;
   private JTextArea display;
   private JScrollPane displayScroll;
   private JRadioButton male, female;
   private ButtonGroup genderGroup;
   private JComboBox tuition;
   private JCheckBox onCampus, financialAid, hopeSch;
   private final Listener listener;
   ArrayList<Stu> stulist;
   
   public Frame() {
       listener = new Listener();   
       stulist = new ArrayList<>();
       this.setLayout(new GridLayout(1,2));
       this.addMenu();
       this.createComponents();
       this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
   }
   
   private void addMenu() {
      menuBar = new JMenuBar();
      fileMenu = new JMenu("File");
      menuBar.add(fileMenu);
      itemSave = new JMenuItem("Save");
      itemExit = new JMenuItem("Exit");
      itemSave.addActionListener(listener);
      itemExit.addActionListener(listener);
      fileMenu.add(itemSave);
      fileMenu.add(itemExit);
      this.setJMenuBar(menuBar);
      
   }
   private void createComponents() {       
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel genderPanel = new JPanel(new GridLayout(1,2));

      createStu = new JButton("Create Student");
      createStu.addActionListener(listener);
      createGrad = new JButton("Create Grad");
      createGrad.addActionListener(listener);
      
      Border border = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black),
            BorderFactory.createEmptyBorder(5,10,5,10));
      Border inputBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Student Input"),
            BorderFactory.createEmptyBorder(5,10,5,10));
      Border displayBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Student Display"),
            BorderFactory.createEmptyBorder(5,10,5,10));
      
      nameLabel = new JLabel("Name: ", SwingConstants.CENTER);                                                      
      majorLabel = new JLabel("Major: ", SwingConstants.CENTER);
      degreeLabel = new JLabel("Degree: ", SwingConstants.CENTER);
      schoolLabel = new JLabel("School: ", SwingConstants.CENTER);
      nameLabel.setBorder(border);   
      majorLabel.setBorder(border);
      degreeLabel.setBorder(border);
      schoolLabel.setBorder(border);
      
      genderGroup = new ButtonGroup();
      male = new JRadioButton("Male");
      female = new JRadioButton("Female");
      male.setSelected(true);
      genderGroup.add(male);
      genderGroup.add(female);
      genderPanel.add(male);
      genderPanel.add(female);
      
      tuition = new JComboBox();
      tuition.addItem("In-State Tuition");
      tuition.addItem("Out-of-State Tuition");
      tuition.setEditable(false);
      
      onCampus = new JCheckBox("On-Campus Living");
      financialAid = new JCheckBox("Financial Aid");
      hopeSch = new JCheckBox("Hope Scholarship");
      
      name = new JTextField();
      major = new JTextField();
      degree = new JTextField();
      schoolTF = new JTextField(Stu.school);
      schoolTF.setEditable(false);
      panel1.setBorder(inputBorder);
      panel1.setLayout(new GridLayout(8,2,15,25));
      panel1.add(nameLabel);
      panel1.add(name);
      panel1.add(majorLabel);
      panel1.add(major);
      panel1.add(degreeLabel);
      panel1.add(degree);
      panel1.add(schoolLabel);
      panel1.add(schoolTF);
      panel1.add(genderPanel);
      panel1.add(tuition);
      panel1.add(onCampus);
      panel1.add(financialAid);
      panel1.add(hopeSch);
      panel1.add(new JLabel());
      panel1.add(createStu);
      panel1.add(createGrad);

      save = new JButton("Save");
      save.addActionListener(listener);
      display = new JTextArea(10,30);
      display.setLineWrap(true);
      display.setWrapStyleWord(true);
      displayScroll = new JScrollPane(display);
      panel2.setBorder(displayBorder);
      panel2.setLayout(new BorderLayout(0,10));
      panel2.add(save, BorderLayout.SOUTH);
      panel2.add(displayScroll, BorderLayout.CENTER); 
     
      this.add(panel1);
      this.add(panel2);
   }
   
   class Listener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
          Stu tempstu = null;
          String genderSelection = "";
          String[] attributes = new String[3];
          
          if (male.isSelected()) {
              genderSelection = male.getActionCommand();
          }
          else if (female.isSelected()) {
              genderSelection = female.getActionCommand();
          }
          else {}
          
          if (onCampus.isSelected()) {
              attributes[0] = onCampus.getActionCommand();
          }
          else {
              attributes[0] = "";
          }
          if (financialAid.isSelected()) {
              attributes[1] = financialAid.getActionCommand();
          }
          else {
              attributes[1] = "";
          }
          if (hopeSch.isSelected()) {
              attributes[2] = hopeSch.getActionCommand();
          }
          else {
              attributes[2] = "";
          }
          
          if (e.getSource() instanceof JButton) {
             JButton source = (JButton)e.getSource();
             if (source == createStu) {
                 tempstu = new Stu(name.getText(), major.getText(), genderSelection, (String)tuition.getSelectedItem(), attributes);
             }
             else if (source == createGrad) {
                 tempstu = new Grad(name.getText(), major.getText(), 
                                   degree.getText(), genderSelection, (String)tuition.getSelectedItem(), attributes);
             }
             else if (source == save) {
                 Stu2Save.save(stulist);
             }
             if (tempstu != null) {
                 stulist.add(tempstu);
                 display.append(tempstu.toString()+"\n");
             }

          }
            
          else if (e.getSource() instanceof JMenuItem) {
             JMenuItem item = (JMenuItem)e.getSource();
             if (item == itemSave) {
                 Stu2Save.save(stulist);
             }
             else if (item == itemExit) {
                System.exit(0);
             }
          }
      
      }
   }
}
   
