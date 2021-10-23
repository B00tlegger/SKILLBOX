import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь к папке:");
        Scanner input = new Scanner(System.in);
        String sourceDirectory = input.nextLine();

        System.out.println("Введите путь для копирования:");
        String destinationDirectory = input.nextLine();

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);

    }
}