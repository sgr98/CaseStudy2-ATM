import java.util.Scanner;

import Database.BankDatabase;
import Database.AllDatabase;

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