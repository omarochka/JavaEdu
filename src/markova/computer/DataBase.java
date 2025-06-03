package markova.computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class DataBase
{
    List<String> records = new ArrayList<>(){
        {
            for (int i = 0; i < 10; i++) {
                records.add("Record " + (i + 1));
            }
        }
    };
    List<DataBaseConnection> connections;
    int maxConnections;

    public DataBase(int maxConnections) {
        this.maxConnections = maxConnections;
        this.connections = new ArrayList<>();
    }

    public DataBaseConnection getConnection(){
        for (DataBaseConnection connection : connections) {
            if (!connection.inUse) {
                connection.inUse = true;
                return connection;
            }
        }
        if (connections.size() < maxConnections) {
            DataBaseConnection newConnection = new DataBaseConnection(this);
            connections.add(newConnection);
            newConnection.inUse = true;
            return newConnection;
        }
        return null;
    }

    public synchronized void closeConnection(DataBaseConnection connection) {
        connection.inUse = false;
    }

    public synchronized void removeConnection(DataBaseConnection connection) {
        if (!connections.remove(connection)) throw new NoSuchElementException();
    }
}
