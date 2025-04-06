package Computer;

public class Processor
{
    private String socket;
    private int tactovayaChastota;
    private int kollichestvoYader;

    public Processor(String socket, int tactovayaChastota, int kollichestvoYader){
        this.socket = socket;
        this.tactovayaChastota = tactovayaChastota;
        this.kollichestvoYader = kollichestvoYader;
    }

    public String getSocket() {
        return socket;
    }

    public int getKollichestvoYader() {
        return kollichestvoYader;
    }

    public int getTactovayaChastota() {
        return tactovayaChastota;
    }
}
