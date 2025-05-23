package electricity.billing.system;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener {
    
    String atype, meter;
    Project(String atype, String meter){
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Thermal Power Plant.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu file = new JMenu("File");
        file.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospeed", Font.PLAIN, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.addActionListener(this);
        newcustomer.setIcon(new ImageIcon(image1));
        file.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospeed", Font.PLAIN, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.addActionListener(this);
        customerdetails.setIcon(new ImageIcon(image2));
        file.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospeed", Font.PLAIN, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.addActionListener(this);
        depositdetails.setIcon(new ImageIcon(image3));
        file.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospeed", Font.PLAIN, 12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.addActionListener(this);
        calculatebill.setIcon(new ImageIcon(image4));
        file.add(calculatebill);
        //=
        JMenu info = new JMenu("Information");
        info.setForeground(Color.BLUE);
        
        
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospeed", Font.PLAIN, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.addActionListener(this);
        updateinfo.setIcon(new ImageIcon(image5));
        info.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospeed", Font.PLAIN, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6= icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.addActionListener(this);
        viewinfo.setIcon(new ImageIcon(image6));
        info.add(viewinfo);
        //==
        JMenu user= new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        JMenuItem paybill = new JMenuItem("Pay Bills");
        paybill.setFont(new Font("monospeed", Font.PLAIN, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7= icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.addActionListener(this);
        paybill.setIcon(new ImageIcon(image7));
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospeed", Font.PLAIN, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image8= icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.addActionListener(this);
        billdetails.setIcon(new ImageIcon(image8));
        user.add(billdetails);
        //==
        JMenu report= new JMenu("Report");
        report.setForeground(Color.BLUE);
        
        
        JMenuItem genbill = new JMenuItem("Generate Bills");
        genbill.setFont(new Font("monospeed", Font.PLAIN, 12));
        genbill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        genbill.addActionListener(this);
        genbill.setIcon(new ImageIcon(image9));
        report.add(genbill);
        //==
        
        JMenu utility= new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospeed", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.addActionListener(this);
        notepad.setIcon(new ImageIcon(image10));
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setFont(new Font("monospeed", Font.PLAIN, 12));
        calc.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calc.addActionListener(this);
        calc.setIcon(new ImageIcon(image11));
        utility.add(calc);
        //==
        JMenu exit= new JMenu("Exit");
        exit.setForeground(Color.BLUE);
       
        
        JMenuItem fexit = new JMenuItem("Exit");
        fexit.setFont(new Font("monospeed", Font.PLAIN, 12));
        fexit.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        fexit.addActionListener(this);
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        fexit.setIcon(new ImageIcon(image12));
        exit.add(fexit);
        
        
        setJMenuBar(mb);
        
        ////
        if (atype.equals("Admin")){
        mb.add(file);
        }else{
        mb.add(info);
        mb.add(user);
        mb.add(report);
        }
        ////
        mb.add(utility);
        mb.add(exit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
        
        
    }

    Project(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if (msg.equals("Customer Details")){
            new CustomerDetails();
    }else if (msg.equals("Deposit Details")){
        new DepositDetails();
    }else if (msg.equals("Calculate Bill")){
        new CalculateBill();
    }else if(msg.equals("View Information")){
        new ViewInfo(meter);
    }else if(msg.equals("Update Information")){
        new UpdateInfo(meter);
    }else if (msg.equals("Bill Details")){
        new BillDetails(meter);
    }else if (msg.equals("Notepad")){
        try{
            Runtime.getRuntime().exec("notepad.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }else if (msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("Calc.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }else if (msg.equals("Exit")){
        setVisible(false);
        new Login();
    }else if (msg.equals("Pay Bills")){
        new PayBill(meter);
    }else if(msg.equals("Generate Bills")){
        new GenerateBill(meter);
    }
    }
    public static void main(String[] args){
        new Project("","");
    }
}
