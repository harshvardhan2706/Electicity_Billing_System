package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Shapes
 */
public class UpdateInfo extends JFrame implements ActionListener{
    JTextField tfaddress, tfcity, tfstate, tfmail, tfmonumber;
    JButton cancel, update;
    String meter;
    JLabel name;
    
    UpdateInfo(String meter){
        this.meter = meter;
        setBounds(300, 150, 1050,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110, 0, 400, 30);
        heading.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(heading);
        
        JLabel iblname = new JLabel("Name");
        iblname.setBounds(30, 80, 200, 20);
        add(iblname);
        name = new JLabel("");
        name.setBounds(230, 80, 200, 20);
        add(name);
        
        JLabel iblmeternumber = new JLabel("Meter Number");
        iblmeternumber.setBounds(30, 140, 200, 20);
        add(iblmeternumber);
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(230, 140, 200, 20);
        add(meternumber);
        
        JLabel ibladdress = new JLabel("Address");
        ibladdress.setBounds(30, 200, 100, 20);
        add(ibladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(230, 200, 200, 20);
        add(tfaddress);
        
        JLabel iblcity = new JLabel("City");
        iblcity.setBounds(30, 260, 100, 20);
        add(iblcity);
        tfcity = new JTextField();
        tfcity.setBounds(230, 260, 200, 20);
        add(tfcity);
        
        JLabel iblstate = new JLabel("State");
        iblstate.setBounds(500, 80, 100, 20);
        add(iblstate);
        tfstate = new JTextField();
        tfstate.setBounds(650, 80, 200, 20);
        add(tfstate);
                
        JLabel iblmail = new JLabel("Email");
        iblmail.setBounds(500, 140, 200, 20);
        add(iblmail);
        tfmail = new JTextField();
        tfmail.setBounds(650, 140, 200, 20);
        add(tfmail);
        
        JLabel iblmonumber = new JLabel("Mobile Number");
        iblmonumber.setBounds(500, 200, 100, 20);
        add(iblmonumber);
        tfmonumber = new JTextField();
        tfmonumber.setBounds(650, 200, 200, 20);
        add(tfmonumber);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"' ");
            while(rs.next()){
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfmail.setText(rs.getString("email"));
                tfmonumber.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 25);
        add(update);
        update.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(325, 340, 100, 25);
        add(cancel);
        cancel.addActionListener(this);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 150, 600, 300);
        add(image);
        
        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== update){
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String mail= tfmail.getText();
            String monumber = tfmonumber.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address='"+address+"', city ='"+city+"',state = '"+state+"', email = '"+mail+"',phone = '"+monumber+"' where meter_no = '"+meter+"' ");
                
                JOptionPane.showMessageDialog(null, "User Information Updates Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
        public static void main(String[] args){    
            new UpdateInfo(" ");
        }

   
}

