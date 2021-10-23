import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

public class SiteMapGenerator extends RecursiveTask<String> {

    private String url;
    private static String urlStart;
    private static CopyOnWriteArraySet<String> allLinks = new CopyOnWriteArraySet<>();

    public SiteMapGenerator(String url) {
        this.url = url;
    }

    public SiteMapGenerator(String urlStart, String url) {
        this.url = url.trim();
        SiteMapGenerator.urlStart = urlStart.trim();
    }

    @Override
    protected String compute() {
        StringBuilder stringBuilder = new StringBuilder(url + "\n");
        Set<SiteMapGenerator> tasks = new HashSet<>();

        getChildren(tasks);

        String[] previousTaskLinkParts = new String[3];

        for (SiteMapGenerator link : tasks) {
            String[] linkParts = link.url.split("/");
            int length = linkParts.length - previousTaskLinkParts.length;
            stringBuilder.append("\t".repeat(Math.max(0, length)));
            stringBuilder.append(link.join());
        }
        return stringBuilder.toString();
    }

    private void getChildren(Set<SiteMapGenerator> tasks) {
        Document document;
        Elements elements;
        try {
            Thread.sleep(150);
            document = Jsoup.connect(url).maxBodySize(0).get();
            elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String linkUrl = element.attr("abs:href").trim();
                if (!linkUrl.isEmpty() && !allLinks.contains(linkUrl) && !linkUrl.contains("#") && linkUrl.startsWith(urlStart)) {
                    SiteMapGenerator siteMapGenerator = new SiteMapGenerator(linkUrl);
                    siteMapGenerator.fork();
                    tasks.add(siteMapGenerator);
                    System.out.println(linkUrl);
                    allLinks.add(linkUrl);
                }
            }
        } catch (Exception ignored) {
        }
    }
}
