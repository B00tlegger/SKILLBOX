import java.util.ArrayList;

public class Shop {
    private String name;
    private ArrayList<String> products;

    public Shop (String name){
        this.name = name;
        products = new ArrayList<>();
    }

    public void addProduct(String name){
        products.add(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getProducts() {
        return products;
    }
}
