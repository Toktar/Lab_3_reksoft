package com.example.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by toktar on 19.07.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", namespace = "http://localhost:8080", propOrder = {
        "id",
        "country",
        "city"
})
@Entity
@Table(name = "Locations")
public class Location {
    @Id
    @Column(name = "id")
    @GeneratedValue
    @XmlElement(namespace = "http://localhost:8080")
    protected long id;

    @Column(name = "country")
    @XmlElement(namespace = "http://localhost:8080", required = true)
    protected String country;

    @Column(name = "city")
    @XmlElement(namespace = "http://localhost:8080", required = true)
    protected String city;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getCity() {
        return city;
    }


    public void setCity(String value) {
        this.city = value;
    }

    @Override
    public String toString() {
        return String.format(
                "[id=%d, country='%s', city='%s']",
                id, country, city);
    }
    public boolean isNull() {
        return this==null;
    }

}
