package bsuir.webtech.lab2.business.products;

import java.util.Map;

public class Kettle extends Product {
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMinimumWaterLevel() {
        return minimumWaterLevel;
    }

    public void setMinimumWaterLevel(double minimumWaterLevel) {
        this.minimumWaterLevel = minimumWaterLevel;
    }

    public double getPowerCordLength() {
        return powerCordLength;
    }

    public void setPowerCordLength(double powerCordLength) {
        this.powerCordLength = powerCordLength;
    }

    private double volume;
    private double minimumWaterLevel;
    private double powerCordLength;

    public Kettle() {

    }

    public Kettle(String name, double price, int marketLaunchYear, String description,
                  double volume, double minimumWaterLevel, double powerCordLength) {
        super(name, price, marketLaunchYear, description);
        this.volume = volume;
        this.minimumWaterLevel = minimumWaterLevel;
        this.powerCordLength = powerCordLength;
    }

    @Override
    public Map<String, String> getPropertiesText() {
        Map<String, String> map = super.getPropertiesText();
        map.put("Объем", volume + " л.");
        map.put("Минимальный уровень воды", minimumWaterLevel + " л.");
        map.put("Длина сетевого шнура", powerCordLength + " м.");
        return map;
    }
}
