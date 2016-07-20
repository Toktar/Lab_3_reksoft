package com.example.models;


import com.example.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toktar on 12.07.2016.
 */

@Entity
@Table(name = "Contacts")
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private long location;



    public long getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location.getId();
    }
    public void setLocation(long location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Contact(String name, String email, String phone, long location) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public Contact(long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact() {
    }


    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\n____________________");
        out.append("\nid:" + id);
        out.append("\nname:" + name);
        if (!email.isEmpty()) out.append("\nemail:" + email);
        if (!phone.isEmpty()) out.append("\nphone:" + phone);
        if (location != 0) out.append("\nlocation:" +  location);
        out.append("\n____________________");

        return out.toString();
    }

    public List<Object[]> toList() {
        List<Object[]> contactsList = new ArrayList<>();
        contactsList.add(new Object[]{this.name, this.email, this.phone, this.location});
        return contactsList;
    }

    // getters & setters omitted for brevity
}