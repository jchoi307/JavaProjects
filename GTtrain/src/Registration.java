/**
 * Created by Joon on 2016-04-12.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Registration extends JFrame implements ActionListener {

    private JTextField tfuserName;
    private JTextField tfEmail;
    private JPasswordField pfPwd;
    private JPasswordField cfPwd;
    private JButton btnCreate;
    private GridBagLayout gb;
    private GridBagConstraints gbc;
    private JLabel noValid = new JLabel();
    private JFrame frame = new JFrame();

    /** Registration UI */
    public Registration() {
        this.setTitle("New User Registration");
        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;


        //아이디
        JLabel bId = new JLabel("Username : ");
        tfuserName = new JTextField(15);
        //그리드백에 붙이기
        gbAdd(bId, 0, 0, 1, 1);
        gbAdd(tfuserName, 1, 0, 3, 1);

        JLabel bEmail = new JLabel("Email Address : ");
        tfEmail = new JTextField(20);
        gbAdd(bEmail, 0, 1, 1, 1);
        gbAdd(tfEmail, 1, 1, 3, 1);

        //비밀번호
        JLabel bPwd = new JLabel("Password : ");
        pfPwd = new JPasswordField(20);
        gbAdd(bPwd, 0, 2, 1, 1);
        gbAdd(pfPwd, 1, 2, 3, 1);

        JLabel bcfPwd = new JLabel("Confirm Password : ");
        cfPwd = new JPasswordField(20);
        gbAdd(bcfPwd, 0, 3, 1, 1);
        gbAdd(cfPwd, 1, 3, 3, 1);

        JPanel pButton = new JPanel();
        btnCreate = new JButton("Create");
        pButton.add(btnCreate);
        gbAdd(pButton, 0, 5, 1, 1);

        btnCreate.addActionListener(this);

        setSize(350, 500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    /** gridbag Layout */
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
     * @param args .
     */
    public static void main(String[] args) {
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBConnector dbc = new DBConnector();
        String username = tfuserName.getText();
        if (e.getSource() == btnCreate) {
            if (tfuserName.getText().length() <= 0) {
                noValid.setText("That is not a valid username. Please try again.");
                frame.getContentPane().add(BorderLayout.NORTH, noValid);
            /*
            } else if (dbc.getCustomerInfo(username) != null) {
                noValid.setText("That username is already taken. Please try again.");
                frame.getContentPane().add(BorderLayout.NORTH, noValid);
            */
            } else if (!(Arrays.equals(pfPwd.getPassword(), cfPwd.getPassword()))) {
                noValid.setText("Your passwords do not match!");
                frame.getContentPane().add(BorderLayout.NORTH, noValid);
            } else {
                registerCustomer();
            }
        }
    }

    /** */
    private void registerCustomer() {
        DataTransfer dt = getData();
        DBConnector dbc = new DBConnector();
        boolean ok = dbc.registerCustomer(dt);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Register Successful");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Register Failed by some reason");
        }
    }

    /** */
    public DataTransfer getData() {
        DataTransfer dt = new DataTransfer();
        String username = tfuserName.getText();
        String email = tfEmail.getText();
        String pwd = pfPwd.getText();

        dt.setUsername(username);
        dt.setPwd(pwd);
        dt.setEmail(email);

        return dt;
    }
}