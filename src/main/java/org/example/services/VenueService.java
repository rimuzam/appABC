package org.example.services;

import org.example.dtos.VenueResponse;
import org.example.models.Venue;

import java.util.List;

public interface VenueService {
    Venue createVenue(Venue venue);
    boolean updateVenue(Venue venue);
    List<VenueResponse> findAllVenues();
    List<VenueResponse> findVenueByCategory(String category);
    List<VenueResponse> findVenuesWhereActive();
    Venue findVenueId(String venueId);
    List<String> findListTime(String id);
    Venue findVenueByName(String venueName);
    List<String> findRandomTime();
}
