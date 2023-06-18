package org.example.dependencyInjection;

import org.example.controllers.VenueController;
import org.example.database.AppDbContext;
import org.example.repositories.VenueRepository;
import org.example.repositories.impl.VenueRepositoryImpl;
import org.example.services.VenueService;
import org.example.services.impl.VenueServiceImpl;

public class VenueControllerFactory {
    private AppDbContext context = new AppDbContext();
    private VenueRepository repository = new VenueRepositoryImpl(context);
    private VenueService service = new VenueServiceImpl(repository);
    public VenueController controller(){
        return new VenueController(service);
    }
}
