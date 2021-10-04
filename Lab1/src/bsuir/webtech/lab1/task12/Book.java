package bsuir.webtech.lab1.task12;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int price;
    private int edition;

    public Book(String author, String title, int edition, int price) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Book book)) {
            return false;
        }

        return Objects.equals(title, book.title) && Objects.equals(author, book.author) &&
                (price == book.price) && (edition == book.edition);
    }

    public int hashCode() {
        return Objects.hash(title, author, price, edition);
    }

    public String toString() {
        return String.format("%s %s %d edition price: %d$", author, title, edition, price);
    }
}
