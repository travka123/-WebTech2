package bsuir.webtech.lab1.task8;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N: ");
        int n = scan.nextInt();

        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("A[%d]: ", i);
            a[i] = scan.nextDouble();
        }

        if (isAscendingSequence(a)) {

            System.out.println("Последовательность уже является возрастающей");

        } else {

            System.out.print("M: ");
            int m = scan.nextInt();

            double[] b = new double[m];
            for (int i = 0; i < m; i++) {
                System.out.printf("B[%d]: ", i);
                b[i] = scan.nextDouble();
            }

            double[] c = tryMakeAscendingSequence(a, b);

            if (isAscendingSequence(c)) {

                System.out.print("Возрастающая последовательность: ");
                for (int i = 0; i < c.length; i++) {
                    System.out.printf("%f ", c[i]);
                }
                System.out.println();

                System.out.print("Надо заменить элементы с индексами: ");
                for (int i = 0; i < c.length; i++) {
                    if (a[i] != c[i]) {
                        System.out.printf("%d ", i);
                    }
                }
                System.out.println();

            } else {

                System.out.println("Невозможно создать возрастающую последовательность");

            }
        }
    }

    private static boolean isAscendingSequence(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static double[] tryMakeAscendingSequence(double[] a, double[] b) {
        double[] c = new double[a.length];

        if (a.length == 0) {
            return c;
        }

        if (b.length == 0) {
            System.arraycopy(a, 0, c, 0, a.length);
            return c;
        }

        int bi = 0;

        c[0] = b[bi] < a[0] ? b[bi++] : a[0];

        int ai = 1;

        for (; (ai < a.length) && (bi < b.length); ai++) {
            while ((bi < b.length) && !(b[bi] > c[ai - 1])) {
                bi++;
            }
            if ((bi < b.length)) {
                c[ai] = (b[bi] < a[ai]) || (c[ai - 1] >= a[ai]) ? b[bi++] : a[ai];
            }
        }
        System.arraycopy(a, ai, c, ai, a.length - ai);

        return c;
    }
}
