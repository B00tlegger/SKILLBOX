public class HardDrive {
    private final HardType type;
    private final int memory;
    private final double weight;

    public HardDrive(HardType type, int memory, double weight){
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public HardType getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }
}
