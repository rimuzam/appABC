package org.example;

import org.example.controllers.CategoryController;
import org.example.database.AppDbContext;
import org.example.dependencyInjection.CategoryControllerFactory;
import org.example.dtos.*;
import org.example.dtos.responses.BookingStatusDetail;
import org.example.models.Category;
import org.example.models.Venue;
import org.example.repositories.AbsentRepository;
import org.example.repositories.BookingRepository;
import org.example.repositories.VenueRepository;
import org.example.repositories.impl.AbsentRepositoryImpl;
import org.example.repositories.impl.BookingRepositoryImpl;
import org.example.repositories.impl.VenueRepositoryImpl;
import org.example.services.BookingService;
import org.example.services.VenueService;
import org.example.services.impl.BookingServiceImpl;
import org.example.services.impl.VenueServiceImpl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        AppDbContext context = new AppDbContext();
        BookingRepository repo = new BookingRepositoryImpl(context);
        VenueRepository venueRepository = new VenueRepositoryImpl(context);
        VenueService venueService = new VenueServiceImpl(venueRepository);
        BookingServiceImpl service = new BookingServiceImpl(repo, venueService);
        AbsentRepository absentRepository = new AbsentRepositoryImpl(context);

        CategoryControllerFactory factory = new CategoryControllerFactory();
        CategoryController categoryController = factory.controller();

        BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl(context);

        for (AbsentResponse absentDetailResponse : absentRepository.findAbsentByYear(2023)) {
            System.out.println(absentDetailResponse.getPermission());
        }
//        final List<BookingStatusDetail> bookingStatus = service.findBookingStatus("229b0f84-b8e4-416f-9a69-32d49c0fdffe");
//        for (BookingStatusDetail status : bookingStatus) {
//            System.out.println(status.getId());
//            System.out.println(status.getName());
//            System.out.println(status.getCategory());
//            System.out.println(status.getDateOrder());
//            System.out.println(status.getDateBooked());
//            System.out.println(status.getStartTime());
//            System.out.println(status.getEndTime());
//            System.out.println(status.getStatus());
//        }

        // Booking Lapangan
//        String userId = "229b0f84-b8e4-416f-9a69-32d49c0fdffe";
//        String venueId = "BD001";
//        String dateBooked = "2023-02-12";
//        Time startTime = Time.valueOf("14:00:00");
//        Time endTime = Time.valueOf("15:00:00");
//        long price = 50000;
//        String imageUrl = "Tettt";
//        BookingRequest request = new BookingRequest(userId,venueId, dateBooked, startTime, endTime, price, imageUrl );
//        service.createBooking(request);
//        System.out.println("Sukses");

//        final List<Venue> badminton = venueRepository.findVenueByCategory("Futsal");
//        for (Venue venue : badminton) {
//            System.out.println(venue.getName());
//        }

//        Time now = Time.valueOf("09:00:00");
//        Time past = Time.valueOf("20:00:00");
//        Duration duration = Duration.ofHours(1);
//
//        while (now.getTime() <= past.getTime()) {
//            System.out.println(now.toString());
//            long time = now.getTime() + duration.toMillis();
//            now.setTime(time);
//        }

//        List<BookedVenuesResponse> futsal = service.findBookedVenuesByCategory("Badminton");
//        for (BookedVenuesResponse status : futsal) {
//            System.out.println(status.getVenueId());
//            System.out.println(status.getVenueName());
//            System.out.println(status.getVenueCategory());
//            System.out.println(status.getDateBooked());
//            System.out.println(status.getStartTime());
//            System.out.println(status.getEndTime());
//            System.out.println(status.getUserEmail());
//
//        }
//        List<BookingStatusDetail> bookingDetails = service.findBookingStatus("229b0f84-b8e4-416f-9a69-32d49c0fdffe");
//        for (BookingStatusDetail bookingDetail : bookingDetails) {
//            System.out.println(bookingDetail.getStatus());
//            System.out.println(bookingDetail.getName());
//        }

//        BookingDetail bookingDetail = service.reportBookingStruck("BK99-082447");
//        System.out.println(bookingDetail.getBookedId());
//        System.out.println(bookingDetail.getImageUrl());

//        List<BookingDetail> bookingDetails = bookingRepository.listBookings();
//        for (BookingDetail bookingDetail : bookingDetails) {
//            System.out.println(bookingDetail.getEmailUser());
//            System.out.println(bookingDetail.getPrice());
//        }
    }



}
