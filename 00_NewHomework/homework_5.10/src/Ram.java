public class Ram {
    private final RamType type;
    private final int memory;
    private final double weight;

    public Ram(RamType type, int memory, double weight){
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public RamType getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }
}
