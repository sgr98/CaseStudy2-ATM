import java.util.Scanner;

import Database.BankDatabase;
import Database.AllDatabase;
import customer.Customer;

interface atm {
    public void closeBank();
    public void bankenterance();
    public void login();
    public void screen();
}

// ATM Class to replicate an ATM
class ATM {

    private Scanner in;
    private BankDatabase BankDB;
    private AllDatabase AllDB;
    private int requiredIndex;
    private boolean completedOps = false;

    ATM() {
        in = new Scanner(System.in);
        BankDB = new BankDatabase();
        BankDB.establishDB();
        AllDB = new AllDatabase();
        AllDB.establishDB();
    }

    private void closeBank() {
        BankDB.closeConnection();
        AllDB.closeConnection();
    }

    public void enter() {

        while(true) { // A customer walks in

            boolean continued = false;

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Welcome to the Sagar Bank");
            System.out.println("Press 1 to continue");
            System.out.println("Enter -1 and Password to demolish my Bank");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

            int input = in.nextInt();

            if(input == 1) {
                continued = true;
            }

            else if(input == -1){
                
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Enter the Password");
                System.out.println("If you fail, you go back to the welcome screen");
                System.out.println("Password : ");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

                String pswd = in.next();
                if(pswd.equals("GOD")) {
                    System.out.println("The bank is BANKRUPT :(");
                    closeBank();
                    break;
                }

            }

            else {
                System.out.println("\nPlease Press only 1 to continue\n");
            }

            if(continued) {
                bankenterance();
            }

        }

    }

    public void bankenterance() { // Same as inserting a card

        while(true) {

            boolean hasBankID = false;

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Please enter your bank ID");
            System.out.println("Press 0 to go back");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            
            String bIDInput = in.next();
            if(bIDInput.equals("0")) {
                break;
            }
            requiredIndex = AllDB.getIndexByBankID(bIDInput);

            if(requiredIndex > 0) { // if bank ID exists
                hasBankID = true;
            }
            else if (requiredIndex == -1) {
                System.out.println("-----------------------------------------");
                System.out.println("Entered Bank ID does not exists");
                System.out.println("-----------------------------------------");
            }

            if(hasBankID) { // if bank ID exists
                login();
            }

        }

    }

    public void login() {

        while(true) {

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Please enter your Account Number");
            System.out.println("Please enter your PIN");
            System.out.println("Press 0 to go back");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

            final String accn = in.next();
            if(accn.equals("0")) {
                break;
            }
            
            final int pin = in.nextInt();

            //System.out.println("Index = " + requiredIndex);

            if(accn.equals(AllDB.getAccountNumber(requiredIndex)) && pin == AllDB.getPIN(requiredIndex)) {
                //System.out.println("Index = " + requiredIndex);
                screen();
            }
            else {
                System.out.println("The entered Account Number or PIN is WRONG");
                System.out.println("Please try again");
            }

        }

    }

    public void screen() {

        while(true) {

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Please enter your Account Number");
            System.out.println("Please enter your PIN");
            System.out.println("Press 0 to go back");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

        }

    }

}

public class CaseStudy2 {

    public static void main(String[] args) {

        ATM atm = new ATM();
        atm.enter();

    }

}