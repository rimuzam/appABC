package org.example.dtos;

import java.sql.Time;

public class BookingRequest {
    private String userId, venueId, dateBooked;
    private Time startTime, endTime;
    private long price;
    private String imageUrl;

    public BookingRequest() {
    }

    public BookingRequest(String userId, String venueId, String dateBooked, Time startTime, Time endTime, long price, String imageUrl) {
        this.userId = userId;
        this.venueId = venueId;
        this.dateBooked = dateBooked;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
