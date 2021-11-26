package bsuir.webtech.lab4.persistence.html.content.bodies;

import bsuir.webtech.lab4.persistence.html.Content;

import java.util.ArrayList;
import java.util.List;

public class Body1 extends Content {

    private final Content header;
    private final Content main;

    public Body1(Content header , Content main) {
        this.header = header;
        this.main = main;
    }

    @Override
    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();

        styles.addAll(header.getStyles());
        styles.addAll(main.getStyles());

        return styles;
    }

    @Override
    public String get() {

        return "<body>" +
                "<header>" + header.get() + "</header>" +
                "<main>" + main.get() + "</main>" +
                "</body>";
    }
}
