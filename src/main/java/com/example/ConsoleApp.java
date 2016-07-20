package com.example;

import com.example.dao.JdbcDao;
import com.example.models.Contact;
import com.example.models.Location;
import com.example.services.ContactService;
import com.example.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by toktar on 07.07.2016.
 */

@Component
public class ConsoleApp implements CommandLineRunner {

    Scanner in = new Scanner(System.in);

    @Autowired
    private ContactService contactService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private JdbcDao jdbcDao;

    @Override
    public void run(String... strings) throws IOException, SAXException, ParserConfigurationException {
        jdbcDao.createTable();
        boolean isNotEnd = true;

        while (isNotEnd) {
            System.out.println("show - Show contacts' list");
            System.out.println("del id - Delete contact with id 'id'");
            System.out.println("add - Add contact");
            System.out.println("addl - Add location");
            System.out.println("dbt j/h - Data Base type : jdbc or hibernate");
            System.out.println("end - End application");
            String[] inputData = in.nextLine().split(" ");
            switch (inputData[0]) {
                case "end":
                    isNotEnd = false;
                    break;
                case "show":
                    showContacts();
                    showLocations();
                    break;
                case "del":
                    if (inputData.length == 2) deleteContact(Long.parseLong(inputData[1]));
                    else
                        showErrorInput();
                    break;
                case "add":
                    addContact();
                    break;
                case "addl":
                    addLocation();
                    break;
                case "loc":
                    System.out.println(locationService.getByPhone(inputData[1]).toString());
                    break;
                case "dbt":
                    if (inputData.length == 2) changeDBType(inputData[1]);
                    else
                        showErrorInput();
                    break;
                default:
                    showErrorInput();
                    break;
            }

        }
    }

    private void addLocation() {
        String city = "",
                country = "";
        System.out.print("city: ");
        city = in.next();
        System.out.print("country: ");
        country = in.next();
        Location location = new Location();
        location.setCountry(country);
        location.setCity(city);
        if (
                locationService.add(location)) {
            System.out.println("Add is successful");
        } else {
            System.out.println("Add is fail");
        }
    }

    private void changeDBType(String type) {
        switch (type) {
            case "j":
                contactService.setDbDao(ContactService.DBType.JDBC);
                break;
            case "h":
                contactService.setDbDao(ContactService.DBType.Hibernate);
                break;
            default:
                showErrorInput();
                break;
        }
    }

    private void deleteContact(Long id) throws IOException, ParserConfigurationException {

        if (contactService.deleteContactDB(id)) {
            System.out.println("Delete is successful");
        } else {
            System.out.println("Delete is fail");
        }
    }


    private void addContact() throws ParserConfigurationException {
        String name = "",
                email = "",
                phone = "";
        Long location;
        System.out.print("name: ");
        name = in.next();
        System.out.print("email: ");
        email = in.next();
        System.out.print("phone: ");
        phone = in.next();
        System.out.print("location_id: ");
        location = in.nextLong();
        Contact contact = new Contact(name, email, phone, location);
        if (
                contactService.addContactDB(contact)) {
            System.out.println("Add is successful");
        } else {
            System.out.println("Add is fail");
        }
    }

    private void showContacts() throws ParserConfigurationException, SAXException, IOException {
        System.out.println("CONTACT LIST:");
        for (Contact contact : contactService.getListDB()) {
            System.out.println(contactService.toString(contact));
        }
        System.out.println("___________________");
    }
    private void showLocations() throws ParserConfigurationException, SAXException, IOException {
        System.out.println("LOCATIONS LIST:");
        for (Location location : locationService.getList()) {
            System.out.println(location.toString());
        }
    }


    private void showErrorInput() {
        System.out.println("Intput data is error. Try again, please.");
    }
}
