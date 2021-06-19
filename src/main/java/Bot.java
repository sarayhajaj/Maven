import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Bot {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://www.mako.co.il/").get();
            Elements elements = document.getElementsByClass("headline");
            System.out.println("Total elements found: " + elements.size());
            for (Element element : elements) {
                Element container = element.parent().parent();
                if (container.attr("class").equals("small")) {
                    System.out.println(element.text());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}