
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    
    String meter;
    JButton Back;
    
    Paytm(String meter){
        this.meter = meter;
        
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try{
            j.setPage("https://paytm.com/online-payments");
        }catch (Exception e){
            j.setContentType("text/html");
            j.setText("<html>Could not load<html>");
        }
        
        JScrollPane pane = new JScrollPane(j);
        add(pane);
        
        Back = new JButton("Back");
        Back.setBounds(640, 20, 80, 30);
        Back.addActionListener(this);
        j.add(Back);
        
        setSize(800, 600);
        setLocation(400,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new PayBill(meter);
    }
    public static void main(String[] args){
        new Paytm("");
    }

    


}
