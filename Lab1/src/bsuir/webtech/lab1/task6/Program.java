package bsuir.webtech.lab1.task6;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        double[] mas = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[%d]: ", i);
            mas[i] = scan.nextDouble();
        }

        printMatrix(getMatrix(mas));
    }

    private static double[][] getMatrix(double[] mas) {
        int n = mas.length;
        double[][] mat = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0, k = i; k < n; j++, k++) {
                mat[i][j] = mas[k];
            }
            for (int j = n - i, k = 0; j < n; j++, k++) {
                mat[i][j] = mas[k];
            }
        }

        return mat;
    }

    private static void printMatrix(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%8.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }
}
