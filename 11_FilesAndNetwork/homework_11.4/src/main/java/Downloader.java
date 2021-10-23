import org.jsoup.nodes.Element;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class Downloader {

    public static String getFileName(Element element) {
        String[] fragments = element.attr("abs:src").split("/");
        return fragments[fragments.length - 1];
    }

    public static void downloadFile(String element, String file) {
        try {
            URL url = new URL(element);
            BufferedInputStream input = new BufferedInputStream(url.openStream());
            FileOutputStream output = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesReader;
            while ((bytesReader = input.read(buffer, 0, 1024)) != -1) {
                output.write(buffer, 0, bytesReader);
            }
            input.close();
            output.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }
}