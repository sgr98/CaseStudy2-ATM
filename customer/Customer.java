package customer;

public class Customer {
    
    private int index;
    private String bankId;
    private String accNum;
    private int balance;

    public void setIndex(int id) {
        this.index = id;
    }

    public int getIndex() {
        return index;
    }

    public void setBankID(String bid) {
        this.bankId = bid;
    }

    public void setAccountNumber(String accountNumber) {
        this.accNum = accountNumber;
    }

    public String getAccountNumber() {
        return accNum;
    }

    public void setBalance(int bal) {
        this.balance = bal;
    }

    public int getBalance() {
        return balance;
    }

}
