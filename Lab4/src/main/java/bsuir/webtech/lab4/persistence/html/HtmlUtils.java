package bsuir.webtech.lab4.persistence.html;

import java.util.List;

public class HtmlUtils {
    public static String createLink(String href, String text) {
        return "<a href=\"" + href + "\">" + text + "</a>";
    }

    public static String createList(List<String> items) {
        StringBuilder list = new StringBuilder("<ul>");

        for (String item : items) {
            list.append("<li>").append(item).append("</li>");
        }

        list.append("</ul>");
        return list.toString();
    }
}
