import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Movements {

    private List<List<String>> strings;


    public Movements(String pathMovementsCsv) {
        fileParser(pathMovementsCsv);
    }

    private void fileParser(String pathMovementsCsv) {
        strings = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(pathMovementsCsv));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String string : lines) {
            String[] fragments = string.split(",");
            if (fragments[7].contains("\"") && fragments[8].contains("\"")) {
                fragments[7] = fragments[7].replace("\"", "") + "." + fragments[8].replace("\"", "");
                ArrayList<String> line = new ArrayList<>(Arrays.asList(fragments));
                line.remove(8);
                strings.add(line);
            } else if (fragments[6].contains("\"") && fragments[7].contains("\"")) {
                fragments[6] = fragments[6].replace("\"", "") + "." + fragments[7].replace("\"", "");
                ArrayList<String> line = new ArrayList<>(Arrays.asList(fragments));
                line.remove(7);
                strings.add(line);
            } else {
                strings.add(Arrays.asList(fragments));
            }
        }
        strings.remove(0);
    }

    private String getOperationName(List<String> string) {
        String[] fragments = string.get(5).replace("\\", "/").split("/");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < fragments.length; i++) {
            builder.append(fragments[i]).append(" ");
        }
        builder.replace(builder.indexOf("  "), builder.length() - 1, "");
        return builder.toString();

    }

    public void getReport() {
        Set<String> report = new TreeSet<>();
        for (List<String> string1 : strings) {
            double expense = 0;
            getOperationName(string1);
            for (List<String> string2 : strings) {
                if (getOperationName(string1).equals(getOperationName(string2))) {
                    expense += Double.parseDouble(string2.get(7));
                } else {
                    continue;
                }
            }
            report.add(getOperationName(string1) + " " + expense);
        }
        report.toArray();
        report.forEach(System.out::println);
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (List<String> string : strings) {
            expenseSum += Double.parseDouble(string.get(7));
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (List<String> string : strings) {
            incomeSum += Double.parseDouble(string.get(6));
        }
        return incomeSum;
    }
}
