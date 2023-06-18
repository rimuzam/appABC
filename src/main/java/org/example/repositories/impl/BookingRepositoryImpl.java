package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.dtos.BookedVenuesResponse;
import org.example.dtos.BookingDetail;
import org.example.models.Booking;
import org.example.repositories.BookingRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private AppDbContext context;
    public BookingRepositoryImpl(AppDbContext context) {
        this.context = context;
    }
    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e.getMessage());
    }

    public Booking createBooking(Booking book){
        String query = "insert into booking values ('"+book.getId()+"', '"+book.getUserId()+"', '"+book.getVenueId()+"', '"+book.getDateOrder()+"', " +
                "'"+book.getDateBooked()+"', '"+book.getStartTime()+"', '"+book.getEndTime()+"', "+book.getPrice()+", " +
                ""+book.isConfirmed()+", '"+book.getImageUrl()+"')";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return book;
    }

    public boolean updateStatusBooked(boolean status, String bookingId){
        String query = "update booking set isConfirmed = "+status+" where id = '"+bookingId+"'";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return true;
    }
    public String findBookingTransaction(String venueId, String dateBooking, Time startTime, Time endTime){
        String query = "select * from Booking where venue_id = '"+venueId+"' and dateBooked = '"+dateBooking+"' and ((start_time >= '"+startTime+"' and start_time < '"+startTime+"')" +
                "or (end_time > '"+endTime+"' and end_time <= '"+endTime+"')" +
                "or (start_time <= '"+startTime+"' and end_time >= '"+endTime+"') " +
                "or (start_time = '"+startTime+"')) and isConfirmed != false";
        Booking book = new Booking();
        try{
            ResultSet resultSet = context.getStatement().executeQuery(query);
            while (resultSet.next()){
                book.setId(resultSet.getString("id"));
                book.setUserId(resultSet.getString("user_id"));
                book.setVenueId(resultSet.getString("venue_id"));
                book.setDateOrder(resultSet.getString("dateOrder"));
                book.setDateBooked(resultSet.getString("dateBooked"));
                book.setStartTime(resultSet.getTime("start_time"));
                book.setEndTime(resultSet.getTime("end_time"));
                book.setPrice(resultSet.getLong("price"));
                book.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                book.setImageUrl(resultSet.getString("image"));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return book.getId();
    }

    public Booking findBookingWhereId(String bookedId){
        String query = "select * from booking where id = '"+bookedId+"'";
        ResultSet resultSet = null;
        Booking booking = null;
        //List<Booking> bookings = new ArrayList<>();
        try {
            resultSet = context.getStatement().executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userId = resultSet.getString("user_id");
                String venueId = resultSet.getString("venue_id");
                String dateOrder = resultSet.getString("dateOrder");
                String dateBooked = resultSet.getString("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                Long price = resultSet.getLong("price");
                boolean isConfirmed = resultSet.getBoolean("isConfirmed");
                String imageUrl = resultSet.getString("image");
                booking = new Booking(id, userId, venueId, dateOrder, dateBooked, startTime, endTime, price, isConfirmed, imageUrl);
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return booking;
    }

//    public List<BookingDetail> findAllBookingByUserId(String userIdReq){
//        String query = "select * from booking where user_id = '"+userIdReq+"'";
//        ResultSet resultSet = null;
//        List<BookingDetail> bookings = new ArrayList<>();
//        try {
//            resultSet = context.getStatement().executeQuery(query);
//            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String userId = resultSet.getString("user_id");
//                String venueId = resultSet.getString("venue_id");
//                String dateOrder = resultSet.getString("dateOrder");
//                String dateBooked = resultSet.getString("dateBooked");
//                Time startTime = resultSet.getTime("start_time");
//                Time endTime = resultSet.getTime("end_time");
//                Long price = resultSet.getLong("price");
//                boolean isConfirmed = resultSet.getBoolean("isConfirmed");
//                String imageUrl = resultSet.getString("image");
//                bookings.add(new Booking(id, userId, venueId, dateOrder, dateBooked, startTime, endTime, price, isConfirmed, imageUrl));
//            }
//        } catch (Exception e){
//            error(e);
//        } finally{
//            context.closeResources();
//        }
//        return bookings;
//    }

    // See all venues have been booked
    public List<BookedVenuesResponse> findBookedVenues(){
        String query = "select v.id, v.name, c.name as category, u.email, b.dateBooked, b.start_time, b.end_time " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where b.isConfirmed = true";
        ResultSet resultSet = null;
        List<BookedVenuesResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String venueId = resultSet.getString("id");
                String venueName = resultSet.getString("name");
                String category = resultSet.getString("category");
                String emailUser = resultSet.getString("email");
                String dateBooked = resultSet.getString("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                results.add(new BookedVenuesResponse(venueId, venueName, category, emailUser, dateBooked, startTime, endTime));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return results;
    }

    // See all venues have been booked filter by date and category

    public List<BookedVenuesResponse> findBookedVenuesByCategory(String categoryReq){
        String query = "select v.id, v.name, c.name as category, u.email, b.dateBooked, b.start_time, b.end_time " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where b.isConfirmed = true and c.name = '"+categoryReq+"'";
        ResultSet resultSet = null;
        List<BookedVenuesResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String venueId = resultSet.getString("id");
                String venueName = resultSet.getString("name");
                String category = resultSet.getString("category");
                String emailUser = resultSet.getString("email");
                String dateBooked = resultSet.getString("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                results.add(new BookedVenuesResponse(venueId, venueName, category, emailUser, dateBooked, startTime, endTime));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return results;
    }

    public List<BookedVenuesResponse> findBookedVenuesByDate(String date){
        String query = "select v.id, v.name, c.name as category, u.email, b.dateBooked, b.start_time, b.end_time " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where b.isConfirmed = true and b.dateBooked = '"+date+"'";
        ResultSet resultSet = null;
        List<BookedVenuesResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String venueId = resultSet.getString("id");
                String venueName = resultSet.getString("name");
                String category = resultSet.getString("category");
                String emailUser = resultSet.getString("email");
                String dateBooked = resultSet.getString("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                results.add(new BookedVenuesResponse(venueId, venueName, category, emailUser, dateBooked, startTime, endTime));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return results;
    }

    public List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String categoryReq){
        String query = "select v.id, v.name, c.name as category, u.email, b.dateBooked, b.start_time, b.end_time " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where b.isConfirmed = true and (b.dateBooked = '"+date+"' and c.name = '"+categoryReq+"')";
        ResultSet resultSet = null;
        List<BookedVenuesResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String venueId = resultSet.getString("id");
                String venueName = resultSet.getString("name");
                String category = resultSet.getString("category");
                String emailUser = resultSet.getString("email");
                String dateBooked = resultSet.getString("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                results.add(new BookedVenuesResponse(venueId, venueName, category, emailUser, dateBooked, startTime, endTime));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return results;
    }

    // See booking user status
    public List<BookingDetail> findBookedVenuesStatusByUserId(String userId){
        String query = "select b.id, v.name, c.name as category, b.dateOrder, b.dateBooked, b.start_time, b.end_time, b.isConfirmed " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where user_id = '"+userId+"'";
        ResultSet resultSet = null;
        List<BookingDetail> results = new ArrayList<>();

        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                results.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return results;
    }

    // See user booking histories
    public List<BookingDetail> userBookingHistoriesSuccess(String userId){
        String query = "select b.id, v.name, c.name as category, b.dateOrder, b.dateBooked, b.start_time, b.end_time, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where user_id = '"+userId+"' and isConfirmed = true ";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();

        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookings.add(bookDetail);
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }

    public List<BookingDetail> userBookingHistoriesSuccessByDate(String userId, int month, int year){
        String query = "select b.id, v.name, c.name as category, b.dateOrder, b.dateBooked, b.start_time, b.end_time, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where user_id = '"+userId+"' and isConfirmed = true and (MONTH(b.dateOrder) = "+month+") and (Year(b.dateOrder) = "+year+") ";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();

        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookings.add(bookDetail);
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    public List<BookingDetail> userBookingHistoriesSuccessByYear(String userId, int year){
        String query = "select b.id, v.name, c.name as category, b.dateOrder, b.dateBooked, b.start_time, b.end_time, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where user_id = '"+userId+"' and isConfirmed = true and (Year(b.dateOrder) = "+year+") ";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();

        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookings.add(bookDetail);
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    public List<BookingDetail> userBookingHistoriesFailed(String userId){
        String query = "select b.id, v.name, v.category, b.dateOrder, b.dateBooked, b.start_time, b.end_time" +
                "from booking b" +
                "join user u on b.user_id = u.id" +
                "join venue v on b.venue_id = v.id" +
                "where user_id = '"+userId+"' and isConfirmed = false";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = null;
        BookingDetail bookDetail = new BookingDetail();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                bookings.add(bookDetail);
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }

    public BookingDetail reportBookingStruck(String bookingId){
        String query = "select b.id, b.venue_id, v.name, c.name as category, b.image, u.email, u.fullname, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.price, b.isConfirmed " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id where b.id = '"+bookingId+"'";
        ResultSet resultSet = null;
        BookingDetail bookDetail = new BookingDetail();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setFullName(resultSet.getString("fullname"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookDetail.setImageUrl(resultSet.getString("image"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookDetail;
    }
    // For Admin
    public List<BookingDetail> reportBookings(){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " +
                "where (b.isConfirmed = true or b.isConfirmed = false) ";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setFullName(resultSet.getString("fullname"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    
     // For Admin
    public List<BookingDetail> reportBookingsByPeriodMonthYear(int month, int year){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " + 
                "where (b.isConfirmed = true or b.isConfirmed = false) and (MONTH(b.dateOrder) = "+month+") and (Year(b.dateOrder) = "+year+")";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
//                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
//                bookDetail.setFullName(resultSet.getString("fullname"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
//               bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }

     // For Admin
    public List<BookingDetail> reportBookingsByPeriodYear(int year){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id " + 
                "where (b.isConfirmed = true or b.isConfirmed = false) and (Year(b.dateOrder) = "+year+")";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setFullName(resultSet.getString("fullname"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    
    public List<BookingDetail> listBookings(){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id ";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    
    public List<BookingDetail> listBookingsByYear(int year){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id "
                + "where (YEAR(b.dateOrder) = "+year+")";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
    
    public List<BookingDetail> listBookingsByMonthYear(int month, int year){
        String query = "select b.id, v.name, v.id as venue_id, c.name as category, u.email, b.dateOrder, b.dateBooked, b.start_time, b.end_time, u.phoneNumber, b.isConfirmed, b.price " +
                "from booking b " +
                "join user u on b.user_id = u.id " +
                "join venue v on b.venue_id = v.id " +
                "join category c on v.category_id = c.id "
                + "where (MONTH(b.dateOrder) = "+month+") and (Year(b.dateOrder) = "+year+")";
        ResultSet resultSet = null;
        List<BookingDetail> bookings = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                BookingDetail bookDetail = new BookingDetail();
                bookDetail.setBookedId(resultSet.getString("id"));
                bookDetail.setVenueName(resultSet.getString("name"));
                bookDetail.setVenueId(resultSet.getString("venue_id"));
                bookDetail.setCategory(resultSet.getString("category"));
                bookDetail.setEmailUser(resultSet.getString("email"));
                bookDetail.setPhoneNumber(resultSet.getString("phoneNumber"));
                bookDetail.setDateOrder(resultSet.getString("dateOrder"));
                bookDetail.setDateBooked(resultSet.getString("dateBooked"));
                bookDetail.setStartTime(resultSet.getString("start_time"));
                bookDetail.setEndTime(resultSet.getString("end_time"));
                bookDetail.setPrice(resultSet.getLong("price"));
                bookDetail.setConfirmed(resultSet.getObject("isConfirmed") != null ? resultSet.getBoolean("isConfirmed") : null);
                bookings.add(bookDetail);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return bookings;
    }
}
