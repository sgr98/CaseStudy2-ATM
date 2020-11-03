package Database;

public interface databaseInterface {
    public void establishDB();
    public int getIndexByBankID(String bankID);
    public void closeConnection();
    public String getAccountNumber(int index);
    public int getPIN(int index);
    public int getBalance(int index);
    public void updateBalance(int index, int newbal);
}