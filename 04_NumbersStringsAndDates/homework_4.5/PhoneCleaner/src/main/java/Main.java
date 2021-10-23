import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      Pattern pattern = Pattern.compile("^((8|\\+7)?\\W*[0-9]{3}\\W*\\d{3}\\W?\\d{2}\\W?\\d{2})$");
      Matcher matcher = pattern.matcher(input);
      if (matcher.find()){
        input = "7" + input.replaceAll("[^0-9]" , "").replaceAll("^8|^7" , "");
        System.out.println(input);
      }else {
        System.out.println("Неверный формат номера");
      }
    }
  }
}