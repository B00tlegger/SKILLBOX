import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "src/main/resources/scrFolder";
        String dstFolder = "src/main/resources/dstFolder";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        List<File[]> filesArray = getFilesArray(files, 4);

        for (File[] filesPart : filesArray) {
            ImageResizer imageResizer = new ImageResizer(filesPart, 300, dstFolder);
            imageResizer.start();
        }
    }

    public static List<File[]> getFilesArray(File[] files, int count) {
        int size = 0;
        int position = 0;
        List<File[]> filesArray = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            File[] filesPart = new File[(files.length - size) / (count - i)];
            filesArray.add(filesPart);
            size += filesPart.length;
        }
        for (int a = 0; a < filesArray.size(); a++) {
            System.arraycopy(files, position, filesArray.get(a), 0, filesArray.get(a).length);
            position += filesArray.get(a).length;
        }
        return filesArray;
    }
}
