package bsuir.webtech.lab1.task7;

import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        Integer[] mas = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[%d]: ", i);
            mas[i] = scan.nextInt();
        }

        shellSort(mas, (Integer x,Integer y) -> x - y);

        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%d ", mas[i]);
        }
        System.out.println();
    }

    private static <T> void shellSort(T[] mas, Comparator<T> comparator) {
        for (int step = mas.length / 2; step > 0; step /= 2) {
            for (int i = step; i < mas.length; i++) {
                for (int j = i - step; j >= 0 && comparator.compare(mas[j], mas[j + step]) > 0; j -= step) {
                    T x = mas[j];
                    mas[j] = mas[j + step];
                    mas[j + step] = x;
                }
            }
        }
    }
}
