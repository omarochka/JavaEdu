package Computer;

import java.util.Arrays;

public class Computer
{
    private String socket;
    private int pciExpressVersion;
    private Processor processor;
    private int[] ram = new int[4];
    private Update[] updates = new Update[4];
    private int workTime;

    public Computer(String socket, int pciExpressVersion){
        this.socket = socket;
        this.pciExpressVersion = pciExpressVersion;
    }

    public Computer(Processor processor, int pciExpressVersion){
        this.processor = processor;
        this.socket = processor.getSocket();
        this.pciExpressVersion = pciExpressVersion;
    }

    public void setRam(int ram, int index) {
        this.ram[index] = ram;
    }

    public void setProcessor(Processor processor) {
        if (processor.getSocket() != this.socket){
            throw new RuntimeException("Сокет процессора не совпадает с сокетом компьютера");
        }
        this.processor = processor;
    }

    public void setUpdate(Update update, int index) {
        if (this.pciExpressVersion != update.getPciExpressVersion()){
            throw new RuntimeException("Версии PSI Express не совпадают");
        }
        updates[index] = update;
    }

    public int[] getRam() {
        return Arrays.copyOf(ram, ram.length);
    }

    public Processor getProcessor() {
        return new Processor(processor.getSocket(), processor.getTactovayaChastota(), processor.getKollichestvoYader());
    }

    public Update[] getUpdate() {
        return Arrays.copyOf(updates, updates.length);
    }

    public int getWorkTime() {
        return workTime;
    }

    public void start(int sec){
        if (processor == null || Arrays.stream(ram).sum() == 0){
            throw new RuntimeException("Ошибка: отсутствует процессор или ОЗУ");
        }
        for (Update value: updates){
            if(value != null)
                System.out.println(value.getWork());
        }
        for (int i = 0; i < sec; i++){
            workTime+=1;
        }
    }
}
