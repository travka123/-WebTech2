package bsuir.webtech.lab2.business.products;

import java.util.Map;

public class CoffeeMachine extends Product {
    private double waterTank;
    private int coffeeCompartment;
    private boolean remoteControl;

    public double getWaterTank() {
        return waterTank;
    }

    public void setWaterTank(double waterTank) {
        this.waterTank = waterTank;
    }

    public int getCoffeeCompartment() {
        return coffeeCompartment;
    }

    public void setCoffeeCompartment(int coffeeCompartment) {
        this.coffeeCompartment = coffeeCompartment;
    }

    public boolean isRemoteControl() {
        return remoteControl;
    }

    public void setRemoteControl(boolean remoteControl) {
        this.remoteControl = remoteControl;
    }

    public CoffeeMachine() {

    }

    public CoffeeMachine(String name, double price, int marketLaunchYear, String description,
                         double waterTank, int coffeeCompartment, boolean remoteControl) {
        super(name, price, marketLaunchYear, description);
        this.waterTank = waterTank;
        this.coffeeCompartment = coffeeCompartment;
        this.remoteControl = remoteControl;
    }

    @Override
    public Map<String, String> getPropertiesText() {
        Map<String, String> map = super.getPropertiesText();
        map.put("Емкость для воды", String.format("%.1f л.", waterTank));
        map.put("Отсек для кофе", coffeeCompartment + " г.");
        map.put("Удаленное управление", remoteControl ? "есть" : "нет");
        return map;
    }
}
