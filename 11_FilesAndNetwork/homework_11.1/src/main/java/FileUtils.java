

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long length = 0;

        File folder = new File(path);
        File[] files = folder.listFiles();
        List<File> directorys = new ArrayList<>();

        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    directorys.add(file);
                } else {
                    length += file.length();
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if (directorys.size() > 0) {
            for (int i = 0; i < directorys.size(); i++) {
                File[] files1 = directorys.get(i).listFiles();
                for (File file1 : files1) {
                    if (file1.isDirectory()) {
                        directorys.add(file1);
                    }
                    length += file1.length();
                }
            }
        }

        return length;
    }
}
