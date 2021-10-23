import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBStorage {
    private static MongoDatabase database;

    public static void init(){
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        database = mongoClient.getDatabase("mongodb");
    }

    public static MongoDatabase getDatabase(){
        return database;
    }
}
