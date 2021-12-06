package bsuir.webtech.lab4.business.Beans;

import java.io.Serializable;

public class Room implements Serializable {

    private int id;
    private boolean hidden;
    private String name;
    private String description;
    private String picture;
    private int price;
    private int bedsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public Room() {
    }

    public Room(int id, boolean hidden, String name, String description, String picture, int price, int bedsCount) {
        this.id = id;
        this.hidden = hidden;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.bedsCount = bedsCount;
    }
}
