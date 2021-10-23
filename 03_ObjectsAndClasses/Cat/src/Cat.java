
public class Cat {
    public static final int NOMBER_OF_EYES = 2;

    private static int count;

    private double originWeight;
    private double weight;

    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    private double feedWeight;
    private double allFeedWeight;

    private String name;
    private String color;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count = count + 1;
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
    }

    public Cat(String name , double weight , String color){
        this();
        this.name = name;
        this.weight = weight;
        this.color = color;
    }
    public Cat(Cat other){
        this();
        this.name = other.name;
        this.weight = other.weight;
        this.color = other.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void meow() {
        if (weight <= MAX_WEIGHT && weight >= MIN_WEIGHT) {
            weight = weight - 1;
            System.out.println("Meow");
        } else {
        }

    }

    public void pee() {
        if (weight <= MAX_WEIGHT && weight >= MIN_WEIGHT) {
            weight = weight - (weight / 100) - 2;
            System.out.println("Meow! Meow!");
        } else {
        }
    }

    public void feed(Double amount) {
        if (weight <= MAX_WEIGHT && weight >= MIN_WEIGHT) {
            weight = weight + amount;
        } else {
        }
        feedWeight = amount;
        allFeedWeight = allFeedWeight + feedWeight;
    }

    public void drink(Double amount) {
        if (weight <= MAX_WEIGHT && weight >= MIN_WEIGHT) {
            weight = weight + amount;
        } else {
        }
    }

    public static int getCount() {
        return count;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getFeedwaight() {
        return feedWeight;
    }

    public Double getAllFeedWaight() {
        return allFeedWeight;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            count = count - 1;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            count = count - 1;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public boolean isCatAlive() {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.print("Is cat alive? ");
        return false;
        }else {
            System.out.print("Is cat alive? ");
            return true;
        }
    }
}