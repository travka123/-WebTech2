package bsuir.webtech.lab1.task7;

import java.util.Comparator;

public class SortUtils {

    public static <T> void shellSort(T[] mas, Comparator<T> comparator) {
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
