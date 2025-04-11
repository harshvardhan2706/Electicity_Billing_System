
package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class CustomerDetails extends JFrame implements ActionListener {
    
    Choice meternumber, cmonth;
    JTable table;
    JButton search,print;
    
    CustomerDetails(){
        super("Customer Details");
        
        setSize(1200, 650);
        setLocation(200, 150);
             
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        //sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        print = new JButton("Print");
        //print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print, "South");
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        {            try {
                table.print();
            }catch (Exception e){
               e.printStackTrace();
            }
        }
    } 
    
    public static void main(String[] args){
        new CustomerDetails();
    }
}
