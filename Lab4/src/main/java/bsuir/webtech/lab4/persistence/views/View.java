package bsuir.webtech.lab4.persistence.views;

import bsuir.webtech.lab4.persistence.html.pages.Body;
import bsuir.webtech.lab4.persistence.html.Head;
import bsuir.webtech.lab4.persistence.html.HtmlDocument;

public class View {

    private static final HtmlDocument htmlDocument = new HtmlDocument();
    private static final Head head = new Head();
    private static final String encoding = "UTF-8";

    public String get(Body body) {
        return htmlDocument.get(head.get(encoding, body.getStyles()) + body.get());
    }
}
