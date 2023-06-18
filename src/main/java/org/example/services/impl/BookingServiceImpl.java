package org.example.services.impl;

import org.example.dtos.*;
import org.example.dtos.responses.BookingStatusDetail;
import org.example.exceptions.WarningException;
import org.example.models.Booking;
import org.example.models.Venue;
import org.example.repositories.BookingRepository;
import org.example.services.BookingService;
import org.example.services.VenueService;

import java.awt.print.Book;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private VenueService venueService;
    private UploadPhotoService uploadPhotoService = new UploadPhotoService();
    public BookingServiceImpl(BookingRepository bookingRepository, VenueService venueService) {
        this.bookingRepository = bookingRepository;
        this.venueService = venueService;
    }

//    public List<Venue> findAllVenueList(){
//        return venueService.findVenuesWhereActive();
//    }

    public List<BookedVenuesResponse> findBookedVenues(){
        return bookingRepository.findBookedVenues();
    }

    public boolean createBooking(BookingRequest bookingReq){
        Booking booking = new Booking();
        String check = bookingRepository.findBookingTransaction(bookingReq.getVenueId(), bookingReq.getDateBooked(), bookingReq.getStartTime(), bookingReq.getEndTime());
        Venue venue = venueService.findVenueId(bookingReq.getVenueId());

        if(check == null){

            if (bookingReq.getStartTime().getTime()  <  venue.getOpen().getTime() || bookingReq.getEndTime().getTime() > venue.getClose().getTime()){
                throw new WarningException("Pastikan waktu yang dipilih sesuai dengan operasional lapangan");
            } else if (bookingReq.getStartTime().getTime() > bookingReq.getEndTime().getTime()) {
                throw new WarningException("Jam mulai tidak boleh lebih dari jam berakhir");
            }

            LocalDate nowDate = LocalDate.now();
            String datee = nowDate.format(DateTimeFormatter.ofPattern("dd"));
            LocalTime now = LocalTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("hhmmss"));
            String id = "BK"+datee+"-"+time;

            // Set dateOrder
            LocalDate order = LocalDate.now();
            String date = order.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Upload photo
            String imageUrl = uploadPhotoService.UploadPhoto(bookingReq.getImageUrl());

            booking.setId(id);
            booking.setDateOrder(date);
            booking.setUserId(bookingReq.getUserId());
            booking.setPrice(bookingReq.getPrice());
            booking.setDateBooked(bookingReq.getDateBooked());
            booking.setImageUrl(imageUrl);
            booking.setStartTime(bookingReq.getStartTime());
            booking.setEndTime(bookingReq.getEndTime());
            booking.setVenueId(bookingReq.getVenueId());

            bookingRepository.createBooking(booking);
            return true;
        }

        throw new WarningException("Maaf jadwal sudah terisi atau sedang dalam proses, silahkan atur jadwal yang lain");

    }

    public List<BookingStatusDetail> findBookingStatus(String userId){
        List<BookingDetail> bookingDetails = bookingRepository.findBookedVenuesStatusByUserId(userId);
        List<BookingStatusDetail> resposes = new ArrayList<>();
        for (BookingDetail bookingDetail : bookingDetails) {
            String id = bookingDetail.getBookedId();
            String category = bookingDetail.getCategory();
            String venueName = bookingDetail.getVenueName();
            String dateOrder = bookingDetail.getDateOrder();
            String dateBooked = bookingDetail.getDateBooked();
            String startTime = bookingDetail.getStartTime();
            String endTime = bookingDetail.getEndTime();
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }

            resposes.add(new BookingStatusDetail(id, venueName, category, dateOrder, dateBooked, startTime, endTime, status ));
        }
        return resposes;
    }

    public List<VenueResponse> findAllVenue(){
        return  venueService.findAllVenues();
    }

    public List<VenueResponse> findVenueByCategory(String category){
        return venueService.findVenueByCategory(category);
    }

    public long fillPrice(Time startTime, Time endTime, String venueId){
        Venue venue = venueService.findVenueId(venueId);
        if (venue == null){
            return 0;
        }
        long venuePrice = venue.getPrice();
        long duration = endTime.getTime() - startTime.getTime();
        long hours = duration / (60 * 60 * 1000);
        long total = venuePrice * hours;
        return total;
    }

    public List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String category){
        return bookingRepository.findBookedVenuesByDateCategory(date, category);
    }

    public List<BookingDetail> userHistoriesSuccess(String userId){
        return bookingRepository.userBookingHistoriesSuccess(userId);
    }
    public List<BookingDetail> userHistoriesSuccessByDate(String userId, int month, int year){
        return bookingRepository.userBookingHistoriesSuccessByDate(userId, month, year);
    }
    public List<BookingDetail> userHistoriesSuccessByYear(String userId, int year){
        return bookingRepository.userBookingHistoriesSuccessByYear(userId, year);
    }
    public BookingDetail reportBookingStruck(String bookingId){
        return bookingRepository.reportBookingStruck(bookingId);
    }
    public List<BookedVenuesResponse> findBookedVenuesByCategory(String category){
        return bookingRepository.findBookedVenuesByCategory(category);
    }
    public List<BookedVenuesResponse> findBookedVenuesByDate(String date){
        return bookingRepository.findBookedVenuesByDate(date);
    }

    public Booking findBookingById(String id){
        return bookingRepository.findBookingWhereId(id);
    }

    @Override
    public List<BookingDetail> listBookings() {
        List<BookingDetail> bookingDetails = bookingRepository.listBookings();
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }

     public List<BookingDetail> reportBookings() {
        List<BookingDetail> bookingDetails = bookingRepository.reportBookings();
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }
     
        public List<BookingDetail> reportBookingsByPeriodYear(int year) {
        List<BookingDetail> bookingDetails = bookingRepository.reportBookings();
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }
        
     public List<BookingDetail> reportBookingsByPeriodMonthYear(int month, int year) {
        List<BookingDetail> bookingDetails = bookingRepository.reportBookings();
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }
     
    public boolean updateStatusBooked(boolean status, String bookingId){
        return bookingRepository.updateStatusBooked(status, bookingId);
    }

    @Override
    public List<BookingDetail> listBookingsByMonthYear(int month, int year) {
        List<BookingDetail> bookingDetails = bookingRepository.listBookingsByMonthYear(month, year);
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }

    @Override
    public List<BookingDetail> listBookingsByYear(int year) {
        List<BookingDetail> bookingDetails = bookingRepository.listBookingsByYear(year);
        List<BookingDetail> result = new ArrayList<BookingDetail>();
        for (BookingDetail bookingDetail : bookingDetails) {
            BookingDetail detail = new BookingDetail();
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setBookedId(bookingDetail.getBookedId());
            detail.setVenueName(bookingDetail.getVenueName());
            detail.setVenueId(bookingDetail.getVenueId());
            detail.setCategory(bookingDetail.getCategory());
            detail.setEmailUser(bookingDetail.getEmailUser());
            detail.setPhoneNumber(bookingDetail.getPhoneNumber());
            detail.setDateOrder(bookingDetail.getDateOrder());
            detail.setDateBooked(bookingDetail.getDateBooked());
            detail.setStartTime(bookingDetail.getStartTime());
            detail.setEndTime(bookingDetail.getEndTime());
            detail.setPrice(bookingDetail.getPrice());
            String status = "";
            if (bookingDetail.isConfirmed() != null){
                if (bookingDetail.isConfirmed() == true){
                    status = "Berhasil";
                } else if (bookingDetail.isConfirmed() == false){
                    status = "Ditolak";
                }
            } else {
                status = "Belum Terkonfirmasi";
            }
            detail.setStatus(status);
            result.add(detail);
        }
        return result;
    }
}
