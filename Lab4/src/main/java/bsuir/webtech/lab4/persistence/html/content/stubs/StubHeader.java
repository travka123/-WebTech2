package bsuir.webtech.lab4.persistence.html.content.stubs;

import bsuir.webtech.lab4.persistence.html.Content;

import java.util.Collections;
import java.util.List;

public class StubHeader extends Content {

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        return "Гостиница #1";
    }
}
