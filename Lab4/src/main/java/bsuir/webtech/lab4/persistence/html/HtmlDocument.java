package bsuir.webtech.lab4.persistence.html;

public class HtmlDocument {
    public String get(String content) {
        return "<!DOCTYPE html><html>" + content + "</html>";
    }
}
