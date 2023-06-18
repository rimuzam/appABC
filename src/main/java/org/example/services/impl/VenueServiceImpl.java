package org.example.services.impl;

import org.example.dtos.VenueResponse;
import org.example.exceptions.WarningException;
import org.example.models.Venue;
import org.example.repositories.VenueRepository;
import org.example.services.VenueService;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VenueServiceImpl implements VenueService {
    private VenueRepository repository;
    public VenueServiceImpl(VenueRepository repository){
        this.repository = repository;
    }

    public Venue findVenueId(String venueId){
        return repository.findVenueById(venueId);
    }
    public Venue createVenue(Venue venue){
        Venue findId = repository.findVenueById(venue.getId());
        if(findId != null)throw new WarningException("Gagal membuat lapangan, kode lapangan sudah ada!");
        if (findVenueByName(venue.getName()) != null)throw new WarningException("Gagal membuat lapangan, nama lapangan sudah tersedia");
        return repository.createVenue(venue);
    }

    public boolean updateVenue(Venue venue){
        Venue findId = repository.findVenueById(venue.getId());
        if(findId == null)throw new WarningException("Gagal memperbarui Lapangan, kode lapangan tidak ditemukan");
        return repository.updateVenue(venue);
    }

    public List<VenueResponse> findAllVenues() {
        List<Venue> venues = repository.findAllVenue();
        List<VenueResponse> result = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();
            String name = venue.getName();
            String description = venue.getDescription();
            Time open = venue.getOpen();
            Time close = venue.getClose();
            long price = venue.getPrice();
            String category = venue.getCategory();
            String status = (venue.isActive() ? "Aktif" : "Tidak Aktif");
            result.add(new VenueResponse(id, name, description, open, close, price, category, status));
        }
        return result;
    }

    public List<VenueResponse> findVenueByCategory(String category){
        List<Venue> venues = repository.findVenueByCategory(category);
        List<VenueResponse> result = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();
            String name = venue.getName();
            String description = venue.getDescription();
            Time open = venue.getOpen();
            Time close = venue.getClose();
            long price = venue.getPrice();
            String categoryy = venue.getCategory();
            String status = (venue.isActive() ? "Buka" : "Tutup");
            result.add(new VenueResponse(id, name, description, open, close, price, categoryy, status));
        }
        return result;
    }

    public List<VenueResponse> findVenuesWhereActive(){
        List<Venue> venues = repository.findAllVenueWhereActive();
        List<VenueResponse> result = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();
            String name = venue.getName();
            String description = venue.getDescription();
            Time open = venue.getOpen();
            Time close = venue.getClose();
            long price = venue.getPrice();
            String category = venue.getCategory();
            String status = (venue.isActive() ? "Aktif" : "Tidak Aktif");
            result.add(new VenueResponse(id, name, description, open, close, price, category, status));
        }
        return result;
    }

    public Venue findVenueByName(String venueName){
        return repository.findVenueByName(venueName);
    }

    public List<String> findListTime(String id){
        List<String> list = new ArrayList<String>();
        Venue venue = repository.findVenueById(id);
        Time start = Time.valueOf(venue.getOpen().toString());;
        Time end = Time.valueOf(venue.getClose().toString());
        Duration duration = Duration.ofHours(1);

        while (start.getTime() <= end.getTime()) {
            list.add(start.toString());
            long time = start.getTime() + duration.toMillis();
            start.setTime(time);
        }
        return list;
    }

    public List<String> findRandomTime(){
        List<String> list = new ArrayList<String>();
        Time start = Time.valueOf("05:00:00");
        Time end = Time.valueOf("23:00:00");
        Duration duration = Duration.ofHours(1);
        while (start.getTime() <= end.getTime()) {
            list.add(start.toString());
            long time = start.getTime() + duration.toMillis();
            start.setTime(time);
        }
        return list;
    }
}
