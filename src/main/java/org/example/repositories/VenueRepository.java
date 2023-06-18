package org.example.repositories;

import org.example.models.Venue;

import java.util.List;

public interface VenueRepository {
    Venue createVenue(Venue venue);
    List<Venue> findAllVenue();
    boolean updateVenue(Venue venue);
    Venue findVenueById(String venueId);
    List<Venue> findVenueByCategory(String categorySearch);
    List<Venue> findAllVenueWhereActive();
    Venue findVenueByName(String venueName);
}
