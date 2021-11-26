package hms;;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class CheckOut extends JFrame implements ActionListener
{
    Choice c1;
    JTextField t1;
    JButton b1, b2, b3;

    CheckOut()
    {
        

        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(50,20,100,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tohama", Font.PLAIN, 20));
        add(l1);

        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        c1 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        c1.setBounds(150, 80, 150, 30);
        add(c1);
        
        
        JLabel l3 = new JLabel("Room No");
        l3.setBounds(30,130,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150, 130, 150, 30);
        add(t1);

        b1 = new JButton("CheckOut");
        b1.setBounds(30, 200, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(170, 200, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hms/icons/tick1.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        b3 = new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(310, 80, 20,20);
        add(b3);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == b1)
        {
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str1 = "update room set available = 'Available' where room_number = '"+room+"'";
            conn c = new conn();
            try
            {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Checkout done");
                new Reception().setVisible(true);
                this.setVisible(false);

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);            
        }
        else if(ae.getSource() == b3)
        {
            conn c = new conn();
            String id = c1.getSelectedItem();
            try
            {
                ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+id+"'");
                while (rs.next())
                {
                    t1.setText(rs.getString("room"));
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
                
            }
            
        }
        
    }
    
    public static void main(String[] args) 
    {
        new CheckOut().setVisible(true);
    }
    
}
