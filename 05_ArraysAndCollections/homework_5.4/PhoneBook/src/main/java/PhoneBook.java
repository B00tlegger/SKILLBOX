import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    TreeMap<String , String> phoneBook = new TreeMap<>();
    TreeSet<String> allContacts = new TreeSet<>();

    public static Pattern telephoneNumber = Pattern.compile("[0-9]{11}");
    public static Pattern subscriberName = Pattern.compile("\\W+");



    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        Matcher telephone = telephoneNumber.matcher(phone);
        Matcher subscriber = subscriberName.matcher(name);

        if (telephone.find() && subscriber.find())
        {
            phoneBook.put(phone , name);
            System.out.println(name + " - " + phone + "\nКонтакт сохранен!");
        }
    }
    public boolean ContainsKey (String phone){
        return phoneBook.containsKey(phone);
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        StringBuffer contact = new StringBuffer();
            if (phoneBook.containsKey(phone)){
               contact.append(phoneBook.get(phone)).append(" - ").append(phone);
            }
            System.out.println(contact);
        return contact.toString();
    }

    public boolean ContainsValue (String name){
        return phoneBook.containsValue(name);
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry oneName : phoneBook.entrySet()){
            if (phoneBook.containsValue(name)){
                names.add(name + " - " + oneName.getKey());
                break;
            }
        }
        System.out.println(names);
        return names;
    }
    public void Contacts (Map<String , String> map){
        for (String contact : phoneBook.keySet()){
            allContacts.add(map.get(contact) + " - " + contact);
        }
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (!phoneBook.isEmpty()){
        Contacts(phoneBook);
        }
        System.out.println(allContacts);

        return allContacts;
    }

}