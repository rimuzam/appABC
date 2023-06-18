package org.example.dtos;

public class BookingDetail {
    private String bookedId;
    private String venueId;
    private String venueName;
    private String category;
    private String emailUser;
    private String dateOrder;
    private String dateBooked;
    private String startTime;
    private String endTime;
    private String imageUrl;
    private String phoneNumber;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private Boolean isConfirmed;
    private Long price;
    public BookingDetail() {
    }

    public BookingDetail(String bookedId, String venueId, String venueName, String category, String emailUser, String dateOrder, String dateBooked, String startTime, String endTime, Boolean isConfirmed, String imageUrl) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.category = category;
        this.emailUser = emailUser;
        this.dateBooked = dateBooked;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOrder = dateOrder;
        this.isConfirmed = isConfirmed;
        this.imageUrl = imageUrl;
        this.bookedId = bookedId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getBookedId() {
        return bookedId;
    }

    public void setBookedId(String bookedId) {
        this.bookedId = bookedId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
