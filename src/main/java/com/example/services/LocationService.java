package com.example.services;

import com.example.models.Contact;
import com.example.models.Location;
import com.example.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by toktar on 19.07.2016.
 */
@Service
public class LocationService {

    @Autowired
    ContactService contactService;

    @Autowired
    LocationRepository locationRepository;

    public Location getByPhone(String phone) {
        Contact contact = contactService.getContactByPhone(phone);
        if(contact==null) return null;
        Location location =  getById(contact.getLocation());
       return (location!=null && location.getId()!=0)?location:null;
    }

    public Location getById(long id) {
       return locationRepository.findOne(id);
    }

    public boolean add(Location location) {
        locationRepository.save(location);
        return true;
    }

    public List<Location> getList() {
        return locationRepository.findAll();
    }
}
