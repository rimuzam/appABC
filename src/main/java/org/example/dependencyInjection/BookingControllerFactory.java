package org.example.dependencyInjection;

import org.example.controllers.BookingController;
import org.example.database.AppDbContext;
import org.example.repositories.BookingRepository;
import org.example.repositories.VenueRepository;
import org.example.repositories.impl.BookingRepositoryImpl;
import org.example.repositories.impl.VenueRepositoryImpl;
import org.example.services.BookingService;
import org.example.services.VenueService;
import org.example.services.impl.BookingServiceImpl;
import org.example.services.impl.VenueServiceImpl;

public class BookingControllerFactory {
    private AppDbContext context = new AppDbContext();
    private VenueRepository venueRepository = new VenueRepositoryImpl(context);
    private VenueService venueService = new VenueServiceImpl(venueRepository);
    private BookingRepository bookRepository = new BookingRepositoryImpl(context);
    private BookingService bookService = new BookingServiceImpl(bookRepository, venueService);

    public BookingController controller(){
        return new  BookingController(bookService);
    }
}
