package electricity.billing.system;

import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try{
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Rakshith123");
        s=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return  c;
    }
}
