package bsuir.webtech.lab1.task13;

import bsuir.webtech.lab1.task12.Book;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    public ProgrammerBook(String author, String title, int edition, int price, String lang, int level) {
        super(author, title, edition, price);
        this.language = lang;
        this.level = level;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProgrammerBook programmerBook)) {
            return false;
        }
        if (!super.equals(programmerBook)) {
            return false;
        }

        return level == programmerBook.level && Objects.equals(language, programmerBook.language);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), language, level);
    }

    public String toString() {
        return String.format("%s language: %s level: %d", super.toString(), language, level);
    }
}
