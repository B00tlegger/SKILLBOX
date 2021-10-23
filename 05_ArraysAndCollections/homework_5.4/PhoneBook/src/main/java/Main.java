import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            Pattern telephoneNumber = Pattern.compile("[0-9]{11}");
            Matcher telephone = telephoneNumber.matcher(input);
            Pattern subscriberName = Pattern.compile("[\\W]+");
            Matcher subscriber = subscriberName.matcher(input);

            if (input.equalsIgnoreCase("list")){
                phoneBook.getAllContacts();
                continue;
            }

            if (telephone.find()){
                if (phoneBook.ContainsKey(input)){
                    phoneBook.getNameByPhone(input);
                }else {
                    System.out.println("Такого номера нет в телефонной книге.\nВведите имя абонента для номера " + "\"" + input + "\"");
                    String name = scanner.nextLine();
                    phoneBook.addContact(input , name);
                }
            }

            if (subscriber.find()){
                if (phoneBook.ContainsValue(input)){
                phoneBook.getPhonesByName(input);
                }else {
                    System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента " + "\"" + input + "\"");
                    String phone = scanner.nextLine();
                    telephone = telephoneNumber.matcher(phone);
                    if (telephone.find()){
                    phoneBook.addContact(phone , input);
                    }else {
                        System.out.println("Неверный формат ввода");
                    }
                }
            }
        }
    }
}
