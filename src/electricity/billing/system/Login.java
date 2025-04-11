package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username, password;
    JButton login, signup, cancel;
    Choice logginin;
    Login() {
            super("Login Page");
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            JLabel iblusername = new JLabel("Username");
            iblusername.setBounds(350, 40, 140, 20);
            add(iblusername);
            username= new JTextField();
            username.setBounds(420, 40, 150, 20);
            add(username);
            
            JLabel iblpassword = new JLabel("Password");
            iblpassword.setBounds(350, 80, 140, 20);
            add(iblpassword);
            password= new JTextField();
            password.setBounds(420, 80, 150, 20);
            add(password);
            
            
            JLabel ibllogin = new JLabel("Login as");
            ibllogin.setBounds(350, 121, 50, 20);
            add(ibllogin);


            logginin=new Choice();
            logginin.add("Admin");
            logginin.add("Customer");
            logginin.setBounds(420, 120, 150, 20);
            add(logginin);
            
            /////////////////////////////////////////////////////////////////
            
            ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
            Image i2 = i1.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
            login = new JButton("Login", new ImageIcon(i2));
            login.setBounds(350,160,100,20);
            login.addActionListener(this);
            add(login);
            
            ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
            Image i4 = i3.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
            cancel = new JButton("cancel", new ImageIcon(i4));
            cancel.setBounds(465,160,100,20);
            cancel.addActionListener(this);
            add(cancel);
            
            ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
            Image i6 = i5.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
            signup = new JButton("signup", new ImageIcon(i6));
            signup.setBounds(380,200,155,20);
            signup.addActionListener(this);
            add(signup);
            ///////////////////////////////////////////////////////////
            
            ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
            Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            ImageIcon i9=new ImageIcon(i8);
            JLabel image= new JLabel(i9);
            image.setBounds(0, 0, 250, 250);
            add(image);
            
            setSize(640,300);
            setLocation(400,200);
            setVisible(true);
        }
    
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == login) {
                String susername = username.getText();
                String spassword = password.getText();
                String user = logginin.getSelectedItem();
                
                try{
                    Conn c = new Conn();
                    String query =("select * from login where username='"+susername+"'and password= '"+spassword+"'and user= '"+user+"' ");
                    
                    ResultSet rs= c.s.executeQuery(query);
                    
                    if (rs.next()){
                        String meter = rs.getString("meter_no");
                        setVisible(false);
                        new Project(user, meter);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                        username.setText("");
                        password.setText("");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == cancel){
                setVisible(false);
            }else if (ae.getSource() == signup){
                setVisible(false);
                new Signup();
            }
        }
    public static void main(String[] args) {
        new Login();
    }
}
