import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        System.out.println("выбирите команду:\n\t\tLIST — выводит дела с их порядковыми номерами;\n\t\tADD — добавляет " +
                "дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;\n\t\t" +
                "EDIT — заменяет дело с указанным номером;\n\t\tDELETE — удаляет;\n\t\tEXIT — выход");
        while (true){
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z]*\\s-?[0-9]*\\s.*$");
            Matcher matcher = pattern.matcher(input);
            String[] sp = input.split(" +");
            if (matcher.find()){
                int index = Integer.parseInt(input.replaceAll("[^0-9]", "").trim());
                if (sp[0].equalsIgnoreCase("add")){
                    todoList.add(index , input);
                }
                if (sp[0].equalsIgnoreCase("edit")){
                    todoList.edit(input , index);
                }
                if (sp[0].equalsIgnoreCase("delete")){
                    todoList.delete(index);
                }
            }else {
                if (sp[0].equalsIgnoreCase("EXIT")) {
                    break;
                }
                if (sp[0].equalsIgnoreCase("LIST")) {
                    System.out.println(todoList.getTodos());
                }
                if (sp[0].equalsIgnoreCase("ADD")) {
                    todoList.add(input);
                }
            }
        }
    }
}
