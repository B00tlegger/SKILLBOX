import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

import static java.lang.System.nanoTime;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        CoolNumbers.generateCoolNumbers();
        HashSet<String> hashSet = new HashSet<>(CoolNumbers.coolNumbers);
        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.coolNumbers);

        String carNumber = CoolNumbers.coolNumbers.get(2000000);
        String wrongCarNumber = "У186КВ77";

        long startTrue = nanoTime();
        CoolNumbers.bruteForceSearchInList(CoolNumbers.coolNumbers, carNumber);
        long endTrue = nanoTime();
        long startFalls = nanoTime();
        CoolNumbers.binarySearchInList(CoolNumbers.coolNumbers , wrongCarNumber);
        long endFalls = nanoTime();
        System.out.println("Поиск перебором: номер найден/не найден, поиск занял " + (endTrue - startTrue) + "/" + (endFalls - startFalls) + " нс");

        Collections.sort(CoolNumbers.coolNumbers);
        startTrue = nanoTime();
        CoolNumbers.binarySearchInList(CoolNumbers.coolNumbers , carNumber);
        endTrue = nanoTime();
        startFalls = nanoTime();
        CoolNumbers.binarySearchInList(CoolNumbers.coolNumbers , wrongCarNumber);
        endFalls = nanoTime();
        System.out.println("Бинарный поиск: номер найден/не найден, поиск занял " + (endTrue - startTrue) + "/" + (endFalls - startFalls) + " нс");

        startTrue = nanoTime();
        CoolNumbers.searchInHashSet(hashSet , carNumber);
        endTrue = nanoTime();
        startFalls = nanoTime();
        CoolNumbers.searchInHashSet(hashSet , wrongCarNumber);
        endFalls = nanoTime();
        System.out.println("Поиск в HashSet: номер найден/не найден, поиск занял " + (endTrue - startTrue) + "/" + (endFalls - startFalls) + " нс");

        startTrue = nanoTime();
        CoolNumbers.searchInTreeSet(treeSet , carNumber);
        endTrue = nanoTime();
        startFalls = nanoTime();
        CoolNumbers.searchInTreeSet(treeSet , wrongCarNumber);
        endFalls = nanoTime();
        System.out.println("Поиск в TreeSet: номер найден/не найден, поиск занял " + (endTrue - startTrue) + "/" + (endFalls - startFalls) + " нс");

    }
}
