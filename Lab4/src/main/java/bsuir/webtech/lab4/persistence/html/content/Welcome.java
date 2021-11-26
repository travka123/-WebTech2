package bsuir.webtech.lab4.persistence.html.content;

import bsuir.webtech.lab4.persistence.html.Content;

import java.util.Collections;
import java.util.List;

public class Welcome extends Content {
    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        StringBuilder content = new StringBuilder("<div>");

        content.append("<div>");
        content.append("На протяжении многих лет гостиница «Гостиница #1» является символом Минска и одним из самых узнаваемых архитектурных объектов белорусской столицы." +
                "Гостиница «Гостиница #1», будучи визитной карточкой Минска, на протяжении многих лет сохраняет статус лучшей гостиницы столицы." +
                "Удобное расположение в центре Минска, гармония стиля и комфорта, большой спектр услуг, способность принять и разместить большое количество гостей делает гостиницу «Гостиница #1» популярным местом временного проживания как для бизнесменов, так и для туристов.");
        content.append("</div>");

        content.append("<div>");
        content.append("</div>");

        content.append("</div>");
        return content.toString();
    }
}
