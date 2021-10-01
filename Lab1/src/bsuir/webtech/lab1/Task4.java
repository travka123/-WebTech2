package bsuir.webtech.lab1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("%d: ", i + 1);
            mas[i] = scan.nextInt();
        }

        printPrimeNumbersIndices(mas);
    }

    private static void printPrimeNumbersIndices(int[] mas) {
        boolean primeNumberFound = false;
        int index = 0;

        for (; index < mas.length; index++) {
            if (isPrime(mas[index])) {
                primeNumberFound = true;
                break;
            }
        }

        if (primeNumberFound) {

            System.out.printf("Позиции простых чисел: %d", index + 1);
            for (index = index + 1; index < mas.length; index++) {
                if (isPrime(mas[index])) {
                    System.out.printf(", %d", index + 1);
                }
            }

        } else {
            System.out.println("Простые числа не найдены");
        }
    }

    private static boolean isPrime(int x) {
        int _maxDel = (int) Math.sqrt(x);
        for (int del = 2; del <= _maxDel; del++) {
            if (x % del == 0) {
                return false;
            }
        }
        return true;
    }
}
