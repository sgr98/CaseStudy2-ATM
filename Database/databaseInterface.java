package Database;

public interface databaseInterface {
    public void establishDB(); // To initiate the database (Once implemented, then it can be commented and used multiple times)
    public int getIndexByAccountNumber(String AccnNum); // To get index of an account using the bank ID
    public void closeConnection(); // To close the connection to the database once the bank is bankrupt
    public String getAccountNumber(int index); // To get the account Number from DB using the index
    public int getPIN(int index); // To get the PIN number from DB using the index
    public int getBalance(int index); // To get the current balance from DB using the index
    public void updateBalance(int index, int newbal); // To update balance present in DB during a transaction
    public boolean isBankCustomer(int index);
    public String getIFSC(int index);
    public String getPhoneNumber(int index);
    public void setNewPIN(int index, int pin);
}
