import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;


import java.util.Arrays;

import java.util.function.Consumer;

public class DBCollection {
    private final MongoCollection<Document> mongoCollection;
    private final String name;

    public DBCollection(String collectionName) {
        MongoDatabase database = MongoDBStorage.getDatabase();
        mongoCollection = database.getCollection(collectionName);
        name = collectionName;
    }

    public void deleteAll() {
        mongoCollection.drop();
    }

    public void addShop(Shop shop) {
        Document document = new Document();
        document.append("Name", shop.getName());
        document.append("Products", shop.getProducts());
        mongoCollection.insertOne(document);
    }

    public void addProduct(Product product) {
        Document document = new Document();
        document.append("Name", product.getName());
        document.append("Price", product.getPrice());
        mongoCollection.insertOne(document);
    }

    public void uploadProduct(String shopName, String productName) {
        BsonDocument bsonDocument = BsonDocument.parse("{ Name: " + "\"" + shopName + "\"" + " }");
        BsonDocument query = BsonDocument.parse("{ $push: { Products: " + "\"" + productName + "\"" + " } }");
        mongoCollection.updateOne(bsonDocument, query);
    }

    public void getStatistic(String collectionName) {
        AggregateIterable<Document> aggregates = mongoCollection.aggregate(Arrays.asList(
                Aggregates.lookup(collectionName, "Products", "Name", "Statistic"),
                Aggregates.unwind("$Statistic"),
                Aggregates.sort(new Document("Statistic.Price", -1)),
                Aggregates.group("$Name",
                        Accumulators.sum("Count", 1),
                        Accumulators.avg("AVGPrice", "$Statistic.Price"),
                        Accumulators.first("MostExpensive", "$Statistic.Name"),
                        Accumulators.last("Cheapest", "$Statistic.Name"))
        ));
        aggregates.forEach((Consumer<? super Document>) d -> {
            System.out.printf("""
                            Название магазина: %1$s
                            Колличество товара в магазине: %2$s
                            Средняя стоимость всех товаров: %3$s
                            Самый дешёвый товар: %4$s
                            Самый дорогой товар: %5$s
                            """,
                    d.get("_id"), d.get("Count"), d.get("AVGPrice"), d.get("Cheapest"), d.get("MostExpensive"));
            cheaperThanHundred((String) d.get("_id"));
            System.out.println();
        });
    }

    public void cheaperThanHundred(String id) {
        AggregateIterable<Document> aggregateIterable = mongoCollection.aggregate(Arrays.asList(
                Aggregates.lookup("Products", "Products", "Name", "CheaperThanHundred"),
                Aggregates.unwind("$CheaperThanHundred"),
                Aggregates.match(Filters.lt("CheaperThanHundred.Price", 100)),
                Aggregates.group("$Name",
                        Accumulators.push("CheaperThanHundred", "$CheaperThanHundred.Name"))
        ));
        for (Document document : aggregateIterable) {
            if (document.get("_id").equals(id))
                System.out.println("Товары дешевле 100р.: " + document.get("CheaperThanHundred"));
        }
    }

    public boolean isFind(String name) {
        boolean isFind = false;
        for (Document document : mongoCollection.find()) {
            String shop = document.get("Name").toString();
            if (shop.equals(name)) {
                isFind = true;
                break;
            }
        }
        return isFind;
    }


    public String getName() {
        return name;
    }

}

