import java.util.ArrayList;

public class TodoList {

    ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка

        todoList.add( todo.replaceAll("^add" , ""));
            System.out.println("Добавлено дело " + "\"" +  todo.replaceAll("add" , "").trim() + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления

        if (index < todoList.size() && index >= 0){
            String add = todo.replaceAll("^add [0-9] " , "");
            todoList.add(index , add);
            System.out.println("Добавлено дело " + "\"" + add + "\"");
        }else {
            todoList.add("new todo");
        }

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index < todoList.size() && index >= 0){
            String add = todo.replaceAll("^edit [0-9] " , "");
            todoList.set(index , add);
            System.out.println("дело № " + index + " заменено на " + "\"" + add + "\"");

        }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < todoList.size() && index >= 0){
            todoList.remove(index);
            System.out.println("дело № " + index + " удалено.");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0 ; i < todoList.size() ; i++){
            System.out.println(i + " - " + todoList.get(i).trim());
        }
        return todoList;
    }

}