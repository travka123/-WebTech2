package bsuir.webtech.lab1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("X: ");
        double x = scan.nextDouble();

        System.out.print("Y: ");
        double y = scan.nextDouble();

        System.out.printf("Result: %b", solve(x, y));
    }

    private static boolean solve(double x, double y) {
        if ((y <= 5) && (y >= -3) &&
                (
                        ((x >= -4) && (x <= 4)) ||
                        ((y <= 0) && (x >= -6) && (x <= 6))
                )
        ) {
            return true;
        }
        return false;
    }
}
