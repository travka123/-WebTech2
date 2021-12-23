package bsuir.webtech.lab2.business.products;

import java.util.Map;

public class TV extends Product {
    private double screenDiagonal;
    private String resolution;
    private int matrixFrequency;

    public TV() {
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getMatrixFrequency() {
        return matrixFrequency;
    }

    public void setMatrixFrequency(int matrixFrequency) {
        this.matrixFrequency = matrixFrequency;
    }

    public TV(String name, double price, int marketLaunchYear, String description, double screenDiagonal, String resolution, int matrixFrequency) {
        super(name, price, marketLaunchYear, description);
        this.screenDiagonal = screenDiagonal;
        this.resolution = resolution;
        this.matrixFrequency = matrixFrequency;
    }

    @Override
    public Map<String, String> getPropertiesText() {
        Map<String, String> map = super.getPropertiesText();
        map.put("Диагональ экрана", screenDiagonal + "\"");
        map.put("Разрешение", resolution);
        map.put("Частота матрицы", matrixFrequency + " Гц");
        return map;
    }
}
