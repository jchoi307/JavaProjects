/**
 *
 * @author Matt
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class FrameMgr extends JFrame {    
    
    public static String School = "GPC";
    
    final private JMenuBar menu;
    final private JPanel panelLeft;
    final private JPanel panelRight;
    final private JPanel buttonPanel;
    final private JLabel stuLabel;
    final private JLabel majLabel;
    final private JLabel degLabel;
    final private JTextField stuTF;
    final private JTextField majTF;
    final private JTextArea viewerTA;
    final private JButton createBttn;
    final private JButton saveBttn;
    final private JRadioButton degreeYes;
    final private JRadioButton degreeNo;
    final private JScrollPane viewerSP;
    private ButtonGroup degree;
    private String degreeVerification = "";
    
    public FrameMgr(){
        setLayout(new GridLayout(1, 2));
        
        menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu file = new JMenu("File");
        menu.add(file);
        JMenuItem save = new JMenuItem("Save File");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(save);
        file.add(exit);
        
        panelLeft = new JPanel(new GridLayout(4, 2));
        panelRight = new JPanel(new FlowLayout(FlowLayout.CENTER));
        stuLabel = new JLabel("Student");
        majLabel = new JLabel("Major");
        degLabel = new JLabel("Degree");
        stuTF = new JTextField(12);
        majTF = new JTextField(12);
        viewerTA = new JTextArea(20, 20);
        createBttn = new JButton("Create");
        saveBttn = new JButton("Save");
        viewerSP = new JScrollPane(viewerTA);
        buttonPanel = new JPanel(new GridLayout(3, 1));
        degreeYes = new JRadioButton("Yes");
        degreeYes.setActionCommand("Graduate Student");
        degreeNo = new JRadioButton("No");
        degreeNo.setActionCommand("Undergraduate Student");
        degree = new ButtonGroup();
        
        viewerTA.setEditable(false);
        
        degree.add(degreeYes);
        degree.add(degreeNo);
        
        buttonPanel.add(new JLabel());
        buttonPanel.add(degreeYes);
        buttonPanel.add(degreeNo);
        
        viewerSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        viewerSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        panelLeft.add(stuLabel);
        stuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelLeft.add(stuTF);
        panelLeft.add(majLabel);
        majLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelLeft.add(majTF);
        degLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelLeft.add(degLabel);
        panelLeft.add(buttonPanel);
        panelLeft.add(createBttn);
        
        panelRight.add(viewerSP);
        panelRight.add(saveBttn);
        
        //referencing static String variable FrameMgr.School
        panelLeft.setBorder(new TitledBorder(School + " Student Data Entry"));
        panelRight.setBorder(new TitledBorder(School + " Student View"));

        add(panelLeft);
        add(panelRight);
        
        CreateListener create = new CreateListener();
        createBttn.addActionListener(create);
        
        RadioListener degreeV = new RadioListener();
        degreeYes.addActionListener(degreeV);
        degreeNo.addActionListener(degreeV);
        
        SaveListener saveFile = new SaveListener();
        saveBttn.addActionListener(saveFile);
        
        ExitListener exitFile = new ExitListener();
        
        save.addActionListener(saveFile);
        exit.addActionListener(exitFile);
        
    }
    
    public class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //System.out.println(degreeVerification);
            String student = stuTF.getText() + " - " + majTF.getText() + " - " + degreeVerification + "\n";
            viewerTA.append(student);
            
        }
    }
    public class RadioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            degreeVerification = e.getActionCommand();
        }
    }
    public class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String saveOutput = viewerTA.getText();
            SaveTA save = new SaveTA(saveOutput);
            
        }
    }
    public class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
