import java.util.Scanner;
import Database.AllDatabase;
import customer.Customer;
import java.lang.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.*;

class Screen {

    private JFrame welcome;
    private JFrame dissolve;
    private JFrame login;
    private JFrame mainMenu;
    private JFrame balance;
    private JFrame withdraw;
    private JFrame deposit;

    public WelcomeScr welcomeScr;
    public DissolveScr dissolveScr;
    public LoginScr loginScr;
    public MainMenuScr mainMenuScr;

    public Screen() {

        // Creating instance of JFrame
        welcome = new JFrame("Sagar Bank");
        dissolve = new JFrame("Sagar Bank");
        login = new JFrame("Sagar Bank");
        mainMenu = new JFrame("Sagar Bank");
        balance = new JFrame("Sagar Bank");
        withdraw = new JFrame("Sagar Bank");
        deposit = new JFrame("Sagar Bank");

        welcomeScr = new WelcomeScr();
        dissolveScr = new DissolveScr();
        loginScr = new LoginScr();
        mainMenuScr = new MainMenuScr();

    }

    public void closeAllScreens() {
        welcome.dispose();
        dissolve.dispose();
        login.dispose();
        mainMenu.dispose();
        balance.dispose();
        withdraw.dispose();
        deposit.dispose();
    }

    public class WelcomeScr {

        JPanel panel;
        JLabel userLabel = new JLabel("Welcome to Sagar Bank");
        JButton button = new JButton("Press to Continue");
        JButton dissolveButton = new JButton("Press to Disolve");

        private boolean conti = false;
        private boolean dissolved = false;

        WelcomeScr() {
            panel = new JPanel();
        }

