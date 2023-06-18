package org.example.controllers;

import org.example.dtos.VenueResponse;
import org.example.models.Venue;
import org.example.services.VenueService;

import java.util.List;

public class VenueController {
    private VenueService service;
    public VenueController(VenueService service) {
        this.service = service;
    }

    public Venue createVenue(Venue venue) {
        return service.createVenue(venue);
    }
    public boolean updateVenue(Venue venue){
        return service.updateVenue(venue);
    }
    public List<VenueResponse> findAllVenues(){
        return service.findAllVenues();
    }
    public List<VenueResponse> findVenuesWhereActive() {
        return service.findVenuesWhereActive();
    }
    public List<VenueResponse> findVenueByCategory(String category){
        return service.findVenueByCategory(category);
    }
    public List<String> findListTime(String venueName){
        return service.findListTime(venueName);
    }

    public List<String> findRandomTime(){
        return service.findRandomTime();
    }

    public Venue findVenueById(String id){
        return service.findVenueId(id);
    }

    public Venue findVenueByName(String name){
        return service.findVenueByName(name);
    }
}
