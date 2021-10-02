package bsuir.webtech.lab1.task5;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[%d]: ", i);
            mas[i] = scan.nextInt();
        }

        boolean[] seq = SequenceAnalyzer.getLongestAscendingSequence(mas);

        boolean isFullSeq = true;
        System.out.print("Наибольшая возрастающая подпоследовательность: ");
        for (int i = 0; i < seq.length; i++) {
            if (seq[i]) {
                System.out.printf(" %d ", mas[i]);
            }
            else {
                isFullSeq = false;
            }
        }
        System.out.println();
        if (isFullSeq) {
            System.out.println("Последовательность уже является возрастающей");
        }
        else {
            System.out.print("Необходимо удалить элементы с индексами: ");
            for (int i = 0; i < seq.length; i++) {
                if (!seq[i]) {
                    System.out.printf(" %d ", i);
                }
            }
        }
    }
}
