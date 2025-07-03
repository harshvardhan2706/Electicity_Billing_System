package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//import java.sql.*;


public class NewCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfmnumber, tfaddress, tfmail, tfmonumber, tfcity, tfstate;
    JButton next, cancel;
    JLabel ibsmeterno, iblmeter;
            
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.LIGHT_GRAY);
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 25, 200, 20);
        heading.setFont(new Font("Tohoma", Font.PLAIN,24));
        p.add(heading);
        
        JLabel ibsname = new JLabel("Customer Name");
        ibsname.setBounds(80, 80, 100, 20);
        p.add(ibsname);
        tfname = new JTextField();
        tfname.setBounds(200, 80, 200, 20);
        p.add(tfname);
        
        ibsmeterno = new JLabel("Meter Number");
        ibsmeterno.setBounds(80, 120, 100, 20);
        p.add(ibsmeterno);
        iblmeter = new JLabel("");
        iblmeter.setBounds(200, 120, 100, 20);
        p.add(iblmeter);
       //
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        iblmeter.setText(""+Math.abs(number));
        //
        
        JLabel ibsaddress = new JLabel("Address");
        ibsaddress.setBounds(80, 160, 100, 20);
        p.add(ibsaddress);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 160, 200, 20);
        p.add(tfaddress);
        
        JLabel ibscity = new JLabel("City");
        ibscity.setBounds(80, 200, 100, 20);
        p.add(ibscity);
        tfcity = new JTextField();
        tfcity.setBounds(200, 200, 200, 20);
        p.add(tfcity);
        
        JLabel ibsstate = new JLabel("State");
        ibsstate.setBounds(80, 240, 100, 20);
        p.add(ibsstate);
        tfstate = new JTextField();
        tfstate.setBounds(200, 240, 200, 20);
        p.add(tfstate);
        
        
        JLabel ibsemail = new JLabel("Email");
        ibsemail.setBounds(80, 280, 100, 20);
        p.add(ibsemail);
        tfmail = new JTextField();
        tfmail.setBounds(200, 280, 200, 20);
        p.add(tfmail);
        
        JLabel ibsmonumber = new JLabel("Mobile Number");
        ibsmonumber.setBounds(80, 320, 100, 20);
        p.add(ibsmonumber);
        tfmonumber = new JTextField();
        tfmonumber.setBounds(200, 320, 200, 20);
        p.add(tfmonumber);
        //==
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(110, 380, 100, 20);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(280, 380, 100, 20);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
     }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == next)
        {
            String name = tfname.getText();
            String meter_no = iblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfmail.getText();
            String monumber = tfmonumber.getText();
        
            String query1 = "insert into customer values('"+name+"', '"+meter_no+"','"+address+"','"+city+"','"+state+"','"+email+"','"+monumber+"')";
            String query2 = "insert into login (meter_no, username, name, password, \"user\") values('"+meter_no+"',' ','"+name+"',' ',' ')";
        
            try{
                Conn c = new Conn();
            // String query1 = "insert into customer values('"+name+"', '"+meter+"','"+address+"','"+city+"','"+state+"','"+mail+"','"+monumber+"',)";
              //  String query2 = "insert into login (meter_no, username, name, password, \"user\") values('"+meter+"',' ','"+name+"',' ',' ')";
                
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
                
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                
                setVisible(false);
                
                //New Frame
                new MeterInfo(meter_no);
                
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else 
        {
         setVisible(false);   
        }
    }public static void main(String[] args)
    {
         new NewCustomer();
    }
       


}

