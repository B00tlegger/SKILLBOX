import org.bson.BsonDocument;
import org.bson.Document;

import java.util.function.Consumer;

public class MongoDBTest {

    public static MyFileReader fileReader = new MyFileReader("E:\\SkillBox\\java_basics\\18_NoSQL\\MongoDBJava\\src\\main\\resources\\mongo.csv");

    public static void main(String[] args) {
        MongoDBStorage.init();
        MongoDBStorage.createCollection("students");
        MongoDBStorage.deleteAll();
        setStudents();
        System.out.println("Колличество студентов в базе " + MongoDBStorage.getMongoCollection().countDocuments());
        MongoDBStorage.getMongoCollection().find(MongoDBStorage.getQuery("Age" , 40)).forEach((Consumer<Document>) d -> {
            System.out.println(d);
        });
        MongoDBStorage.getMongoCollection().find().sort(MongoDBStorage.getQuery("{Age: 1}")).limit(1).forEach((Consumer<Document>) d -> {
            System.out.println(d.get("Name"));
        });
        MongoDBStorage.getMongoCollection().find().sort(MongoDBStorage.getQuery("{Age: -1}")).limit(1).forEach((Consumer<Document>)d -> {
            System.out.println(d.get("Courses"));
        } );
    }

    public static void setStudents() {
        for (int i = 0; i < fileReader.getAllLines().size(); i++) {
            MongoDBStorage.addStudent(new Student(fileReader.getLine(i)));
        }
    }
}
