package Database;
import java.sql.*;

public class AllDatabase implements databaseInterface {
    
    Connection allConnection = null;
    Statement allStatement = null;

    public AllDatabase() {
        try {
            allConnection = DriverManager.getConnection("jdbc:sqlite:AllBankCustomers.db");
            allStatement = allConnection.createStatement();
        }
        
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void establishDB() { // Reference : 

        try {
            // create a database connection

            allStatement.setQueryTimeout(30);  // set timeout to 30 sec.

            // DATABASE FORMED *********
            // allStatement.executeUpdate("drop table if exists AllBankTable");
            // allStatement.executeUpdate("create table AllBankTable (id integer, name varchar(255), nationalid varchar(255), bankid varchar(255), accnumber varchar(255), pin integer, balance integer)");
            // allStatement.executeUpdate("insert into AllBankTable values(1, 'Sagar Singh', 'IN001', 'SA001', '01001', 9080, 5000)");
            // allStatement.executeUpdate("insert into AllBankTable values(2, 'Ramesh Singh', 'IN002', 'SA002', '01002', 1010, 20000)");
            // allStatement.executeUpdate("insert into AllBankTable values(3, 'Anuja Singh', 'IN003', 'SA003', '01110', 9587, 2100)");
            // allStatement.executeUpdate("insert into AllBankTable values(4, 'Janed Singh', 'IN004', 'SA004', '01115', 3582, 3000)");
            // allStatement.executeUpdate("insert into AllBankTable values(5, 'Vinod Singh', 'IN005', 'SA005', '01220',1302, 2000)");
            // allStatement.executeUpdate("insert into AllBankTable values(6, 'Rohan Singh', 'IN006', 'SA006', '01200', 1125, 1500)");
            // allStatement.executeUpdate("insert into AllBankTable values(7, 'Hemant Singh', 'IN007', 'SA007', '01119', 7998, 7000)");
            // allStatement.executeUpdate("insert into AllBankTable values(8, 'Sachin Singh', 'IN008', 'SA008', '01120', 8251, 11000)");
            // allStatement.executeUpdate("insert into AllBankTable values(9, 'Pooja Singh', 'IN009', 'RR009', '02100', 9999, 23000)");
            // allStatement.executeUpdate("insert into AllBankTable values(10, 'Pranit Singh', 'IN010', 'JC010', '03050', 1221, 8000)");
            // allStatement.executeUpdate("insert into AllBankTable values(11, 'Nawaz Singh', 'IN011', 'RR011', '02099', 1552, 10000)");
            // allStatement.executeUpdate("insert into AllBankTable values(12, 'Jyoti Singh', 'IN012', 'JC012', '03300', 4605, 2500)");

            // ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
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
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                String bankIDDB = rs.getString("bankid");
                if(bankIDDB.equals(bankID)) {
                    return rs.getInt("id");
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
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                int id = rs.getInt("id");
                if(index == id) {
                    //System.out.println(rs.getString("accnumber"));
                    return rs.getString("accnumber");
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
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                int id = rs.getInt("id");
                if(index == id) {
                    //System.out.println(rs.getInt("pin"));
                    return rs.getInt("pin");
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
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                int id = rs.getInt("id");
                if(index == id) {
                    //System.out.println(rs.getInt("pin"));
                    return rs.getInt("balance");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;

    }

    public void updateBalance(int index, int newbal) {
        String updbal = "update AllBankTable SET balance = ? WHERE id = ?";
        try {
            PreparedStatement preStatement = allConnection.prepareStatement(updbal);
            preStatement.setInt(1, newbal);
            preStatement.setInt(2, index);
            preStatement.executeUpdate();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() {

        try {
            if(allConnection != null)
                allConnection.close();
        }

        catch(SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }

    }

}
