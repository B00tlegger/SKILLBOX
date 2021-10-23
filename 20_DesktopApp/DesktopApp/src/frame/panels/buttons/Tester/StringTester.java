package frame.panels.buttons.Tester;

import frame.panels.FIOPanel;
import frame.panels.FullFIOPanel;

import java.util.ArrayList;
import java.util.List;

public class StringTester {
    public static String testStrings(FullFIOPanel fullFIOPanel) {
        StringBuilder builder = new StringBuilder();
        List<String> availableStrings = new ArrayList<>();
        String[] strings = new String[]{
                fullFIOPanel.getSurname().getText(),
                fullFIOPanel.getNameInField().getText(),
                fullFIOPanel.getPatronymic().getText()
        };

        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals(""))
                availableStrings.add(strings[i] + (i < strings.length - 1 ? " " : ""));
        }
        if (availableStrings.size() > 1) {
            availableStrings.forEach(builder::append);
        } else {
            return null;
        }
        return builder.toString();
    }

    public static List<String> testString(FIOPanel fioPanel) {
        String fio = fioPanel.getFIO().getText().trim();
        List<String> availableStrings = new ArrayList<>();
        String[] strings = fio.split(" ");
        for(String s : strings){
            if (!s.equals("")){
                availableStrings.add(s);
            }
        }
        return availableStrings;
    }
}
