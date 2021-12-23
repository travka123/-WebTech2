package bsuir.webtech.lab3.client.presentation;

import java.util.Scanner;

public class UserIO {
    public void print(String text) {
        System.out.print(text);
    }

    public void printError() {
        System.out.print("Неверный ввод.\n");
    }

    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\n: ");
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException exception) {
                printError();
            }
        }
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n: ");
        return scanner.nextLine();
    }

    public char getChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите символ: ");
        String input = scanner.nextLine();
        while (input.length() != 1) {
            printError();
            System.out.print("\nВведите символ: ");
            input = scanner.nextLine();
        }
        return input.charAt(0);
    }

    public int getIntInBoundaries(int lower, int upper) {
        int res = getInt();
        while ((res < lower) || (res > upper)) {
            printError();
            res = getInt();
        }
        return res;
    }
}