        public void welcomeScreen() {

            dissolve.setVisible(false);
            login.setVisible(false);
            mainMenu.setVisible(false);
            balance.setVisible(false);
            withdraw.setVisible(false);
            deposit.setVisible(false);
    
            welcome.setSize(350, 200);
            welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            
            welcome.add(panel);
            panel.setLayout(null);

            //LABEL field
            userLabel.setBounds(95, 30, 300, 25);
            panel.add(userLabel);
    
    
            //BUTTON field
            button.setBounds(75, 60, 200, 35);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    conti = true;
                    ATM.login();
                }
            }); 
    
            dissolveButton.setBounds(75, 100, 200, 35);
            panel.add(dissolveButton);
            dissolveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dissolved = true;
                    ATM.dissolveBank();
                }
            }); 
    
            welcome.setVisible(true);
        }

        public boolean getContinueConfirmation() {
            return conti;
        }

        public boolean getDissolveConfirmation() {
            return dissolved;
        }

        public void setContinueConfirmation(boolean booled) {
            conti = booled;
        }

        public void setDissolveConfirmation(boolean booled) {
            dissolved = booled;
        }

    }

    public class DissolveScr {

        JPanel panel;
        JLabel userLabel = new JLabel("ENTER THE NUKE CODES TO DISSOLVE THE BANK");
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordText = new JPasswordField(20);
        JButton back = new JButton("Go back");
        JButton button = new JButton("Be Sure about it");

        String pswd = "";



        DissolveScr() {
            panel = new JPanel();
        }

        public void dissolveScreen() {

            welcome.setVisible(false);
    
            dissolve.setSize(350, 200);
            dissolve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            dissolve.add(panel);
    
            panel.setLayout(null);
    
            //LABEL field
            userLabel.setBounds(15, 25, 320, 25);
            panel.add(userLabel);
    
    
            //PASSWORD field
            passwordLabel.setBounds(10,65,80,25);
            panel.add(passwordLabel);
    
            passwordText.setBounds(100,65,165,25);
            panel.add(passwordText);
    
    
            //BUTTON field
            back.setBounds(35, 110, 100, 25);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ATM.enter();
                }
            }); 

            button.setBounds(140, 110, 170, 25);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    pswd = String.valueOf(passwordText.getPassword());
                    passwordText.setText("");
                    //System.out.println(pswd + " fdsfdsf ");
                    ATM.dissolveBank();
                }
            });
    
            dissolve.setVisible(true);
    
        }

        public String dissolvePassword() {
            return pswd;
        }

    }

    public class LoginScr {

        JPanel panel;
        JLabel userLabel = new JLabel("Account Number");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("PIN number");
        JPasswordField passwordText = new JPasswordField(20);
        JButton loginButton = new JButton("login");
        JButton back = new JButton("Go Back");
        JLabel message = new JLabel("");

        String accn = "";
        String pin = "";

        LoginScr() {
            panel = new JPanel();
        }

        public void loginScreen() {

            welcome.setVisible(false);
    
            login.setSize(350, 250);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            /* Creating panel. This is same as a div tag in HTML
             * We can create several panels and add them to specific 
             * positions in a JFrame. Inside panels we can add text 
             * fields, buttons and other components.
             */
            
            // adding panel to frame
            login.add(panel);
            panel.setLayout(null);
    
            // Creating JLabel
            userLabel.setBounds(10,20,110,25);
            panel.add(userLabel);
    
            userText.setBounds(130,20,165,25);
            panel.add(userText);
    
    
            // Same process for password label and text field.
            passwordLabel.setBounds(10,60,110,25);
            panel.add(passwordLabel);
    
            passwordText.setBounds(130,60,165,25);
            panel.add(passwordText);
    
    
            // Creating button
            back.setBounds(35, 110, 90, 35);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    userText.setText("");
                    passwordText.setText("");
                    message.setText("");
                    accn = "";
                    pin = "";
                    ATM.enter();
                }
            });

            loginButton.setBounds(135, 110, 90, 35);
            panel.add(loginButton);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    accn = userText.getText();
                    pin = String.valueOf(passwordText.getPassword());
                    // boolean chAccn = ATM.checkAccn();
                    // boolean chPin = ATM.checkPIN();
                    passwordText.setText("");
                    userText.setText("");

                    // System.out.println(chAccn + "  " + chPin);

                    // if(chAccn && chPin) {
                    //     //ATM.startTheMenu();
                        
                    //     ATM.screen();
                    // }
                    // else if(!ATM.checkAccn() && !ATM.checkPIN()) {
                    //     setAlertMessage("Entered PIN is invalid");
                    //     ATM.login();
                    // }
                    ATM.login();
                }
            });

            message.setBounds(25, 160, 220, 25);
            panel.add(message);
    
            login.setVisible(true);
    
        }

        public void resetAccnPIN() {
            accn = "";
            pin = "";
        }

        public String getloginAccn() {
            return accn;
        }

        public String getloginPIN() {
            return pin;
        }

        public void setAlertMessage(String str) {
            message.setText(str);
        }

    }


    public class MainMenuScr {

        JPanel panel;
        JLabel label = new JLabel("Press Button to view");
        JButton balanceButton = new JButton("Balance");
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton exitButton = new JButton("Exit");

        MainMenuScr() {
            panel = new JPanel();
        }

        public void mainMenuScreen() {

            login.setVisible(false);
            login.setVisible(false);
            welcome.setVisible(false);
            dissolve.setVisible(false);
            balance.setVisible(false);
            withdraw.setVisible(false);
            deposit.setVisible(false);

            mainMenu.setSize(270, 300);
            mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainMenu.add(panel);
            panel.setLayout(null);

            // Creating JLabel
            label.setBounds(20,20,190,25);
            panel.add(label);


            // Creating button
            balanceButton.setBounds(20, 70, 160, 35);
            panel.add(balanceButton);
            balanceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button clicked");
                }
            });

            withdrawButton.setBounds(20, 110, 160, 35);
            panel.add(withdrawButton);
            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button clicked");
                }
            });

            depositButton.setBounds(20, 150, 160, 35);
            panel.add(depositButton);
            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button clicked");
                }
            });

            exitButton.setBounds(20, 190, 160, 35);
            panel.add(exitButton);
            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ATM.enter();
                }
            });

            mainMenu.setVisible(true);

        }

    }

    public class BalanceScr {

        JPanel panel;

        BalanceScr() {
            panel = new JPanel();
        }

    }

    public class WithdrawScr {

        JPanel panel;

        WithdrawScr() {
            panel = new JPanel();
        }

    }

    public class DepositScr {

        JPanel panel;

        DepositScr() {
            panel = new JPanel();
        }

    }

}


//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================
//====================================================================================

// ATM Class to replicate an ATM
class ATM {

