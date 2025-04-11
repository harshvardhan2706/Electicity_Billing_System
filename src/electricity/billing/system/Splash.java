/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;
//import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        super("Electricity Billing System");
        
        //*******************
        //JLabel welcome = new JLabel("Welcome to ");
        //getContentPane().setColor(Color.WHITE);    
        //welcome.setBounds(190, 150, 140, 20);
            //add(welcome);
        //*******************
                
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        //Image i2=i1.get Image().getScaledInstance(730,550, Image.SCALE_DEFAULT);
        //ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        add(image);

        setVisible(true);
        int x = 2;
        for (int i = 2; i < 500; i += 2, x += 1) {
            setSize(i, i);
            //setLocation(380,180);
            setLocation(476, 150);
            //setLocation(380 - (i + x/2),180- (i / 2));
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run() {
        try {
            Thread.sleep(2000);
            setVisible(false);

            //Login frame 
            new Login();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
