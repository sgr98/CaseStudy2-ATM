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
            // allStatement.executeUpdate("create table AllBankTable (id integer, name varchar(255), nationalid varchar(255), phonenumber varchar(255), ifsc varchar(255), accnumber varchar(255), pin integer, balance integer, key varchar(255))");
            // allStatement.executeUpdate("insert into AllBankTable values(1, 'Sagar Singh', 'IN001', '111111', '0101', '01001', 9080, 5000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(2, 'Ramesh Singh', 'IN002', '111112', '0101', '01002', 1010, 20000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(3, 'Anuja Singh', 'IN003', '111113', '0101', '01110', 9587, 2100, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(4, 'Janed Singh', 'IN004', '111114', '0101', '01115', 3582, 3000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(5, 'Vinod Singh', 'IN005', '111115', '0102', '01220',1302, 2000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(6, 'Rohan Singh', 'IN006', '111116', '0102', '01200', 1125, 1500, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(7, 'Hemant Singh', 'IN007', '111117', '0103', '01119', 7998, 7000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(8, 'Sachin Singh', 'IN008', '111118', '0103', '01120', 8251, 11000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(9, 'Pooja Singh', 'IN009', '111119', '0201', '02100', 9999, 23000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(10, 'Pranit Singh', 'IN010', '111120', '0301', '03050', 1221, 8000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(11, 'Nawaz Singh', 'IN011', '111121', '0201', '02099', 1552, 10000, '000')");
            // allStatement.executeUpdate("insert into AllBankTable values(12, 'Jyoti Singh', 'IN012', '111122', '0302', '03300', 4605, 2500, '000')");

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

    public int getIndexByAccountNumber(String AccnNum) {
        try {
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                String bankIDDB = rs.getString("accnumber");
                if(bankIDDB.equals(AccnNum)) {
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

        //String pinStatement = "select pin WHERE id = ?";

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

    public boolean isBankCustomer(int index) {

        try {
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {

                int id = rs.getInt("id");
                if(id == index) {
                    String accnum = rs.getString("accnumber");
                    String bank = accnum.substring(0, 2);
                    if(bank.equals("01"))
                        return true;
                    break;
                }
            }
            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }

        return false;

    }

    public String getIFSC(int index) {

        //String pinStatement = "select pin WHERE id = ?";

        try {
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                int id = rs.getInt("id");
                if(index == id) {
                    //System.out.println(rs.getInt("pin"));
                    return rs.getString("ifsc");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return "";

    }

    public String getPhoneNumber(int index) {

        //String pinStatement = "select pin WHERE id = ?";

        try {
            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
            while(rs.next()) {
                int id = rs.getInt("id");
                if(index == id) {
                    //System.out.println(rs.getInt("pin"));
                    return rs.getString("phonenumber");
                }
            }

            //System.out.println("Person is not registered");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return "";

    }

    public void setNewPIN(int index, int pin) {

        String updbal = "update AllBankTable SET pin = ? WHERE id = ?";
        try {
            PreparedStatement preStatement = allConnection.prepareStatement(updbal);
            preStatement.setInt(1, pin);
            preStatement.setInt(2, index);
            preStatement.executeUpdate();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
