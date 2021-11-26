

package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener  
{
    HotelManagementSystem()
    {
        setBounds(300,200,1440,600);       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hms/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1440,600);
        add(l1);  
        
        
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(30,470,1000,80);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,70));
        l1.add(l2);
        setLayout(null);
        setVisible(true);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(1200,430,150,50);
        b1.addActionListener(this);
        l1.add(b1);
        
        
        while(true)
        {
            l2.setVisible(false);
            try
            {
                Thread.sleep(500);                
            }
            catch(Exception e)
            {
                l2.setVisible(true);                
            }
            l2.setVisible(true);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                System.out.println(e);
                                
            }            
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }
   
    public static void main(String[] args) 
    {
        new HotelManagementSystem();      
    }    
}
