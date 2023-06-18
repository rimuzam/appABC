package org.example.repositories;

import org.example.dtos.BookedVenuesResponse;
import org.example.dtos.BookingDetail;
import org.example.models.Booking;

import java.sql.Time;
import java.util.List;

public interface BookingRepository {
    Booking createBooking(Booking book);
    boolean updateStatusBooked(boolean status, String bookingId);
    String findBookingTransaction(String venueId, String dateBooking, Time startTime, Time endTime);
    Booking findBookingWhereId(String bookedId);
    List<BookedVenuesResponse> findBookedVenues();
    List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String categoryReq);
    List<BookingDetail> findBookedVenuesStatusByUserId(String userId);
    List<BookingDetail> userBookingHistoriesSuccess(String userId);
    List<BookingDetail> userBookingHistoriesFailed(String userId);
    List<BookingDetail> reportBookings();
    List<BookedVenuesResponse> findBookedVenuesByCategory(String categoryReq);
    List<BookedVenuesResponse> findBookedVenuesByDate(String date);
    List<BookingDetail> userBookingHistoriesSuccessByDate(String userId, int month, int year);
    List<BookingDetail> userBookingHistoriesSuccessByYear(String userId, int year);
    BookingDetail reportBookingStruck(String bookingId);
    List<BookingDetail> listBookings();
    List<BookingDetail> reportBookingsByPeriodMonthYear(int month, int year);
    List<BookingDetail> reportBookingsByPeriodYear(int year);
    List<BookingDetail> listBookingsByYear(int year);
    List<BookingDetail> listBookingsByMonthYear(int month, int year);
}
