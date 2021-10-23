public class Computer {
    private final String vendor;
    private final String name;
    private double weight;

    private Processor processor;
    private Ram ram;
    private HardDrive hardDrive;
    private Screen screen;
    private Keyboard keyboard;

    public Computer(String vendor , String name){
        this.vendor = vendor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double getWeight() {
        weight = processor.getWeight() + ram.getWeight() + hardDrive.getWeight() + screen.getWeight()+ keyboard.getWeight();
        return weight;
    }

    @Override
    public String toString() {
        return "Производитель - " + vendor + "\n" +
                "Модель - " + name + "\n" +
                "Вес - " + weight + "\n" +
                "Processor - " + processor.getVendor() + ", " + processor.getProcessorRate() + " MHz " + "\n" +
                "\t\sCore - " + processor.getCoreCount() + "\n" +
                "RAM - " + ram.getType() + ", " + ram.getMemory() + "Гб"  + "\n" +
                "Hard Drive - " + hardDrive.getType() + ", " + hardDrive.getMemory() + " Гб" + "\n" +
                "Screen - " + screen.getType() + ", " + screen.getDiagonaly() + "\"" + "\n" +
                "Keyboard - " + keyboard.getType() + "\n" +
                "подсветка клавиатуры - " + keyboard.isLight();
    }
}
