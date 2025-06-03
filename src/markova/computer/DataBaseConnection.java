package markova.computer;

public class DataBaseConnection
{
    private DataBase database;
    boolean inUse;

    public DataBaseConnection(DataBase db) {
        this.database = db;
        this.inUse = false;
    }

    public String getRecord(int index) {
        if (index >= 0 && index < database.records.size()) {
            return database.records.get(index);
        }
        return null;
    }

    public void addRecord(String record) {
        database.records.add(record);
    }
}
