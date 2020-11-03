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
            // bankstatement.executeUpdate("insert into BankTable values(1, 'Sagar Singh', 'IN001', 'SA001', '01001', 9080, 5000)");
            // bankstatement.executeUpdate("insert into BankTable values(2, 'Ramesh Singh', 'IN002', 'SA002', '01002', 1010, 20000)");
            // bankstatement.executeUpdate("insert into BankTable values(3, 'Anuja Singh', 'IN003', 'SA003', '01110', 9587, 2100)");
            // bankstatement.executeUpdate("insert into BankTable values(4, 'Janed Singh', 'IN004', 'SA004', '01115', 3582, 3000)");
            // bankstatement.executeUpdate("insert into BankTable values(5, 'Vinod Singh', 'IN005', 'SA005', '01220',1302, 2000)");
            // bankstatement.executeUpdate("insert into BankTable values(6, 'Rohan Singh', 'IN006', 'SA006', '01200', 1125, 1500)");
            // bankstatement.executeUpdate("insert into BankTable values(7, 'Hemant Singh', 'IN007', 'SA007', '01119', 7998, 7000)");
            // bankstatement.executeUpdate("insert into BankTable values(8, 'Sachin Singh', 'IN008', 'SA008', '01120', 8251, 11000)");
            
            // ResultSet rs = bankstatement.executeQuery("select * from BankTable");
            // while(rs.next()) {
            //     // read the result set
            //     System.out.println("id = " + rs.getInt("id"));
            //     System.out.println("name = " + rs.getString("name"));
            //     System.out.println();
            // }
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

    public int getIndexByBankID(String bankID) {
        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from BankTable");
            while(rs1.next()) {
                String bankIDDB = rs1.getString("bankid");
                if(bankIDDB.equals(bankID)) {
                    return rs1.getInt("id");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public String getAccountNumber(int index) {
        
        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from BankTable");
            while(rs1.next()) {
                int id = rs1.getInt("id");
                if(index == id) {
                    //System.out.println(rs1.getString("accnumber"));
                    return rs1.getString("accnumber");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return "";

    }
    
    public int getPIN(int index) {

        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from BankTable");
            while(rs1.next()) {
                int id = rs1.getInt("id");
                if(index == id) {
                    //System.out.println(rs1.getInt("pin"));
                    return rs1.getInt("pin");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;

    }

    public int getBalance(int index) {

        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from BankTable");
            while(rs1.next()) {
                int id = rs1.getInt("id");
                if(index == id) {
                    //System.out.println(rs1.getInt("pin"));
                    return rs1.getInt("balance");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;

    }

    public String getBankID(int index) { // Get bank ID from an index form the bank's index
        
        try {
            ResultSet rs1 = bankstatement.executeQuery("select * from BankTable");
            while(rs1.next()) {
                int id = rs1.getInt("id");
                if(index == id) {
                    //System.out.println(rs1.getString("accnumber"));
                    return rs1.getString("bankid");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return "";

    }

    public void updateBalance(int index, int newbal) {

        if(ifExists(index)) {
            String updbal = "update BankTable SET balance = ? WHERE id = ?";
            try {
                PreparedStatement preStatement = bankConnection.prepareStatement(updbal);
                preStatement.setInt(1, newbal);
                preStatement.setInt(2, index);
                preStatement.executeUpdate();
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public boolean ifExists(int index) { // To check whether the bankId with this index exists in bank's database or not

        if(getBankID(index).equals("")) {
            return false;
        }
        else {
            return true;
        }
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
