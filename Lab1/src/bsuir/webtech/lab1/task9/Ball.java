package bsuir.webtech.lab1.task9;

import java.awt.Color;

public class Ball implements MaterialItem {
    private Color color;

    public Color getColor() {
        return color;
    }

    private double weight;

    public double getWeight() {
        return weight;
    }

    public Ball(Color color, double weight) {
        this.weight = weight;
        this.color = color;
    }
}
