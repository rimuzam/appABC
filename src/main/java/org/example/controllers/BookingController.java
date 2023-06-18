package org.example.controllers;

import org.example.dtos.*;
import org.example.dtos.responses.BookingStatusDetail;
import org.example.models.Booking;
import org.example.models.Venue;
import org.example.services.BookingService;

import java.sql.Time;
import java.util.List;

public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

//    public List<Venue> findAllVenueList(){
//        return bookingService.findAllVenueList();
//    }

//    public List<BookedVenuesResponse> findBookedVenues(){
//        return bookingService.findBookedVenues();
//    }

    public List<BookingDetail> userBookingHistoriesSuccess(String userId){
        return bookingService.userHistoriesSuccess(userId);
    }

    public boolean createBooking(BookingRequest bookingReq){
        return bookingService.createBooking(bookingReq);
    }

    public List<BookingStatusDetail> findBookingStatus(String userId){
        return bookingService.findBookingStatus(userId);
    }

    public List<VenueResponse> findAllVenue(){
        return bookingService.findAllVenue();
    }

    public List<VenueResponse> findVenueByCategory(String category){
        return bookingService.findVenueByCategory(category);
    }

    public long fillPrice(Time startTime, Time endTime, String venueId){
        return bookingService.fillPrice(startTime, endTime,venueId);
    }

    public List<BookedVenuesResponse> findBookedVenues(){
        return bookingService.findBookedVenues();
    }

    public List<BookedVenuesResponse> findBookedVenuesByCategory(String category){
        return bookingService.findBookedVenuesByCategory(category);
    }
    public List<BookedVenuesResponse> findBookedVenuesByDate(String date){
        return bookingService.findBookedVenuesByDate(date);
    }
    public List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String category){
        return bookingService.findBookedVenuesByDateCategory(date, category);
    }
    public List<BookingDetail> userHistoriesSuccess(String userId){
        return bookingService.userHistoriesSuccess(userId);
    }
    public List<BookingDetail> userHistoriesSuccessByDate(String userId, int month, int year){
        return bookingService.userHistoriesSuccessByDate(userId, month, year);
    }
    public List<BookingDetail> userHistoriesSuccessByYear(String user, int year){
        return bookingService.userHistoriesSuccessByYear(user,year);
    }
    public BookingDetail reportBookingStruck(String bookingId){
        return bookingService.reportBookingStruck(bookingId);
    }
    public Booking findBookingById(String bookingId){
        return bookingService.findBookingById(bookingId);
    }
    public List<BookingDetail> listBookings(){
        return bookingService.listBookings();
    }
    public boolean updateStatusBooked(boolean status, String bookingId){
        return bookingService.updateStatusBooked(status, bookingId);
    }
    
    public List<BookingDetail> reportBookings() {
        return bookingService.reportBookings();
    }
    
    public List<BookingDetail> reportBookingsByPeriodYear(int year) {
        return bookingService.reportBookingsByPeriodYear(year);
    }
    
    public List<BookingDetail> reportBookingsByPeriodMonthYear(int month, int year) {
        return bookingService.reportBookingsByPeriodMonthYear(month, year);
    }
    
    public List<BookingDetail> listBookingsByYear(int year){
      return bookingService.listBookingsByYear(year);
    }
    
    public List<BookingDetail> listBookingsByMonthYear(int month, int year){
        return bookingService.listBookingsByMonthYear(month, year);
    }
}
