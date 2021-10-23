import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        try {
            Document lenta = Jsoup.connect("https://lenta.ru/").get();
            Elements elements = lenta.select("img.g-picture");
            elements.forEach(element -> {
                Downloader.downloadFile(element.attr("abs:src"), "data\\" + Downloader.getFileName(element));
                System.out.println(Downloader.getFileName(element) + " - загрузка завершена");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}