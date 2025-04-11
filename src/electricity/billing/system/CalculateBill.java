
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class CalculateBill extends JFrame implements ActionListener {
    
    JTextField tfname, tfmnumber, tfaddress, tfmail, tfmonumber, tfunits, tfstate;
    JButton next, cancel;
    JLabel lblname,lbladdress;
    Choice meternumber,cmonth;
            
    CalculateBill(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.MAGENTA);
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(130, 22, 400, 20);
        heading.setFont(new Font("Tohoma", Font.PLAIN,24));
        p.add(heading);
        
        JLabel ibsmnumber = new JLabel("Meter Number");
        ibsmnumber.setBounds(80, 80, 100, 20);
        p.add(ibsmnumber);
        
        meternumber = new Choice();

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                    meternumber.add(rs.getString("meter_no"));

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

        meternumber.setBounds(200, 80, 200, 20);
        p.add(meternumber);
        
        
        
        
        JLabel ibsname = new JLabel("Name");
        ibsname.setBounds(80, 120, 100, 20);
        p.add(ibsname);
        
        lblname = new JLabel("");
        lblname.setBounds(200, 120, 200, 20);
        p.add(lblname);
    

        JLabel ibsaddress = new JLabel("Address");
        ibsaddress.setBounds(80, 160, 100, 20);
        p.add(ibsaddress);
        
        lbladdress = new JLabel("");
        lbladdress.setBounds(200, 160, 200, 20);
        p.add(lbladdress);
        
        
                     
            meternumber.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    try {
                     Conn c = new Conn();
                     ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"' ");
                     while(rs.next()){
                         lblname.setText(rs.getString("name"));
                         lbladdress.setText(rs.getString("address"));
                    }
                 }catch (Exception e){
                     e.printStackTrace();
                 }

                }
            });

        
        JLabel ibscity = new JLabel("Unit Consumed");
        ibscity.setBounds(80, 200, 100, 20);
        p.add(ibscity);
        tfunits = new JTextField();
        tfunits.setBounds(200, 200, 200, 20);
        p.add(tfunits);
        
        JLabel ibsstate = new JLabel("Month");
        ibsstate.setBounds(80, 240, 100, 20);
        p.add(ibsstate);
        cmonth = new Choice();
        cmonth.setBounds(200, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("Octuber");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
        
        
        next = new JButton("Submit");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
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
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();
            
            int totalbill = 0;
            int unit_consumed = Integer.parseInt(units);
            
            
            String query = "select * from tax";
            
        
            try{
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                    
                    
                }
               

                
            } catch(Exception e)
            {
                e.printStackTrace();
            }
            String query2 = "insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Succuessfullt");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       else 
        {
         setVisible(false);   
        }
    }public static void main(String[] args)
    {
         new CalculateBill();
    }
       


}

