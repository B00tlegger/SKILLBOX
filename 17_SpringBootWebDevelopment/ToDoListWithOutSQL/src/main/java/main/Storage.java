package main;

import ResponsObjects.ToDo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Storage {
    private volatile static ConcurrentMap<Integer, ToDo> things = new ConcurrentHashMap<>();

    public static Map<Integer, ToDo> getAllThings() {
        return things;
    }

    public static int addToDo(ToDo toDo) {
        int id = things.size() + 1;
        for (int i = 1; i < things.size(); i++) {
            if (!things.containsKey(i)) {
                id = i;
                break;
            }
        }
        toDo.setId(id);
        things.put(id, toDo);
        return id;
    }

    public static ToDo getToDo(int id) {
        return things.get(id);
    }

    public static void deleteToDo(int id) {
        things.remove(id);
    }

    public static void setToDo(int id, ToDo toDo) {
        toDo.setId(id);
        things.put(id, toDo);
    }
}
