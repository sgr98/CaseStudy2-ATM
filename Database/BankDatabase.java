package Database;
import java.sql.*;

public class BankDatabase implements databaseInterface{
    
    Connection bankConnection = null;
    Statement bankstatement = null;

    public BankDatabase() {
        try {
            bankConnection = DriverManager.getConnection("jdbc:sqlite:BankCustomers.db");
            bankstatement = bankConnection.createStatement();
        }
        
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void establishDB() { // Reference : 

        try {
            bankstatement.setQueryTimeout(30);  // set timeout to 30 sec.

            // DATABASE FORMED *********
            // bankstatement.executeUpdate("drop table if exists BankTable");
            // bankstatement.executeUpdate("create table BankTable (id integer, name varchar(255), nationalid varchar(255), bankid varchar(255), accnumber varchar(255), pin integer, balance integer)");
            // bankstatement.executeUpdate("insert into BankTable values(1, 'Sagar Singh', 'IN001', 'SA001', 'ANS001', 9080, 5000)");
            // bankstatement.executeUpdate("insert into BankTable values(2, 'Ramesh Singh', 'IN002', 'SA002', 'ANS002', 1010, 20000)");
            // bankstatement.executeUpdate("insert into BankTable values(3, 'Anuja Singh', 'IN003', 'SA003', 'ANS110', 9587, 2100)");
            // bankstatement.executeUpdate("insert into BankTable values(4, 'Janed Singh', 'IN004', 'SA004', 'ANS115', 3582, 3000)");
            // bankstatement.executeUpdate("insert into BankTable values(5, 'Vinod Singh', 'IN005', 'SA005', 'ANS220',1302, 2000)");
            // bankstatement.executeUpdate("insert into BankTable values(6, 'Rohan Singh', 'IN006', 'SA006', 'ANS200', 1125, 1500)");
            // bankstatement.executeUpdate("insert into BankTable values(7, 'Hemant Singh', 'IN007', 'SA007', 'ANS119', 7998, 7000)");
            // bankstatement.executeUpdate("insert into BankTable values(8, 'Sachin Singh', 'IN008', 'SA008', 'ANS120', 8251, 11000)");
            
            ResultSet rs = bankstatement.executeQuery("select * from BankTable");
            while(rs.next()) {
                // read the result set
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println();
            }
        }

        catch(SQLException e) {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }

        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public int getIndexByName(String name) {
        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from person");
            while(rs1.next()) {
                String nameDB = rs1.getString("name");
                if(nameDB.equals(name)) {
                    return rs1.getInt("id");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public void closeConnection() {

        try {
            if(bankConnection != null)
                bankConnection.close();
        }

        catch(SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }

    }

}
