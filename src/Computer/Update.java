package Computer;

public class Update
{
    private String name;
    private int pciExpressVersion;
    private String work;

    public Update(String name, int pciExpressVersion, String work){
        this.name = name;
        this.pciExpressVersion = pciExpressVersion;
        this.work = work;
    }

    public int getPciExpressVersion() {
        return pciExpressVersion;
    }

    public String getName() {
        return name;
    }

    public String getWork() {
        return work;
    }
}
