import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        searchAndReplaceDiamonds(text , text);

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        placeholder = "***";
        if (text.indexOf(">") == text.length() - 1){
            placeholder = "+++";
        }
        text = text.replaceAll("<[0-9 ]{1,}>" , placeholder);

        return text;
    }

}