    private static Scanner in;
    private static AllDatabase AllDB;
    private static int requiredIndex;
    private static boolean completedOps = false;
    private static Customer customer; // There can only be one customer at an ATM at a time. Hence static

    private static Screen screen;

    public static boolean test = false;

    ATM() {
        in = new Scanner(System.in);
        AllDB = new AllDatabase();
        AllDB.establishDB();
        customer = new Customer();

        screen = new Screen();
    }

    private static void closeBank() { // To close the bank and its databases
        AllDB.closeConnection();
        screen.closeAllScreens();
    }

    public void start() { // To start the program from the main class
        enter();
    }

    public static void enter() { // To demonstrate a customer entering an ATM

            screen.welcomeScr.welcomeScreen();

            //New Customer comes in or the one who hasn't logged in continues
            completedOps = false;
            requiredIndex = 0;
            customer.setAccountNumber("");
            customer.setBalance(0);
            //customer.setBankID("");
            customer.setIndex(0);

    }

    public static void dissolveBank() {

        screen.dissolveScr.dissolveScreen();

        String pswd = screen.dissolveScr.dissolvePassword();
        if(pswd.equals("GOD")) { // PASSWORD to disolve bank is :GOD
            System.out.println("The bank is BANKRUPT :(");
            closeBank();
            System.exit(0);
        }

    }

    public static void login() { // To login into your bank account

        String accn = screen.loginScr.getloginAccn();
        String pin = screen.loginScr.getloginPIN();

        //System.out.println("Index = " + requiredIndex);

        if(accn.equals("") && pin.equals("")) {
            requiredIndex = 0;
        }
        else {
            requiredIndex = AllDB.getIndexByAccountNumber(accn);
        }

        if(requiredIndex == -1) {
            screen.loginScr.setAlertMessage("Entered Account Number is invalid");
        }

        else {

            if(accn.equals(AllDB.getAccountNumber(requiredIndex)) && pin.equals( String.valueOf( AllDB.getPIN(requiredIndex)) )) {
                //System.out.println("Index = " + requiredIndex);
                customer.setAccountNumber(accn);
                customer.setIndex(requiredIndex);
                screen.loginScr.setAlertMessage("");
                screen.loginScr.resetAccnPIN();
                completedOps = true;
                screen();
            }

            else if(!accn.equals("") && !pin.equals("")) {
                screen.loginScr.setAlertMessage("Entered PIN is invalid");
            }
            
        }

        if(!completedOps) {
            screen.loginScr.loginScreen();
        }
    }

    public static void screen() { // The main screen showing and providing the options to check balance, withdraw and deposit money

        screen.mainMenuScr.mainMenuScreen();

        setCustomerBalance();

        //System.out.println(customer.getBalance());

        //int decide = in.nextInt();

        // if(decide == 1) {
        //     System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        //     System.out.println("Your balance is : " + customer.getBalance());
        //     System.out.println("Press anything to continue");
        //     System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        //     in.next();
        // }
        // else if(decide == 2) {
        //     withdraw();
        // }
        // else if(decide == 3) {
        //     deposit();
        // }

        // // else if(decide == 0) {
        // //     completedOps = true;
        // //     break;
        // // }
        // else {
        //     System.out.println("Please enter a valid instruction");
        // }

        

    }

    public static void setCustomerBalance() { // To set customer balance in the customer object from the database
        int bal = AllDB.getBalance( customer.getIndex() );
        customer.setBalance(bal);
    }

    public static void setCustomerBalance(int bal) { // To set customer balance in the customer object using a balance parameter
        customer.setBalance(bal);
    }

    public static void withdraw() { // To withdraw money from your account

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

    public static void deposit() { // To deposit money into an account

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
            }

            else if(depinput == 2) {
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
                System.out.println("Enter the bank ID of the person you want to transfer money to");
                System.out.println("Enter the amount of money you are transfering :");
                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

                String anotherBankID = in.next();
                int toIndex = AllDB.getIndexByAccountNumber(anotherBankID);
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

                        int gained = AllDB.getBalance(toIndex) + amount;
                        AllDB.updateBalance(toIndex, gained);
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
                int toIndex = AllDB.getIndexByAccountNumber(anotherBankID);
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

        ATM atm = new ATM(); // Instantiating the ATM object
        atm.start(); // Starting the ATM

    }

}