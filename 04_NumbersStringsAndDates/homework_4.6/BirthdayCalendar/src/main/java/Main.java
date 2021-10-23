import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        StringBuilder birthdays = new StringBuilder();
        int number = 0;
        GregorianCalendar birthday = new GregorianCalendar(year , month - 1 , day);
        GregorianCalendar theseYear = new GregorianCalendar();
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy - E" , Locale.ENGLISH);

        for (int i = birthday.get(Calendar.YEAR) ; birthday.before(theseYear) ; i++){
            birthdays.append(number).append(" - ").append(formater.format(birthday.getTime())).append(System.lineSeparator());
            birthday.add(Calendar.YEAR , 1);
            number++;
        }
        System.out.println(birthdays.toString().trim());
        return birthdays.toString();
    }
}
