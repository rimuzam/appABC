package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;
import org.example.models.Venue;
import org.example.repositories.VenueRepository;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class VenueRepositoryImpl implements VenueRepository {
    private AppDbContext context;
    public VenueRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    public Venue createVenue(Venue venue) {
        String query = "insert into venue values ('"+venue.getId()+"', '"+venue.getName()+"', '"+venue.getDescription()+"', " +
                "'"+venue.getOpen()+"', '"+venue.getClose()+"', "+venue.getPrice()+", '"+venue.getCategory()+"', "+venue.isActive()+")";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venue;
    }

    public List<Venue> findAllVenue(){
        ResultSet resultSet = null;
        List<Venue> venues = new ArrayList<>();
        String query = "select v.id, v.name, v.description, v.open, v.close, v.price, c.name as category_name, v.isActive from venue v join category c on c.id = v.category_id";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String category = resultSet.getString("category_name");
                boolean isActive = resultSet.getBoolean("isActive");
                venues.add(new Venue(id, name, description, open, close, price, category, isActive));
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venues;
    }

    public List<Venue> findAllVenueWhereActive(){
        ResultSet resultSet = null;
        List<Venue> venues = new ArrayList<>();
        String query = "select v.id, v.name, v.description, v.open, v.close, v.price, c.name as category_name, v.isActive from venue v join category c on c.id = v.category_id where v.isActive = true";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category_name");
                boolean isActive = resultSet.getBoolean("isActive");
                venues.add(new Venue(id, name, description, open, close, price, categoryString, isActive));
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venues;
    }

    public boolean updateVenue(Venue venue){
        String query = "update venue set name = '"+venue.getName()+"', description = '"+venue.getDescription()+"', open = '"+venue.getOpen()+"', " +
                "close = '"+venue.getClose()+"', price = "+venue.getPrice()+", category_id = '"+venue.getCategory()+"', isActive = "+venue.isActive()+" where id = '"+venue.getId()+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch(Exception e){
            throw new ErrorException(e.getMessage());
        } finally {
            context.closeResources();
        }
        return true;
    }

    public Venue findVenueById(String venueId){
        ResultSet resultSet = null;
        Venue venue = null;
        String query = "select v.id, v.name, v.description, v.open, v.close, v.price, c.name as category_name, v.isActive from venue v join category c on c.id = v.category_id where v.id = '"+venueId+"'";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category_name");
                boolean isActive = resultSet.getBoolean("isActive");
                venue = new Venue(id, name, description, open, close, price, categoryString, isActive);
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venue;
    }

    public Venue findVenueByName(String venueName){
        ResultSet resultSet = null;
        Venue venue = null;
        String query = "select v.id, v.name, v.description, v.open, v.close, v.price, c.name as category_name, v.isActive from venue v join category c on c.id = v.category_id where v.name like '%"+venueName+"%'";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category_name");
                boolean isActive = resultSet.getBoolean("isActive");
                venue = new Venue(id, name, description, open, close, price, categoryString, isActive);
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venue;
    }

    public List<Venue> findVenueByCategory(String categorySearch){
        ResultSet resultSet = null;
        List<Venue> venues = new ArrayList<>();
        String query = "select v.id, v.name, v.description, v.open, v.close, v.price, c.name as category_name, v.isActive from venue v join category c on c.id = v.category_id where c.name = '"+categorySearch+"'";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category_name");
                boolean isActive = resultSet.getBoolean("isActive");
                venues.add(new Venue(id, name, description, open, close, price, categoryString, isActive));
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally{
            context.closeResources();
        }
        return venues;
    }


}
