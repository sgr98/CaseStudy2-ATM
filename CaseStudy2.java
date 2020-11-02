import java.util.Scanner;
import java.sql.*;

interface db {
    public void establishDB();
    public int getIndexByName(String name);
    public void closeConnection();
}

class BankDatabase implements db{

    Connection bankConnection = null;
    Statement bankstatement = null;

    BankDatabase() {
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

class AllDatabase implements db{

    Connection allConnection = null;
    Statement allStatement = null;

    AllDatabase() {
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
            // allStatement.executeUpdate("insert into AllBankTable values(1, 'Sagar Singh', 'IN001', 'SA001', 'ANS001', 9080, 5000)");
            // allStatement.executeUpdate("insert into AllBankTable values(2, 'Ramesh Singh', 'IN002', 'SA002', 'ANS002', 1010, 20000)");
            // allStatement.executeUpdate("insert into AllBankTable values(3, 'Anuja Singh', 'IN003', 'SA003', 'ANS110', 9587, 2100)");
            // allStatement.executeUpdate("insert into AllBankTable values(4, 'Janed Singh', 'IN004', 'SA004', 'ANS115', 3582, 3000)");
            // allStatement.executeUpdate("insert into AllBankTable values(5, 'Vinod Singh', 'IN005', 'SA005', 'ANS220',1302, 2000)");
            // allStatement.executeUpdate("insert into AllBankTable values(6, 'Rohan Singh', 'IN006', 'SA006', 'ANS200', 1125, 1500)");
            // allStatement.executeUpdate("insert into AllBankTable values(7, 'Hemant Singh', 'IN007', 'SA007', 'ANS119', 7998, 7000)");
            // allStatement.executeUpdate("insert into AllBankTable values(8, 'Sachin Singh', 'IN008', 'SA008', 'ANS120', 8251, 11000)");
            // allStatement.executeUpdate("insert into AllBankTable values(9, 'Pooja Singh', 'IN009', 'RR009', 'ANR100', 9999, 23000)");
            // allStatement.executeUpdate("insert into AllBankTable values(10, 'Pranit Singh', 'IN010', 'JC010', 'ANJ050', 1221, 8000)");
            // allStatement.executeUpdate("insert into AllBankTable values(11, 'Nawaz Singh', 'IN011', 'RR011', 'ANR099', 1552, 10000)");
            // allStatement.executeUpdate("insert into AllBankTable values(12, 'Jyoti Singh', 'IN012', 'JC012', 'ANJ300', 4605, 2500)");

            ResultSet rs = allStatement.executeQuery("select * from AllBankTable");
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
            ResultSet rs = allStatement.executeQuery("select * from person");
            while(rs.next()) {
                String nameDB = rs.getString("name");
                if(nameDB.equals(name)) {
                    return rs.getInt("id");
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
            if(allConnection != null)
                allConnection.close();
        }

        catch(SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }

    }

}



// ATM Class to replicate an ATM
class ATM {

    Scanner in;
    BankDatabase BankDB;
    AllDatabase AllDB;

    ATM() {
        in = new Scanner(System.in);
        BankDB = new BankDatabase();
        BankDB.establishDB();
        AllDB = new AllDatabase();
        AllDB.establishDB();
    }

    public void closeBank() {
        BankDB.closeConnection();
        AllDB.closeConnection();
    }

    public void enter() {

        while(true) { // A customer walks in

            boolean continued = false;

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Welcome to the Sagar Bank");
            System.out.println("Press 1 to continue");
            System.out.println("Enter -1 and Password to demolish my Bank");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            if(in.nextInt() == 1) {
                continued = true;
            }
            else {
                System.out.println("\nPlease Press only 1 to continue\n");
            }

            if(continued) {

                while(true) {

                    boolean hasBankID = false;

                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                    System.out.println("Please enter your bank ID");
                    System.out.println("Press 0 to exit");
                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    
                    String bIDInput = in.next();

                    if(true) { // if bank ID exists
                        hasBankID = true;
                    }
                    // else if(bIDInput.equals("0")) {
                    //     break;
                    // }
                    // else {
                    //     System.out.println("\nPlease enter a valid bankID\n");
                    // }

                    if(hasBankID) {

                        

                    }

                }
            }

        }

    }

}

public class CaseStudy2 {

    public static void main(String[] args) {

        ATM atm = new ATM();


    }

}