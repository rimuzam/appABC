package org.example.models;

public class Item {
    private String id, name, unit;
    private int total;

    public Item(String id, String name, String unit, int total) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.total = total;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
