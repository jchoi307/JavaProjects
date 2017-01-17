/**
 * Created by Joon on 2016-04-12.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JButton btnLogin;
    private JButton btnRegister;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private DataTransfer dt = new DataTransfer();
    private GridBagLayout gb;
    private GridBagConstraints gbc;
    //static String username;

    /**
     *
     */
    public Login() {
        this.setTitle("Login");
        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        /*
        Frame frame = new Frame("Login");
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(215, 252, 231));

        //p1(north)
        Panel panel1 = new Panel();
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(new Color(150, 200, 200));
        frame.add(panel1, "North");
        //p1 - label
        Label title1 = new Label("Login");
        panel1.add(title1);

        //p2(center)
        Panel panel2 = new Panel();
        panel2.setLayout(new FlowLayout(5));
        frame.add(panel2, "Center");

        //p2- label - 1,2,3,4,5
        Label sub1 = new Label("  Username  ");
        Label sub2 = new Label("  Password  ");
        //p2 - textField - 1,2,3,4,5
        tfUsername = new JTextField(30);
        pfPassword = new JPasswordField(30);
        panel2.add(sub1); panel2.add(tfUsername);
        panel2.add(sub2); panel2.add(pfPassword);

        //p3(south)
        JPanel panel3 = new JPanel();

        //Panel panel3 = new Panel();
        panel3.setLayout(new FlowLayout());
        frame.add(panel3, "South");
        //p3 - button
        btnLogin = new JButton("Login");
        //btnLogin.addActionListener(this);
        btnRegister = new JButton("Register");
        //btnRegister.addActionListener(this);
        panel3.add(btnLogin);
        panel3.add(btnRegister);

        frame.setSize(400, 300);   //크기
        frame.setLocation(100, 200);  //위치
        frame.setVisible(true);

        //윈도우 종료 이벤트 처리
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent  e) {
                System.exit(1);
            }
        });
        */
        JLabel bLogin = new JLabel("Login");
        JLabel bUsername = new JLabel("Username : ");
        tfUsername = new JTextField(15);
        gbAdd(bLogin, 0, 0, 1, 1);
        gbAdd(bUsername, 0, 1, 1, 1);
        gbAdd(tfUsername, 1, 1, 1, 1);

        JLabel bPwd = new JLabel("Password : ");
        pfPassword = new JPasswordField(20);
        gbAdd(bPwd, 0, 2, 1, 1);
        gbAdd(pfPassword, 1, 2, 1, 1);

        JPanel pLogin = new JPanel();
        btnLogin = new JButton("Login");
        pLogin.add(btnLogin);
        gbAdd(pLogin, 0, 3, 1, 1);

        JPanel pRegister = new JPanel();
        btnRegister = new JButton("Register");
        pRegister.add(btnRegister);
        gbAdd(pRegister, 1, 3, 1, 1);

        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);

        setSize(350, 500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }
    /**
     *
     * @param args .
     */
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBConnector dbc = new DBConnector();
        if (e.getSource() == btnLogin) {
            String username = tfUsername.getText();
            String pwd = pfPassword.getText();
            if (dbc.getManagerInfo(username, pwd)) {
                new ManagerFunction(username);
                dispose();
            } else if (dbc.getCustomerInfo(username).getPwd().equals(pwd)) {
                new Functionality(username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Input. Please Try Again.");
            }
        }
        if (e.getSource() == btnRegister) {
            new Registration();
        }
    }

    /*
    public DataTransfer getData() {
        DataTransfer dt = new DataTransfer();
        String username = tfUsername.getText();
        String pwd = pfPassword.getText();

        dt.setUsername(username);
        dt.setPwd(pwd);

        return dt;
    }
    */
}
