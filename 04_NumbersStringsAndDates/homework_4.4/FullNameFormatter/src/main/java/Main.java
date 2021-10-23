import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      int spaceCount = -1;
      boolean isTheseRus = false;
      String alphabetRus = "абвгдеёжзиклмнопрстуфхчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ";

      for (int i = 0 ; i < input.length() ; i++){
        char index = input.charAt(i);
        char space = ' ';
        if ((int) index == (int) space ){
          spaceCount++;
        }
        for (int rus = 0; rus < alphabetRus.length(); rus++) {
          char charRus = alphabetRus.charAt(rus);
          if ((int) charRus == (int) index) {
            isTheseRus = true;
            break;
          }
        }
      }

      if (!isTheseRus){
        System.out.println("Введенная строка не является ФИО");
      } else if (spaceCount != 1){
        System.out.println("Введенная строка не является ФИО");
      }else {
        String surname = input.substring(0 , input.indexOf(" "));
        String name = input.substring(input.indexOf(" ") , input.lastIndexOf(" "));
        String patronymic = input.substring(input.lastIndexOf(" "));

        System.out.println("Фамилия: " + surname.trim());
        System.out.println("Имя: " + name.trim());
        System.out.println("Отчество: " + patronymic.trim());
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }
}