//import java.util.Scanner;
import Database.AllDatabase;
import customer.Customer;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.*;

interface screenInterface {
    public void closeAllScreens();
}

class Screen implements screenInterface {

    private JFrame welcome;
    private JFrame dissolve;
    private JFrame login;
    private JFrame mainMenu;
    private JFrame balance;
    private JFrame withdraw;
    private JFrame deposit;
    private JFrame depToSelfFrame;
    private JFrame transFrame;
    private JFrame depToAnoFrame;
    private JFrame oTPFrame;
    private JFrame miniStatementFrame;

    public WelcomeScr welcomeScr;
    public DissolveScr dissolveScr;
    public LoginScr loginScr;
    public MainMenuScr mainMenuScr;
    public BalanceScr balanceScr;
    public WithdrawScr withdrawScr;
    public DepositScr depositScr;
    public DepositToSelfScr depositToSelfScr;
    public TransferScr TransferScr;
    public DepositToAnotherScr depositToAnotherScr;
    public OTPScr oTPScr;
    public MiniStatementScr miniStatementScr;

    public Screen() {

        // Creating instance of JFrame
        welcome = new JFrame("Sagar Bank");
        dissolve = new JFrame("Dissolve");
        login = new JFrame("Login");
        mainMenu = new JFrame("Main Menu");
        balance = new JFrame("Balance");
        withdraw = new JFrame("Withdraw");
        deposit = new JFrame("Deposit");
        depToSelfFrame = new JFrame("Deposit To Self");
        transFrame = new JFrame("Transfer To Another");
        depToAnoFrame = new JFrame("Deposit To Another");
        oTPFrame = new JFrame("OTP");
        miniStatementFrame = new JFrame("MiniStatement");

        welcomeScr = new WelcomeScr();
        dissolveScr = new DissolveScr();
        loginScr = new LoginScr();
        mainMenuScr = new MainMenuScr();
        balanceScr = new BalanceScr();
        withdrawScr = new WithdrawScr();
        depositScr = new DepositScr();
        depositToSelfScr = new DepositToSelfScr();
        TransferScr = new TransferScr();
        depositToAnotherScr = new DepositToAnotherScr();
        oTPScr = new OTPScr();
        miniStatementScr = new MiniStatementScr();

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
            depToSelfFrame.setVisible(false);
            transFrame.setVisible(false);
            depToAnoFrame.setVisible(false);
            miniStatementFrame.setVisible(false);
            oTPFrame.setVisible(false);
    
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
            welcome.setVisible(false);
            dissolve.setVisible(false);
            balance.setVisible(false);
            withdraw.setVisible(false);
            deposit.setVisible(false);
            depToSelfFrame.setVisible(false);
            transFrame.setVisible(false);
            depToAnoFrame.setVisible(false);
            miniStatementFrame.setVisible(false);

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
                    //System.out.println("Button clicked");
                    ATM.balance();
                }
            });

            withdrawButton.setBounds(20, 110, 160, 35);
            panel.add(withdrawButton);
            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button clicked");
                    ATM.withdraw();
                }
            });

            depositButton.setBounds(20, 150, 160, 35);
            panel.add(depositButton);
            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button clicked");
                    ATM.deposit();
                }
            });

            exitButton.setBounds(20, 190, 160, 35);
            panel.add(exitButton);
            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ATM.miniStat();
                }
            });

            mainMenu.setVisible(true);

        }

    }

    public class BalanceScr {

        JPanel panel;
        JLabel label = new JLabel("Your balance is ");
        JButton back = new JButton("Go back");

        private int bal = 0;

        BalanceScr() {
            panel = new JPanel();
        }

        public void balanceScreen() {

            mainMenu.setVisible(false);

            balance.setSize(300, 170);
            balance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            balance.add(panel);
            panel.setLayout(null);

            //Label
            label.setBounds(10, 20, 200, 30);
            panel.add(label);
            bal = ATM.getCustomerBalance();
            label.setText("Your balance is : " + bal);


            //Button
            back.setBounds(110, 70, 80, 30);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    ATM.screen();
                }
            });

            balance.setVisible(true);

        }

    }

    public class WithdrawScr {

        JPanel panel;
        JLabel entryMess = new JLabel("Enter the amount of money you want to withdraw");
        JTextField amount = new JTextField(20);
        JButton back = new JButton("Go Back");
        JButton withdrawButton = new JButton("Withdraw");
        JLabel message = new JLabel("");

        String withAmount = "";

        WithdrawScr() {
            panel = new JPanel();
        }

        public void withdrawScreen() {
            
            mainMenu.setVisible(false);

            withdraw.setSize(400, 300);
            withdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            withdraw.add(panel);
            panel.setLayout(null);

            //Label
            entryMess.setBounds(20, 30, 360, 30);
            panel.add(entryMess);

            message.setBounds(30, 200, 300, 35);
            panel.add(message);

            
            //TextField
            amount.setBounds(20, 70, 200, 30);
            panel.add(amount);


            //Button
            back.setBounds(20, 120, 90, 30);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    withAmount = "";
                    setAlertMessage("");
                    ATM.screen();
                }
            });

            withdrawButton.setBounds(130, 120, 140, 30);
            panel.add(withdrawButton);
            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    withAmount = amount.getText();
                    amount.setText("");
                    ATM.withdraw();

                }
            });

            withdraw.setVisible(true);

        }

        public String getWithdrawAmount() {
            return withAmount;
        }

        public void setAlertMessage(String str) {
            message.setText(str);
        }

    }

    public class DepositScr {

        JPanel panel;
        JButton depToSelf = new JButton("Deposit to Self");
        JButton transfer = new JButton("Transfer");
        JButton depToAno = new JButton("Deposit to Another");
        JButton back = new JButton("Go Back");

        DepositScr() {
            panel = new JPanel();
        }

        public void depositScreen() {
            
            mainMenu.setVisible(false);
            depToSelfFrame.setVisible(false);
            transFrame.setVisible(false);
            depToAnoFrame.setVisible(false);
            oTPFrame.setVisible(false);

            deposit.setSize(270, 300);
            deposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            deposit.add(panel);
            panel.setLayout(null);


            //Button
            depToSelf.setBounds(20, 20, 150, 35);
            panel.add(depToSelf);
            depToSelf.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    ATM.depositMoneyToSelf();
                }
            });

            transfer.setBounds(20, 70, 150, 35);
            panel.add(transfer);
            transfer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked tra");
                    ATM.TransferMoney();
                }
            });

            depToAno.setBounds(20, 120, 150, 35);
            panel.add(depToAno);
            depToAno.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked Ano");
                    ATM.depositMoneyToAnother();
                }
            });

            back.setBounds(20, 170, 150, 35);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    ATM.screen();
                }
            });

            deposit.setVisible(true);

        }

    }

    public class DepositToSelfScr {

        JPanel panel;
        JLabel label = new JLabel("Enter the amount of money you are depositing");
        JTextField depositText = new JTextField(20);
        JButton depositButton = new JButton("DEPOSIT");
        JButton back = new JButton("Go Back");

        String depoAmount;

        DepositToSelfScr() {
            panel = new JPanel();
        }

        public void DepositToSelfScreen() {

            deposit.setVisible(false);

            depToSelfFrame.setSize(500, 300);
            depToSelfFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            depToSelfFrame.add(panel);
            panel.setLayout(null);

            //Label
            label.setBounds(30, 40, 300, 30);
            panel.add(label);


            //Deposit
            depositText.setBounds(30, 80, 200, 30);
            panel.add(depositText);
            depositText.setText("");

            depositButton.setBounds(80, 140, 300, 30);
            panel.add(depositButton);
            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    depoAmount = depositText.getText();
                    depositText.setText("");
                    ATM.depositMoneyToSelf();
                }
            });


            //Back
            back.setBounds(80, 190, 300, 30);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    depositText.setText("");
                    ATM.deposit();
                }
            });


            depToSelfFrame.setVisible(true);

        }

        public String getDepositAmount() {
            return depoAmount;
        }
    }

    public class TransferScr {

        JPanel panel;
        JLabel label = new JLabel("Transfer Money to another account from your account");

        JLabel accountLabel = new JLabel("Enter to-Account Number");
        JTextField accountText = new JTextField(20);

        JLabel ifscLabel = new JLabel("Enter to-IFSC code");
        JTextField ifscText = new JTextField(20);

        JLabel transferAmountLabel = new JLabel("Enter the amount"); 
        JTextField transferAmountText = new JTextField(20);

        JButton transferButton = new JButton("TRANSFER");
        JButton back = new JButton("Go Back");
        JLabel message = new JLabel("");

        String toAccnNumber = "";
        String toIFSC = "";
        String toTransfer = "";


        TransferScr() {
            panel = new JPanel();
        }

        public void TransferScreen() {
            
            deposit.setVisible(false);

            transFrame.setSize(500, 420);
            transFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            transFrame.add(panel);
            panel.setLayout(null);

            //Label
            label.setBounds(30, 30, 400, 30);
            panel.add(label);


            //Account Number
            accountLabel.setBounds(30, 80, 200, 30);
            panel.add(accountLabel);

            accountText.setBounds(220, 80, 200, 30);
            panel.add(accountText);


            //IFSC
            ifscLabel.setBounds(30, 130, 200, 30);
            panel.add(ifscLabel);

            ifscText.setBounds(220, 130, 200, 30);
            panel.add(ifscText);


            //Transfer Amount
            transferAmountLabel.setBounds(30, 180, 200, 30);
            panel.add(transferAmountLabel);

            transferAmountText.setBounds(220, 180, 200, 30);
            panel.add(transferAmountText);


            //Button
            transferButton.setBounds(80, 250, 290, 30);
            panel.add(transferButton);
            transferButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    toAccnNumber = accountText.getText();
                    toIFSC = ifscText.getText();
                    toTransfer = transferAmountText.getText();

                    accountText.setText("");
                    ifscText.setText("");
                    transferAmountText.setText("");

                    ATM.TransferMoney();
                }
            });

            back.setBounds(80, 290, 290, 30);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    setAlertMessage("");
                    accountText.setText("");
                    ifscText.setText("");
                    transferAmountText.setText("");
                    ATM.deposit();
                }
            });

            
            //Message
            message.setBounds(30, 340, 400, 30);
            panel.add(message);


            transFrame.setVisible(true);

        }

        public void setAlertMessage(String str) {
            message.setText(str);
        }

        public String getToAccountNumber() {
            return toAccnNumber;
        }

        public String getToIFSC() {
            return toIFSC;
        }

        public String getToTransfer() {
            return toTransfer;
        }

        public void resetAccnIFSC() {
            toAccnNumber = "";
            toAccnNumber = "";
            accountText.setText("");
            ifscText.setText("");
            transferAmountText.setText("");
        }

    }

    public class DepositToAnotherScr {

        JPanel panel;
        JLabel label = new JLabel("Deposit Money into another account");

        JLabel accountLabel = new JLabel("Enter to-Account Number");
        JTextField accountText = new JTextField(20);

        JLabel ifscLabel = new JLabel("Enter to-IFSC code");
        JTextField ifscText = new JTextField(20);

        JLabel depositLabel = new JLabel("Enter Amount"); 
        JTextField DepositText = new JTextField(20);
        
        JButton depositButton = new JButton("DEPOSIT");
        JButton back = new JButton("Go Back");
        JLabel message = new JLabel("");

        String toAccnNumber = "";
        String toIFSC = "";
        String toDeposit = "";

        DepositToAnotherScr() {
            panel = new JPanel();
        }

        public void DepositToAnotherScreen() {
            
            deposit.setVisible(false);

            depToAnoFrame.setSize(500, 420);
            depToAnoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            depToAnoFrame.add(panel);
            panel.setLayout(null);


            //Label
            label.setBounds(30, 30, 400, 30);
            panel.add(label);


            //Account Number
            accountLabel.setBounds(30, 80, 200, 30);
            panel.add(accountLabel);

            accountText.setBounds(220, 80, 200, 30);
            panel.add(accountText);


            //IFSC
            ifscLabel.setBounds(30, 130, 200, 30);
            panel.add(ifscLabel);

            ifscText.setBounds(220, 130, 200, 30);
            panel.add(ifscText);


            //Deposit to Another Amount
            depositLabel.setBounds(30, 180, 200, 30);
            panel.add(depositLabel);

            DepositText.setBounds(220, 180, 200, 30);
            panel.add(DepositText);


            //Button
            depositButton.setBounds(80, 250, 290, 30);
            panel.add(depositButton);
            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");

                    toAccnNumber = accountText.getText();
                    toIFSC = ifscText.getText();
                    toDeposit = DepositText.getText();

                    accountText.setText("");
                    ifscText.setText("");
                    DepositText.setText("");

                    ATM.depositMoneyToAnother();

                }
            });

            back.setBounds(80, 290, 290, 30);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    setAlertMessage("");
                    accountText.setText("");
                    ifscText.setText("");
                    DepositText.setText("");
                    ATM.deposit();
                }
            });


            //Message
            message.setBounds(30, 340, 400, 30);
            panel.add(message);


            depToAnoFrame.setVisible(true);

        }

        public void setAlertMessage(String str) {
            message.setText(str);
        }

        public String getToAccountNumber() {
            return toAccnNumber;
        }

        public String getToIFSC() {
            return toIFSC;
        }

        public String getToDeposit() {
            return toDeposit;
        }

        public void resetAccnIFSC() {
            toAccnNumber = "";
            toAccnNumber = "";
            accountText.setText("");
            ifscText.setText("");
            DepositText.setText("");
        }

    }

    public class OTPScr {

        JPanel panel;
        JLabel label = new JLabel("Enter OTP :");
        JTextField otpText = new JTextField(4);
        JButton contd = new JButton("Continue");
        JButton exit = new JButton("Exit");

        OTPScr() {
            panel = new JPanel();
        }

        public void otpScreen() {

            depToSelfFrame.setVisible(false);
            transFrame.setVisible(false);
            depToAnoFrame.setVisible(false);

            oTPFrame.setSize(300, 200);
            oTPFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            oTPFrame.add(panel);
            panel.setLayout(null);


            //Label
            label.setBounds(20, 20, 80, 30);
            panel.add(label);

            otpText.setBounds(120, 20, 100, 30);
            panel.add(otpText);


            //Button
            contd.setBounds(80, 70, 120, 30);
            panel.add(contd);
            contd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    int otp = ATM.getOTP();
                    String otpString = "";
                    while(true) {
                        otpString = otpText.getText();
                        if(!otpString.equals("")) {
                            break;
                        }
                    }

                    int otpInput = Integer.parseInt(otpString);

                    if(otpInput == otp) {
                        System.out.println("To Customer's mobile : Transaction Successfull");
                        if(ATM.getTrans()) {
                            ATM.setDepAno(false);
                            ATM.setTrans(false);
                            ATM.transactDepositAno();
                        }
                        if(ATM.getDepAno()) {
                            ATM.setDepAno(false);
                            ATM.setTrans(false);
                            ATM.transactTransfer();
                        }
                    }
                    else {
                        System.out.println("To Customer's mobile : Transaction Failed");
                    }

                    ATM.deposit();
                }
            });
            
            exit.setBounds(80, 120, 120, 30);
            panel.add(exit);
            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    System.out.println("To Customer's mobile : Transaction Failed");
                    ATM.deposit();
                }
            });


            oTPFrame.setVisible(true);

        }

    }

    public class MiniStatementScr {

        JPanel panel;
        JLabel miniStatement = new JLabel("No transaction performed");
        JButton exit = new JButton("Exit");

        MiniStatementScr() {
            panel = new JPanel();
        }

        public void MiniStatementScreen() {

            mainMenu.setVisible(false);

            miniStatementFrame.setSize(250, 300);
            miniStatementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            miniStatementFrame.add(panel);
            panel.setLayout(null);


            //Label
            miniStatement.setBounds(20, 30, 160, 20);
            panel.add(miniStatement);

            
            //Exit
            exit.setBounds(50, 160, 100, 30);
            panel.add(exit);
            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Button Clicked");
                    ATM.enter();
                }
            });


            miniStatementFrame.setVisible(true);

        }

        public void setLabel(String str) {
            miniStatement.setText(str);
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

    //private static Scanner in;
    private static AllDatabase AllDB;
    private static int requiredIndex;
    private static int toIndex;

    private static boolean completedOps = false;
    private static boolean transferCompletedOps = false;
    private static boolean DepositCompletedOps = false;

    private static Customer customer; // There can only be one customer at an ATM at a time. Hence static

    private static Screen screen;

    public static boolean test = false;
    final private static int charge = 2;

    private static String t = "";
    private static String d = "";
    private static int otpInteger = 0;

    private static boolean isTrans = false;
    private static boolean isDepAno = false;

    public static String miniMessage = "";

    ATM() {
        //in = new Scanner(System.in);
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

    //======================================
    //======MAIN MENU STARTS HERE===========
    //======================================
    public static void screen() { // The main screen showing and providing the options to check balance, withdraw and deposit money

        screen.mainMenuScr.mainMenuScreen();

        setCustomerBalance();
        transferCompletedOps = false;
        DepositCompletedOps = false;
        toIndex = 0;

    }

    public static void setCustomerBalance() { // To set customer balance in the customer object from the database
        int bal = AllDB.getBalance( customer.getIndex() );
        customer.setBalance(bal);
    }

    public static void setCustomerBalance(int bal) { // To set customer balance in the customer object using a balance parameter
        customer.setBalance(bal);
    }

    public static int getCustomerBalance() {
        return customer.getBalance();
    }

    public static void balance() {
        screen.balanceScr.balanceScreen();
        miniMessage += ( "You checked balance : " + String.valueOf(customer.getBalance()) + "\n");
    }

    public static void updateCustomerBalance(int amount) {
        int newBalance = customer.getBalance() + amount;
        customer.setBalance(newBalance);
        AllDB.updateBalance(requiredIndex, newBalance);
    }

    public static void updateToSenderBalance(int amount, int ind) {
        int newBalance = AllDB.getBalance(ind) + amount;
        AllDB.updateBalance(ind, newBalance);
    }

    public static void withdraw() { // To withdraw money from your account

        screen.withdrawScr.withdrawScreen();

        String withAmount = screen.withdrawScr.getWithdrawAmount();

        if(withAmount.equals("")) {
            //screen.withdrawScr.setAlertMessage("Please enter a withdrawal amount");
        }
        else {
            try{
                int with = Integer.parseInt(withAmount);
                if(!AllDB.isBankCustomer(customer.getIndex())) {
                    with += (with * charge / 100);
                }
                with *= -1;
                int bal = ATM.getCustomerBalance();
                if(bal + with >= 0) {
                    ATM.updateCustomerBalance(with);
                    screen.withdrawScr.setAlertMessage("Please collect your cash from below");
                    miniMessage += ( "You withdrawed : " + String.valueOf(with) + " + taxes\n");
                }
                else {
                    screen.withdrawScr.setAlertMessage("Entered Amount is greater than your balance");
                }

            }
            catch(Exception error) {
                System.err.println(error.getMessage());;
            }
        }
        

    }

    public static void deposit() { // To deposit money into an account

        screen.depositScr.depositScreen();
        transferCompletedOps = false;
        DepositCompletedOps = false;
        toIndex = 0;
        resetTD();

    }

    public static void depositMoneyToSelf() {

        screen.depositToSelfScr.DepositToSelfScreen();

        String depositAmount = "";
        depositAmount = screen.depositToSelfScr.getDepositAmount();

        try{

            int deposit = Integer.parseInt(depositAmount);
            if(!AllDB.isBankCustomer(customer.getIndex())) {
                deposit -= (deposit * charge / 100);
            }
            miniMessage += ( "You deposited : " + String.valueOf(deposit) + " + taxes\n");
            ATM.updateCustomerBalance(deposit);

        }
        catch(Exception error) {
            //System.err.println(error.getMessage());;
        }

    }

    public static void TransferMoney() {
     
        String toAccn = screen.TransferScr.getToAccountNumber();
        String toIFSC = screen.TransferScr.getToIFSC();
        t = screen.TransferScr.getToTransfer();

        if(toAccn.equals("") && toIFSC.equals("")) {
            toIndex = 0;
            screen.TransferScr.setAlertMessage("");
        }
        else {
            toIndex = AllDB.getIndexByAccountNumber(toAccn);
        }

        if(toIndex <= 0) {
            screen.TransferScr.setAlertMessage("Entered Account Number is invalid");
        }

        else {

            if(toAccn.equals(AllDB.getAccountNumber(toIndex)) && toIFSC.equals(AllDB.getIFSC(toIndex))) {
                //System.out.println("Index = " + toIndex);
                screen.TransferScr.setAlertMessage("");
                screen.TransferScr.resetAccnIFSC();
                transferCompletedOps = true;
                miniMessage += ( "You transfered : " + t + " + taxes\n");
                setTrans(true);
                startOTP();
            }

            else if(!toAccn.equals("") && !toIFSC.equals("")) {
                screen.TransferScr.setAlertMessage("Entered IFSC is invalid");
            }
            
        }

        if(!transferCompletedOps) {
            screen.TransferScr.TransferScreen();
        }

    }

    public static void depositMoneyToAnother() {

        String toAccn = screen.depositToAnotherScr.getToAccountNumber();
        String toIFSC = screen.depositToAnotherScr.getToIFSC();
        d = screen.depositToAnotherScr.getToDeposit();

        if(toAccn.equals("") && toIFSC.equals("")) {
            toIndex = 0;
            screen.TransferScr.setAlertMessage("");
        }
        else {
            toIndex = AllDB.getIndexByAccountNumber(toAccn);
        }

        if(toIndex <= 0) {
            screen.depositToAnotherScr.setAlertMessage("Entered Account Number is invalid");
        }

        else {

            if(toAccn.equals(AllDB.getAccountNumber(toIndex)) && toIFSC.equals(AllDB.getIFSC(toIndex))) {
                //System.out.println("Index = " + toIndex);
                screen.depositToAnotherScr.setAlertMessage("");
                screen.depositToAnotherScr.resetAccnIFSC();
                DepositCompletedOps = true;
                miniMessage += ( "You transfered : " + d + " + taxes\n");
                setDepAno(true);
                startOTP();
            }

            else if(!toAccn.equals("") && !toIFSC.equals("")) {
                screen.depositToAnotherScr.setAlertMessage("Entered IFSC is invalid");
            }
            
        }

        if(!DepositCompletedOps) {
            screen.depositToAnotherScr.DepositToAnotherScreen();
        }

    }

    public static void setTrans(boolean b) {
        isTrans = b;
    }

    public static boolean getTrans() {
        return isTrans;
    }

    public static void setDepAno(boolean b) {
        isDepAno = b;
    }

    public static boolean getDepAno() {
        return isDepAno;
    }

    public static void startOTP() {

        Random rand = new Random();

        while(otpInteger < 1000) {
            otpInteger = rand.nextInt(10000);
        }
        System.out.println("To Customer's mobile : Sagar bank sends you an OTP :" + otpInteger + " to your mobile number :" + AllDB.getPhoneNumber(requiredIndex) + " for the account with account number:" + customer.getAccountNumber());

        screen.oTPScr.otpScreen();

    }

    public static int getOTP() {
        return otpInteger;
    }

    public static void resetTD() {
        t = "";
        d = "";
    }

    public static void transactTransfer() {

        try{

            int deposit = Integer.parseInt(t);
            deposit *= -1;
            if(customer.getBalance() + deposit >= 0) {
                ATM.updateCustomerBalance(deposit);
                deposit *= -1;
                if(!AllDB.isBankCustomer(customer.getIndex())) {
                    deposit -= (deposit * charge / 100);
                }
                ATM.updateToSenderBalance(deposit, toIndex);
            }
            else {
                screen.TransferScr.setAlertMessage("The entered amount is greater than your balance");
            }
            
        }
        catch(Exception error) {
            //System.err.println(error.getMessage());;
        }

    }

    public static void transactDepositAno() {

        try{

            int deposit = Integer.parseInt(d);
            deposit *= -1;
            ATM.updateCustomerBalance(deposit);
            deposit *= -1;
            if(!AllDB.isBankCustomer(customer.getIndex())) {
                deposit -= (deposit * charge / 100);
            }
            ATM.updateToSenderBalance(deposit, toIndex);
            
        }
        catch(Exception error) {
            //System.err.println(error.getMessage());;
        }

    }

    public static void miniStat() {

        screen.miniStatementScr.setLabel(miniMessage);
        screen.miniStatementScr.MiniStatementScreen();

    }

}


public class CaseStudy2 {

    public static void main(String[] args) {

        ATM atm = new ATM(); // Instantiating the ATM object
        atm.start(); // Starting the ATM

    }

}