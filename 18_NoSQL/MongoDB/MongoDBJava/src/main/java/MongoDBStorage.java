import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

public class MongoDBStorage {

    private static MongoCollection<Document> mongoCollection;
    private static MongoDatabase database;

    public static void init() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        database = mongoClient.getDatabase("mongodb");
    }

    public static void createCollection(String collectionName) {
        mongoCollection = database.getCollection(collectionName);
    }

    public static void deleteAll() {
        mongoCollection.drop();
    }

    public static void addStudent(Student student) {
        Document newStudent = new Document();
        newStudent.append("Name", student.getName());
        newStudent.append("Age", student.getAge());
        newStudent.append("Courses", student.getCourses());
        mongoCollection.insertOne(newStudent);
    }

    public static MongoCollection<Document> getMongoCollection() {
        return mongoCollection;
    }

    public static BsonDocument getQuery(String key, int value) {
        String json = "{" + key + ": {$gt: " + value + "}}";
        BsonDocument query = BsonDocument.parse(json);
        return query;
    }

    public static BsonDocument getQuery(String key) {
        BsonDocument query = BsonDocument.parse(key);
        return query;
    }
}

