package bsuir.webtech.lab1.task1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("X: ");
        double x = scan.nextDouble();

        System.out.print("Y: ");
        double y = scan.nextDouble();

        System.out.printf("Result: %f", solve(x, y));
    }

    private static double solve(double x, double y) {
        return (1 + Math.pow(Math.sin(x + y), 2))
                / (2 + Math.abs(x - (2*x) / (1 + x * x * y * y)))
                + x;
    }
}
