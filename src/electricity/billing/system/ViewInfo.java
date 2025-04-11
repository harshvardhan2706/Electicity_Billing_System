package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;

public class ViewInfo extends JFrame implements ActionListener{
    
    JButton cancel;
    ViewInfo(String meter){
        setBounds(350, 150, 850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(heading);
        
        JLabel iblname = new JLabel("Name");
        iblname.setBounds(70, 80, 100, 20);
        add(iblname);
        JLabel name = new JLabel("");
        name.setBounds(250, 80, 100, 20);
        add(name);
        
        JLabel iblmeternumber = new JLabel("Meter Number");
        iblmeternumber.setBounds(70, 140, 100, 20);
        add(iblmeternumber);
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(250, 140, 100, 20);
        add(meternumber);
        
        JLabel ibladdress = new JLabel("Address");
        ibladdress.setBounds(70, 200, 100, 20);
        add(ibladdress);
        JLabel address = new JLabel("");
        address.setBounds(250, 200, 100, 20);
        add(address);
        
        JLabel iblcity = new JLabel("City");
        iblcity.setBounds(70, 260, 100, 20);
        add(iblcity);
        JLabel city = new JLabel("");
        city.setBounds(250, 260, 100, 20);
        add(city);
        
        JLabel iblstate = new JLabel("State");
        iblstate.setBounds(500, 80, 100, 20);
        add(iblstate);
        JLabel state = new JLabel("");
        state.setBounds(650, 80, 100, 20);
        add(state);
                
        JLabel iblmail = new JLabel("Email");
        iblmail.setBounds(500, 140, 100, 20);
        add(iblmail);
        JLabel mail = new JLabel("");
        mail.setBounds(650, 140, 100, 20);
        add(mail);
        
        JLabel iblmonumber = new JLabel("Mobile Number");
        iblmonumber.setBounds(500, 200, 100, 20);
        add(iblmonumber);
        JLabel monumber = new JLabel("");
        monumber.setBounds(650, 200, 100, 20);
        add(monumber);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"' ");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                mail.setText(rs.getString("email"));
                monumber.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 340, 100, 25);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 350, 600, 300);
        add(image);
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new ViewInfo(" ");
    }

    //private ViewInfo() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}
