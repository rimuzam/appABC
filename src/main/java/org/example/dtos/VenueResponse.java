package org.example.dtos;

import java.sql.Time;

public class VenueResponse {
    private String id, name, description;
    private Time open, close;
    private Long price;
    private String category;
    private String isActive;

    public VenueResponse(String id, String name, String description, Time open, Time close, Long price, String category, String isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.open = open;
        this.close = close;
        this.price = price;
        this.category = category;
        this.isActive = isActive;
    }
    public VenueResponse() {
    }

    public String isActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
