package hms;
import java.sql.*;  

public class conn 
{
    Connection c;
    Statement s;
    public conn(){  
        try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3307/hms","root",""); 
            s =c.createStatement();       
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }  
    }  
    
    
}