package bsuir.webtech.lab1.task9;

import java.awt.Color;

public class Program {
    public static void main(String[] args) {
        Bucket<Ball> bucket = new Bucket<Ball>();

        bucket.put(new Ball(Color.BLACK, 25));
        bucket.put(new Ball(Color.BLACK, 14.5));

        bucket.put(new Ball(Color.BLUE, 16.2));
        bucket.put(new Ball(Color.BLUE, 20.4));
        bucket.put(new Ball(Color.BLUE, 23.8));

        bucket.put(new Ball(Color.YELLOW, 21));

        System.out.printf("The weight of the balls in the basket: %.2f\n", bucket.getWeight());
        System.out.printf("Number of blue balls in the basket: %d\n",
                bucket.getCountOf((b) -> b.getColor() == Color.BLUE));
    }
}
