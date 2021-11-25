package bsuir.webtech.lab4.persistence.html.pages;

import java.util.ArrayList;
import java.util.List;

public abstract class Body {
    private final List<String> styles = new ArrayList<>();

    protected void addStyle(String style) {
        styles.add(style);
    }

    public Iterable<String> getStyles() {
        return new ArrayList<>(styles);
    }

    protected abstract String getContent();

    public String get() {
        return "<body>" + getContent() + "</body>";
    }
}
