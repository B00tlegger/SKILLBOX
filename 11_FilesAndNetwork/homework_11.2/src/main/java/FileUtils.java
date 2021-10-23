import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        Path path1 = Path.of(sourceDirectory);

        ArrayList<Path> pathList = new ArrayList<>();

        pathList.add(path1);

        for (int i = 0; i < pathList.size(); i++) {
            if (Files.isDirectory(pathList.get(i))) {
                DirectoryStream<Path> directorys = Files.newDirectoryStream(pathList.get(i));
                for (Path p : directorys) {
                    pathList.add(p);
                }
                directorys.close();
            }
        }
        pathList.forEach(path -> {
            try {
                Files.copy(path, Path.of(destinationDirectory + "/" + path1.relativize(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}