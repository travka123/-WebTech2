package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;

public class NotFound extends Content {
    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        return "<h2 style=\"color:red;\">404 Страница не найдена</h2>";
    }
}
