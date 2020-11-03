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
    private static Customer customer; // There can only be one customer at an ATM at a time. Hence static

    ATM() {
        in = new Scanner(System.in);
        BankDB = new BankDatabase();
        BankDB.establishDB();
        AllDB = new AllDatabase();
        AllDB.establishDB();
        customer = new Customer();
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

            //New Customer comes in or the one who hasn't logged in continues
            completedOps = false;
            requiredIndex = 0;
            customer.setAccountNumber("");
            customer.setBalance(0);
            customer.setBankID("");
            customer.setIndex(0);

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
                System.out.println("\n-----------------------------------------");
                System.out.println("Entered Bank ID does not exists");
                System.out.println("-----------------------------------------");
            }

            if(hasBankID) { // if bank ID exists
                customer.setBankID(bIDInput);
                customer.setIndex(requiredIndex);
                login();
            }

            if(completedOps) {
                break;
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
                customer.setAccountNumber(accn);
                //customer.setPIN(pin);
                screen();
            }
            else {
                System.out.println("The entered Account Number or PIN is WRONG");
                System.out.println("Please try again");
            }

            if(completedOps) {
                break;
            }

        }

    }

    public void screen() {

        while(true) {

            setCustomerBalance();

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Welcome to your Account. What would you like to use : ");
            System.out.println("Press 1 to check BALANCE");
            System.out.println("Press 2 to WITHDRAW money");
            System.out.println("Press 3 to DEPOSIT/TRANSFER");
            System.out.println("Press 0 to exit");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

            int decide = in.nextInt();

            if(decide == 1) {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Your balance is : " + customer.getBalance());
                System.out.println("Press anything to continue");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                in.next();
            }
            else if(decide == 2) {
                withdraw();
            }
            else if(decide == 3) {
                deposit();
            }

            else if(decide == 0) {
                completedOps = true;
                break;
            }
            else {
                System.out.println("Please enter a valid instruction");
            }

        }

    }

    public void setCustomerBalance() {
        int bal = AllDB.getBalance( customer.getIndex() );
        customer.setBalance(bal);
    }

    public void setCustomerBalance(int bal) {
        customer.setBalance(bal);
    }

    public void withdraw() {

        while(true) {

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Your balance is : " + customer.getBalance());
            System.out.println("Please enter the amount of money you want to withdraw");

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

            int with = in.nextInt();

            if(with <= customer.getBalance() && with > 0) {
                int newBalance = customer.getBalance() - with;
                setCustomerBalance(newBalance);
                AllDB.updateBalance(requiredIndex, newBalance);
                BankDB.updateBalance(requiredIndex, newBalance);
                // System.out.println("Customer Balance : " + customer.getBalance());
                // System.out.println("AllBankTable Balance : " + AllDB.getBalance(requiredIndex));
                // System.out.println("BankTable Balance : " + BankDB.getBalance(requiredIndex));
                break;
            }
            else if(with == 0) {
                break;
            }
            else {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Transaction Failed! The entered amount is greater than your balance");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            }
        }

    }

    public void deposit() {

        while(true) {

            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Press 1 to deposit money to self");
            System.out.println("Press 2 to transfer money to another account from your account");
            System.out.println("Press 3 to deposit money into another account");
            System.out.println("Press 0 to to go back");
            System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

            int depinput = in.nextInt();

            if(depinput == 1) {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Enter the amount of money you want to deposit");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

                int dep = in.nextInt();
                int newBalance = customer.getBalance() + dep;
                setCustomerBalance(newBalance);
                AllDB.updateBalance(requiredIndex, newBalance);
                BankDB.updateBalance(requiredIndex, newBalance);
            }

            else if(depinput == 2) {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Enter the bank ID of the person you want to transfer money to");
                System.out.println("Enter the amount of money you are transfering :");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

                String anotherBankID = in.next();
                int toIndex = AllDB.getIndexByBankID(anotherBankID);
                int amount = in.nextInt();

                boolean exist = true;
                if (toIndex == -1) {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("Entered Bank ID does not exists");
                    System.out.println("-----------------------------------------");
                    exist = false;
                }

                if(exist) {
                    
                    if(amount <= customer.getBalance()) {
                        int newBalance = customer.getBalance() - amount;
                        setCustomerBalance(newBalance);
                        AllDB.updateBalance(requiredIndex, newBalance);
                        BankDB.updateBalance(requiredIndex, newBalance);

                        int gained = AllDB.getBalance(toIndex) + amount;
                        AllDB.updateBalance(toIndex, gained);
                        BankDB.updateBalance(toIndex, gained);
                    }
                    else {
                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                        System.out.println("Transaction Failed! The entered amount is greater than your balance");
                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                    }

                }
            }

            else if(depinput == 3) {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Enter the accountNumber into which you want to deposit money into");
                System.out.println("Enter the amount of money you are depositing : ");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

                String anotherBankID = in.next();
                int toIndex = AllDB.getIndexByBankID(anotherBankID);
                int amount = in.nextInt();

                boolean exist = true;
                if (toIndex == -1) {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("Entered Bank ID does not exists");
                    System.out.println("-----------------------------------------");
                    exist = false;
                }

                if(exist) {
                    int gained = AllDB.getBalance(toIndex) + amount;
                    AllDB.updateBalance(toIndex, gained);
                    BankDB.updateBalance(toIndex, gained);
                }
            }

            else if(depinput == 0) {
                break;
            }
            else {
                System.out.println("Please enter a valid instruction");
            }

        }

    }

}

public class CaseStudy2 {

    public static void main(String[] args) {

        ATM atm = new ATM();
        atm.enter();

    }

}