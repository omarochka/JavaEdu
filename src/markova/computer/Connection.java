package markova.computer;

import markova.exceptions.NetworkConnectionException;
import markova.exceptions.UsingClosedResourceException;

import java.io.Closeable;
import java.util.Random;

public class Connection implements Closeable
{
    String address;
    Boolean status;

    public Connection(String address){
        this.address = address;
        this.open(address);
    }

    private void open(String address) {
        status = true;
        System.out.println("Connection open: " + address);
    }

    @Override
    public void close(){
        status = false;
        System.out.println("Connection closed");
    }

    public String getData() throws NetworkConnectionException{
        if(!status) throw new UsingClosedResourceException();
        if (new Random().nextInt(2) == 1){
            return "Test connection";
        }
        else throw new NetworkConnectionException("Не удалось получить данные с сервера", new Exception("Connection timed out"));
    }

    @Override
    public String toString() {
        return "Address: " + address + "\nStatus: " + status + "\n";
    }
}
