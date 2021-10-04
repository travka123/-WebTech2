package bsuir.webtech.lab1.task12;

import java.util.Objects;

public class Book implements Cloneable, Comparable<Book> {
    private long isbn;
    private int edition;

    private String title;

    public String getTitle() {
        return title;
    }

    private String author;

    public String getAuthor() {
        return author;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public Book(long isbn, String author, String title, int edition, int price) {
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

    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    @Override
    public int compareTo(Book o) {
        return Long.compare(isbn, isbn);
    }
}
