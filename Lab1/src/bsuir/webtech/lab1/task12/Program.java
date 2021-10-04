package bsuir.webtech.lab1.task12;

public class Program {
    public static void main(String[] args) {
        Book book1 = new Book("Skvorzov E. D.", "MyBook", 2, 10);

        Book book2;
        try {
            book2 = book1.clone();
        }
        catch (CloneNotSupportedException exception) {
            System.out.println(exception);
            return;
        }

        System.out.println(book1);
        System.out.println(book1.equals(book2));
    }

}
