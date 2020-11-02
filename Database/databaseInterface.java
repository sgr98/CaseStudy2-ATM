package Database;

public interface databaseInterface {
    public void establishDB();
    public int getIndexByName(String name);
    public void closeConnection();
}
