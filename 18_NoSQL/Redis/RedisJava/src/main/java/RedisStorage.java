import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Date;

public class RedisStorage {
    private RedissonClient redis;
    private RKeys keys;
    private RScoredSortedSet<String> users;
    private static final String KEY = "USERS";

    private double getLastTime(){
        return new Date().getTime();
    }

    public void listKeys(){
        Iterable<String> allKeys = keys.getKeys();
        for (String key : allKeys){
            System.out.println("Ключ: " + key + " Значение: " + keys.getType(key));
        }
    }

    void init(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379//");
        try {
            redis = Redisson.create(config);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        keys = redis.getKeys();
        users = redis.getScoredSortedSet(KEY);
        keys.delete(KEY);
    }

    void shutDown(){
        redis.shutdown();
    }

    void addUser(int userId){
        users.add(getLastTime(), String.valueOf(userId));
    }

    void resetUsers(String userId){
        users.add(getLastTime(), String.valueOf(userId));
    }

    void userPay(String userId){
        users.add(0 , userId);
    }

    public String getFirstUser(){
        return users.first();
    }
}
