package bsuir.webtech.lab1.task15;

import bsuir.webtech.lab1.task12.Book;
import bsuir.webtech.lab1.task13.ProgrammerBook;
import bsuir.webtech.lab1.task7.SortUtils;

import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        Comparator<Book> titleComp = Comparator.comparing(Book::getTitle);
        Comparator<Book> authorComp = Comparator.comparing(Book::getAuthor);

        Comparator<Book> titleAuthorComp = titleComp.thenComparing(authorComp);
        Comparator<Book> authorTitleComp = authorComp.thenComparing(titleComp);

        Comparator<Book> authorTitlePriceComp = authorTitleComp.thenComparingInt(Book::getPrice);

        Book[] arr = new Book[] {
                new Book(123,"Skvorzov E. D.", "MyBook", 1, 25),
                new Book(123,"Skvorzov E. D.", "MyBook4", 1, 25),
                new Book(123,"Skvorzov E. D.", "MyBook", 1, 10),
                new ProgrammerBook(125,"Vlasov K. A.", "AI", 3, 16, "rus", 3),
                new ProgrammerBook(125,"Vlasov K. A.", "AI", 2, 10, "rus", 3),
                new ProgrammerBook(177,"Olifer D. P.", "AI", 3, 10, "en", 3),
        };

        System.out.println("Title sort:");
        SortUtils.shellSort(arr, titleComp);
        printBookArr(arr);

        System.out.println("Author sort:");
        SortUtils.shellSort(arr, authorComp);
        printBookArr(arr);

        System.out.println("Title author sort:");
        SortUtils.shellSort(arr, titleAuthorComp);
        printBookArr(arr);

        System.out.println("Author title sort:");
        SortUtils.shellSort(arr, authorTitleComp);
        printBookArr(arr);

        System.out.println("Author title price sort:");
        SortUtils.shellSort(arr, authorTitlePriceComp);
        printBookArr(arr);
    }

    private static void printBookArr(Book[] arr) {
        for (Book book: arr) {
            System.out.println(book);
        }
        System.out.println();
    }
}
