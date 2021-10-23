public class Keyboard {
    private final KeyboardType type;
    private final boolean light;
    private final double weight;

    public Keyboard(KeyboardType type, boolean light, double weight){
        this.type = type;
        this.light = light;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public KeyboardType getType() {
        return type;
    }


    public boolean isLight() {
        return light;
    }
}
