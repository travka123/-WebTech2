package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;

public class Booking extends Content {
    private final int roomId;

    public Booking(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        return "<form method=\"post\">" +
                "Дата заезда:" +
                "<input type=\"date\" name=\"start\">" +
                "Дата выезда:" +
                "<input type=\"date\" name=\"end\">" +
                "<input type=\"hidden\" name=\"room\" value=\"" + roomId + "\">" +
                "<button id=\"form-btn\" type=\"submit\">Забронировать</button>" +
                "</form>";
    }
}
