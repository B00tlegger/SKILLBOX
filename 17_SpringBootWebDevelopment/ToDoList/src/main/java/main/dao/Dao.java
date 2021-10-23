package main.dao;
import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    int add(T t);
    T get(int id);
    void delete(int id);
    void deleteAll();
    T put(T t);
}
