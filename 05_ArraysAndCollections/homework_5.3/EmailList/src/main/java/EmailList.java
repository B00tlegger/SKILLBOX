import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
        emailList.add(email.replaceAll("^add" , "").toLowerCase(Locale.ROOT).trim());
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        ArrayList<String> emails = new ArrayList<>(emailList);
        System.out.println(emails);
        return emails;
    }

}
