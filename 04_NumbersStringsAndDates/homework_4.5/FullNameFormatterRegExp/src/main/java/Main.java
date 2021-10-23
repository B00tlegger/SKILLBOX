import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String[] fio = input.replaceAll("[0-9]" , "").split(" ");
      if (fio.length != 3) {
        System.out.println("Введенная строка не является ФИО");
      }else {
        System.out.println("Фамилия: " + fio[0].trim());
        System.out.println("Имя: " + fio[1].trim());
        System.out.println("Отчество: " + fio[2].trim());
      }
    }
  }
}