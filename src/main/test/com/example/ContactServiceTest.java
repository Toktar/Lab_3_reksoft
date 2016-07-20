package com.example;

import com.example.services.ContactService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by toktar on 15.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class ContactServiceTest {

    @Autowired
    ContactService contactService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void setDbDao() throws Exception {
        contactService.setDbDao(null);
        contactService.setDbDao(null);
        contactService.setDbDao(null);
    }

    @Test
    public void deleteContactXml() throws Exception {

    }

    @Test
    public void deleteContactDB() throws Exception {

    }

    @Test
    public void addContactXml() throws Exception {

    }

    @Test
    public void addContactDB() throws Exception {

    }

    @Test
    public void getContactMap() throws Exception {

    }

    @Test
    public void getContactMapXml() throws Exception {

    }

    @Test
    public void getListDB() throws Exception {

    }

    @Test
    public void updateContactsList() throws Exception {

    }

    @Test
    public void getContactById() throws Exception {

    }

}