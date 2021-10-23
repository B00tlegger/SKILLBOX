public class Processor {
    private final double processorRate;

    private final int coreCount;
    private final ProcessorVendor vendor;
    private final double weight;

    public Processor(double processorRate , int coreCount , ProcessorVendor vendor , double weight){
        this.processorRate = processorRate;
        this.coreCount = coreCount;
        this.vendor = vendor;
        this. weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getProcessorRate() {
        return processorRate;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public ProcessorVendor getVendor() {
        return vendor;
    }


}
