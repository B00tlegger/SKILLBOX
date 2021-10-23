import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static EmailList emailList = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w{2,4}");
            Matcher matcher = pattern.matcher(input);
            if (input.equals("0")) {
                break;}
            //TODO: write code here

            String[] prefix = input.split("\\s+");

            if (matcher.find()){
                if (prefix[0].equalsIgnoreCase("add")){
                    emailList.add(input);
                }
            }else if (prefix[0].equalsIgnoreCase("list")){
                emailList.getSortedEmails();
            }else {
                System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
}
