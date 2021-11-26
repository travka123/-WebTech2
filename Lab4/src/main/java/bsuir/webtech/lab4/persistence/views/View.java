package bsuir.webtech.lab4.persistence.views;

import bsuir.webtech.lab4.persistence.html.Content;
import bsuir.webtech.lab4.persistence.html.Head;
import bsuir.webtech.lab4.persistence.html.HtmlDocument;
import bsuir.webtech.lab4.persistence.html.content.bodies.Body1;

public class View {

    private static final HtmlDocument htmlDocument = new HtmlDocument();
    private static final Head head = new Head();
    private static final String encoding = "UTF-8";

    public String get(Content header, Content main) {
        Content body = new Body1(header, main);
        return htmlDocument.get(head.get(encoding, body.getStyles()) + body.get());
    }
}
