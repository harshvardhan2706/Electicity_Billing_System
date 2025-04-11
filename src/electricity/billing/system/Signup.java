
package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    
    JButton create, back;
    Choice accounttype;
    JTextField meter, username, pswd, name;
    
        Signup()
        {
        //setSize(700, 400);
        //setLocation(400, 150);
        setBounds(400, 150, 700, 400);
        getContentPane().setBackground(Color.darkGray);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 630, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 30, 150, 40);
        heading.setFont(new Font("Tohoma",Font.BOLD, 15));
        panel.add(heading);
        
        accounttype = new Choice();
        accounttype.add("Admin");
        accounttype.add("Customer");
        accounttype.setBounds(250, 40, 150, 20);
        panel.add(accounttype);
        
        accounttype.addFocusListener(null);
        
        final JLabel ebsmeter = new JLabel("Meter Number");
        ebsmeter.setBounds(45, 80, 150, 40);
        ebsmeter.setFont(new Font("Calibri",Font.ITALIC, 12));
        ebsmeter.setVisible(false);
        panel.add(ebsmeter);
        //setVisible(true);
        meter = new JTextField();
        meter.setBounds(160, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);
        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            public void focusLost (FocusEvent fe){
                
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"' ");
            while(rs.next()){
                
            }
        } catch (Exception e){
            e.printStackTrace();
        }
            }
            

        });
        
        JLabel ebsuname = new JLabel("Username");
        ebsuname.setBounds(45, 110, 150, 40);
        ebsuname.setFont(new Font("Calibri",Font.ITALIC, 12));
        panel.add(ebsuname);
        setVisible(true);
        username = new JTextField();
        username.setBounds(160, 120, 150, 20);
        panel.add(username);
    
        JLabel ebsname = new JLabel("Name");
        ebsname.setBounds(45, 140, 150, 40);
        ebsname.setFont(new Font("Calibri",Font.ITALIC, 12));
        panel.add(ebsname);
        setVisible(true);
        name = new JTextField();
        name.setBounds(160, 150, 150, 20);
        panel.add(name);
        
                meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            public void focusLost (FocusEvent fe){
                
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"' ");
            while(rs.next()){
                name.setText(rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
            }
            

        });
        JLabel ebspswd = new JLabel("Password");
        ebspswd.setBounds(45, 170, 150, 40);
        ebspswd.setFont(new Font("Calibri",Font.ITALIC, 12));
        panel.add(ebspswd);
        setVisible(true);
        pswd = new JTextField();
        pswd.setBounds(160, 180, 150, 20);
        panel.add(pswd);
        //////////////
        
        accounttype.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user = accounttype.getSelectedItem();
                if (user.equals("Customer")){
                    ebsmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }
            else{
                    ebsmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(false);
                }
        }
        });
         
        /////////////
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(45, 225, 120, 30);
        create.addActionListener(this);
        panel.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(180, 225, 120, 30);
        back.addActionListener(this);
        panel.add(back);
        
        //////////////
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(395, 30, 250, 250);
        panel.add(image);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
           String atype = accounttype.getSelectedItem();
           String susername = username.getText();
           String sname =  name.getText();
           String spswd = pswd.getText();
           String smeter = meter.getText();
           
           
           try{
               Conn c = new Conn();
               
               String query = null;
               if(atype.equals("Admin")){
               query = "insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spswd+"','"+atype+"')";
               } else {
                   query = "update login set username = '"+susername+"',password = '"+spswd+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
               }
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account Created Successfully");
               
               setVisible(false);
               new Login();
               
               
                       }catch (Exception e){
               e.printStackTrace();
           }
           
        }else if(ae.getSource()==back){
            setVisible(false);
            
            new Login();
        }
    }
    
    public static void main(String []args)
    {
        new Signup();
    }
    

}
