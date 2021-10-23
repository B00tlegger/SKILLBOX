import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws PhoneFormatException, EmailFormatException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        Pattern phone = Pattern.compile("^\\+7[0-9]{10}$");
        Matcher phoneMatcher = phone.matcher(components[INDEX_PHONE]);
        Pattern email = Pattern.compile("^\\w+.*@\\w+\\.\\w{2,}$");
        Matcher emailMatcher = email.matcher(components[INDEX_EMAIL]);



        if (components.length!= 4){
            throw new IllegalArgumentException("INCORRECT INPUT FORMAT!\nCorrect format: add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!phoneMatcher.find()){
            throw new PhoneFormatException("INCORRECT PHONE FORMAT!\nCorrect format: +79215637722");
        }
        if (!emailMatcher.find()){
            throw new EmailFormatException("INCORRECT EMAIL FORMAT!\nCorrect format: vasily.petrov@gmail.com");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}