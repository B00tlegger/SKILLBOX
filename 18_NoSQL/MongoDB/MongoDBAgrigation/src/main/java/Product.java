public class Product {
    private final String NAME;
    private final int PRICE;

    public Product(String name, int price){
        NAME = name;
        PRICE = price;
    }

    public String getName() {
        return NAME;
    }

    public int getPrice() {
        return PRICE;
    }
}
