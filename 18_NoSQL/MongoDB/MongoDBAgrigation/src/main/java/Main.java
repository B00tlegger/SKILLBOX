
public class Main {
    public static DBCollection shops;
    public static DBCollection products;


    public static void main(String[] args) {
        MongoDBStorage.init();
        shops = new DBCollection("Shops");
        shops.deleteAll();
        products = new DBCollection("Products");
        products.deleteAll();
        action(Commands.ADD_SHOP, "Пятёрочка");
        action(Commands.ADD_SHOP, "Магнит");
        action(Commands.ADD_PRODUCT, "Вафли", 54);
        action(Commands.ADD_PRODUCT, "Кефир", 60);
        action(Commands.ADD_PRODUCT, "Шоколадная паста", 150);
        action(Commands.UPLOAD_PRODUCT, "Пятёрочка", "Вафли");
        action(Commands.UPLOAD_PRODUCT, "Пятёрочка", "Кефир");
        action(Commands.UPLOAD_PRODUCT, "Пятёрочка", "Шоколадная паста");
        action(Commands.UPLOAD_PRODUCT, "пячка", "Кефир");
        action(Commands.UPLOAD_PRODUCT, "Магнит", "Кефир");
        action(Commands.UPLOAD_PRODUCT, "Магнит", "Вафли");

        action(Commands.STATISTIC_PRODUCT);
    }

    public static void action(Commands commands, String name) {
        if (commands.equals(Commands.ADD_SHOP)) {
            if (!shops.isFind(name)) {
                shops.addShop(new Shop(name));
            }
        }

    }

    public static void action(Commands commands, String name, int price) {
        if (commands.equals(Commands.ADD_PRODUCT)) {
            if (!products.isFind(name)) {
                products.addProduct(new Product(name, price));
            }
        }

    }

    public static void action(Commands commands, String shopName, String productName) {
        if (commands.equals(Commands.UPLOAD_PRODUCT)) {
            if (shops.isFind(shopName) && products.isFind(productName)) {
                shops.uploadProduct(shopName, productName);
            }
        }

    }

    public static void action(Commands commands) {
        if (commands.equals(Commands.STATISTIC_PRODUCT)) {
            shops.getStatistic(products.getName());
        }

    }
}
