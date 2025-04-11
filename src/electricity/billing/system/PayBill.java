package electricity.billing.system;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class PayBill extends JFrame implements ActionListener  {
 
    String meter;
    Choice cmonth;
    JButton pay,back;
    
    PayBill(final String meter){
        this.meter= meter;
        setLayout(null);
        setBounds(300,150,900,600);
        
        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("tohoma",Font.BOLD,24));
        heading.setBounds(150,5,400,30);
        add(heading);
        
        JLabel iblmnumber = new JLabel("Meter Number");
        iblmnumber.setBounds(135,80,200,20);
        add(iblmnumber);
                
        JLabel mnumber = new JLabel("");
        mnumber.setBounds(300,80,200,20);
        add(mnumber);
        
        JLabel iblname = new JLabel("Name");
        iblname.setBounds(135,140,200,20);
        add(iblname);
                
        JLabel name = new JLabel("");
        name.setBounds(300,140,200,20);
        add(name);
        
        JLabel iblmonth = new JLabel("Month");
        iblmonth.setBounds(135,200,150,20);
        add(iblmonth);
        cmonth = new Choice();
        cmonth.setBounds(300, 200, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
 
        JLabel iblunits = new JLabel("Units");
        iblunits.setBounds(135,260,200,20);
        add(iblunits);
                
        final JLabel units = new JLabel("");
        units.setBounds(300,260,200,20);
        add(units);
        
        
        JLabel ibltotalbill = new JLabel("Total Bill");
        ibltotalbill.setBounds(135,320,200,20);
        add(ibltotalbill);
                
        final JLabel totalbill = new JLabel("");
        totalbill.setBounds(300,320,200,20);
        add(totalbill);
        
        JLabel iblstatus = new JLabel("Status");
        iblstatus.setBounds(135,380,200,20);
        add(iblstatus);
                
        final JLabel status = new JLabel("");
        status.setBounds(300,380,200,20);
        status.setForeground(Color.RED);
        add(status);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meter+"' ");
            while(rs.next()){
                mnumber.setText(meter);
                name.setText(rs.getString("name"));                
            }
                rs = c.s.executeQuery("select * from bill where meter_no ='"+meter+"' AND month = 'January' ");
                while(rs.next()){
                units.setText(rs.getString("units"));
                totalbill.setText(rs.getString("totalbill"));
                status.setText(rs.getString("status"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        
                cmonth.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ae){
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill where meter_no ='"+meter+"' AND month='"+cmonth.getSelectedItem()+"' ");
            while(rs.next()){
            units.setText(rs.getString("units"));
            totalbill.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));
        }
            
        }catch (Exception e){
            e.printStackTrace();
        }

     
                }   });
     pay = new JButton("Pay");
     pay.setBackground(Color.BLACK);
     pay.setForeground(Color.WHITE);
     pay.setBounds(100,460,100,25);
     pay.addActionListener(this);
     add(pay);
     
     back = new JButton("Back");
     back.setBackground(Color.BLACK);
     back.setForeground(Color.WHITE);
     back.setBounds(300,460,100,25);
     back.addActionListener(this);
     add(back);

        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);
     
     
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== pay){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = 'meter' AND month = '"+cmonth.getSelectedItem()+"'");
            }catch (Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        }else{
            setVisible(false);
        }
    }
            
    public static void main(String[] args){
        new PayBill("");
    }
}
