package bsuir.webtech.lab1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("A: ");
        double a = scan.nextDouble();

        System.out.print("B: ");
        double b = scan.nextDouble();

        System.out.print("H: ");
        double h = scan.nextDouble();

        if ((b - a > 0) == (h > 0)) {
            printTable(a, b, h, Math::tan);
        } else {
            System.out.println("Неверно задан шаг.");
        }
    }

    private interface OneParamFunc {
        double func(double x);
    }

    private static void printTable(double a, double b, double h, OneParamFunc fo) {
        System.out.print("|       x       |     tg(x)     |\n");
        if (h > 0) {
            for (double x = a; x < b; x += h) {
                System.out.printf("|%15f|%15f|\n", x, fo.func(x));
            }
        } else {
            for (double x = a; x > b; x += h) {
                System.out.printf("|%15f|%15f|\n", x, fo.func(x));
            }
        }
        System.out.printf("|%15f|%15f|\n", b, fo.func(b));
    }
}
