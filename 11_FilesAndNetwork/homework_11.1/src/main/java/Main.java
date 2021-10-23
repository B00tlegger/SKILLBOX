import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double scale = Math.pow(10 , 2);
        while (true) {
            System.out.println("Введите путь до папки:");

            Scanner input = new Scanner(System.in);
            String path = input.nextLine();

            double folderLength;
            if (FileUtils.calculateFolderSize(path) > 1073741824){
                folderLength = Math.ceil(((double) FileUtils.calculateFolderSize(path) / (double) 1073741824 ) * scale) / scale;
                System.out.println(folderLength + " " + "Гб");
            }else if ((double) FileUtils.calculateFolderSize(path) > 1048576){
                folderLength = Math.ceil(((double) FileUtils.calculateFolderSize(path) / (double) 1048576 ) * scale) / scale;
                System.out.println(folderLength + " " + "Мб");
            }else if (FileUtils.calculateFolderSize(path) > 1024){
                folderLength = Math.ceil(((double) FileUtils.calculateFolderSize(path) / (double) 1024 ) * scale) / scale;
                System.out.println((double) FileUtils.calculateFolderSize(path) / (double) 1024 + " " + "Кб");
            }else {
            System.out.println(FileUtils.calculateFolderSize(path));
            }
        }
    }
}
