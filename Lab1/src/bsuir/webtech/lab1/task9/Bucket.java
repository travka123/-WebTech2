package bsuir.webtech.lab1.task9;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Bucket<T extends MaterialItem> {
    private ArrayList<T> items;

    public Bucket() {
        items = new ArrayList<T>();
    }

    public void put(T item) {
        items.add(item);
    }

    public double getWeight() {
        double weight = 0;
        for (T item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    public int getCountOf(Predicate<? super T> predicate) {
        int count = 0;
        for (T item : items) {
            if (predicate.test(item)) {
                count++;
            }
        }
        return count;
    }
}
