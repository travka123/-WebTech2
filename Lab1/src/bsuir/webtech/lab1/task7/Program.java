package bsuir.webtech.lab1.task7;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        Double[] mas = new Double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[%d]: ", i);
            mas[i] = scan.nextDouble();
        }

        SortUtils.shellSort(mas, Double::compare);

        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%f ", mas[i]);
        }
        System.out.println();
    }


}
