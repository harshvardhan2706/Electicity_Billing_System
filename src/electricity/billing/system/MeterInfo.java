
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
//import java.sql.*;


public class MeterInfo extends JFrame implements ActionListener {
    
    JTextField tfname, tfmnumber, tfaddress, tfmail, tfmonumber, tfcity, tfstate;
    JButton next, cancel;
    JLabel ibsmeterno, iblmeter;
    Choice meterlocation,metertype,phasecode,billtype;
     String meternumber;
     
    MeterInfo(String meternumber){
        this.meternumber = meternumber;
        
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.LIGHT_GRAY);
        add(p);
        
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 25, 200, 20);
        heading.setFont(new Font("Tohoma", Font.PLAIN,24));
        p.add(heading);
        
        JLabel ibsname = new JLabel("Meter Number");
        ibsname.setBounds(80, 80, 100, 20);
        p.add(ibsname);
        
        JLabel ibsmeterno = new JLabel(meternumber);
        ibsmeterno.setBounds(200, 80, 100, 20);
        p.add(ibsmeterno);
        
        ibsmeterno = new JLabel("Meter Location");
        ibsmeterno.setBounds(80, 120, 100, 20);
        p.add(ibsmeterno);
        
        meterlocation = new Choice();
        meterlocation.add("Inside");
        meterlocation.add("Outside");
        meterlocation.setBounds(200, 120, 200, 20);
        p.add(meterlocation);       
       


        
        JLabel ibsaddress = new JLabel("Meter Type");
        ibsaddress.setBounds(80, 160, 100, 20);
        p.add(ibsaddress);
        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(200, 160, 200, 20);
        p.add(metertype); 
        
        JLabel ibscity = new JLabel("Phase Code");
        ibscity.setBounds(80, 200, 100, 20);
        p.add(ibscity);
        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(200, 200, 200, 20);
        p.add(phasecode);
        
        JLabel ibsstate = new JLabel("Bill Type");
        ibsstate.setBounds(80, 240, 100, 20);
        p.add(ibsstate);
        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Special");
        billtype.setBounds(200, 240, 200, 20);
        p.add(billtype);       
       
        JLabel ibsemail = new JLabel("Days");
        ibsemail.setBounds(80, 280, 100, 20);
        p.add(ibsemail);

        JLabel ibsemails = new JLabel("30 Days");
        ibsemails.setBounds(200, 280, 100, 20);
        p.add(ibsemails);

        JLabel ibsmonumbers = new JLabel("Note");
        ibsmonumbers.setBounds(80, 320, 100, 20);
        p.add(ibsmonumbers);
        JLabel ibsmonumber = new JLabel("By Default Bill is Calculated");
        ibsmonumber.setBounds(200, 320, 500, 20);
        p.add(ibsmonumber);

        //==
        
        next = new JButton("Submit");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(220, 380, 100, 20);
        next.addActionListener(this);
        p.add(next);
        
        
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
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code= phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days ="30";
                   
            String query = "insert into meter_info values('"+meter+"', '"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
            
           
        
            try{
                Conn c = new Conn();
            
                
               c.s.executeUpdate(query);
                             
                
                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                
                setVisible(false);
                
                //New Frame
                
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
         new MeterInfo("");
    }
       


}

