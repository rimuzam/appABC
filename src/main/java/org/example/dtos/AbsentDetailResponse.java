package org.example.dtos;

public class AbsentDetailResponse {
    private String id, name, date, information;

    public AbsentDetailResponse() {
    }

    public AbsentDetailResponse(String id, String name, String date, String information) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.information = information;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
