package org.example.services;

import org.example.dtos.*;
import org.example.dtos.responses.BookingStatusDetail;
import org.example.models.Booking;
import org.example.models.Venue;

import java.sql.Time;
import java.util.List;

public interface BookingService {
    //List<Venue> findAllVenueList();
    List<BookedVenuesResponse> findBookedVenues();
    boolean createBooking(BookingRequest bookingReq);
    List<BookingStatusDetail> findBookingStatus(String userId);
    List<VenueResponse> findAllVenue();
    List<VenueResponse> findVenueByCategory(String category);
    List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String category);
    List<BookingDetail> userHistoriesSuccess(String userId);
    long fillPrice(Time startTime, Time endTime, String venueId);
    List<BookedVenuesResponse> findBookedVenuesByCategory(String category);
    List<BookedVenuesResponse> findBookedVenuesByDate(String date);
    List<BookingDetail> userHistoriesSuccessByDate(String userId, int month, int year);
    List<BookingDetail> userHistoriesSuccessByYear(String userId, int year);
    BookingDetail reportBookingStruck(String bookingId);
    Booking findBookingById(String id);
    List<BookingDetail> listBookings();
    boolean updateStatusBooked(boolean status, String bookingId);
    List<BookingDetail> reportBookings();
    List<BookingDetail> reportBookingsByPeriodYear(int year);
    List<BookingDetail> reportBookingsByPeriodMonthYear(int month, int year);
    List<BookingDetail> listBookingsByMonthYear(int month, int year);
    List<BookingDetail> listBookingsByYear(int year);
}
