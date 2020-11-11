package customer;

public class Customer {
    
    private int index;
    private String accNum;
    private int balance;

    public void setIndex(int id) { // TO set index pointing in the datebase
        this.index = id;
    }

    public int getIndex() { // TO get index pointing in the datebase
        return index;
    }

    public void setAccountNumber(String accountNumber) { // TO set Acoount Number pointing in the datebase
        this.accNum = accountNumber;
    }

    public String getAccountNumber() { // TO get Account Number pointing in the datebase
        return accNum;
    }

    public void setBalance(int bal) { // TO set Balance pointing in the datebase
        this.balance = bal;
    }

    public int getBalance() { // TO get Balance pointing in the datebase
        return balance;
    }

}
