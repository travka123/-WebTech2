package bsuir.webtech.lab1.task13;

import bsuir.webtech.lab1.task12.Book;

public class Program {
    public static void main(String[] args) {
        Book book1 = new ProgrammerBook(123,"Vlasov K. A.",
                "AI", 2, 10, "rus", 3);
        Book book2 = new ProgrammerBook(124,"Vlasov K. A.",
                "AI", 2, 10, "en", 3);

        System.out.println(book1);
        System.out.println(book1.equals(book2));
    }
}
