package org.example.dtos;

import java.sql.Time;

public class BookedVenuesResponse {
    private String venueId, venueName, venueCategory, userEmail, dateBooked;
    private Time startTime, endTime;

    public BookedVenuesResponse() {
    }

    public BookedVenuesResponse(String venueId, String venueName, String venueCategory, String userEmail, String dateBooked, Time startTime, Time endTime) {
        this.venueName = venueName;
        this.venueCategory = venueCategory;
        this.userEmail = userEmail;
        this.dateBooked = dateBooked;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venueId = venueId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueCategory() {
        return venueCategory;
    }

    public void setVenueCategory(String venueCategory) {
        this.venueCategory = venueCategory;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
}
