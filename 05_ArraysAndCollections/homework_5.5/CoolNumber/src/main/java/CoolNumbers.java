import java.util.*;

public  class CoolNumbers {
    public static ArrayList<String> coolNumbers = new ArrayList<>();


    public static List<String> generateCoolNumbers() {
        String[]words = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
            while (coolNumbers.size() <= 2000000){
                StringBuilder carNumber = new StringBuilder();
                String number = Double.toString(Math.random()).substring(2 , 3);
                String region = Double.toString(Math.random()).substring(2 , 4);
                carNumber.append(words[(int) Math.round((words.length-1) * Math.random())]).
                        append(number).append(number).append(number).append(words[(int) Math.round((words.length-1) * Math.random())]).
                        append(words[(int) Math.round((words.length-1) * Math.random())]).append(region);
                coolNumbers.add(carNumber.toString());
            }

        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList , number);
        return index >=0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
