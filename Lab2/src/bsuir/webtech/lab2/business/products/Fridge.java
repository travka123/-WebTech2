package bsuir.webtech.lab2.business.products;

import java.util.Map;

public class Fridge extends Product {
    private int refrigeratingChamberVolume;
    private int freezerVolume;

    public Fridge(String name, double price, int marketLaunchYear, String description,
                  int refrigeratingChamberVolume, int freezerVolume) {
        super(name, price, marketLaunchYear, description);
        this.refrigeratingChamberVolume = refrigeratingChamberVolume;
        this.freezerVolume = freezerVolume;
    }

    public int getRefrigeratingChamberVolume() {
        return refrigeratingChamberVolume;
    }

    public void setRefrigeratingChamberVolume(int refrigeratingChamberVolume) {
        this.refrigeratingChamberVolume = refrigeratingChamberVolume;
    }

    public int getFreezerVolume() {
        return freezerVolume;
    }

    public void setFreezerVolume(int freezerVolume) {
        this.freezerVolume = freezerVolume;
    }

    public Map<String, String> getPropertiesText() {
        Map<String, String> map = super.getPropertiesText();
        map.put("Общий объём холодильной камеры", refrigeratingChamberVolume + " л.");
        map.put("Общий объём морозильной камеры", freezerVolume + " л.");
        return map;
    }
}
