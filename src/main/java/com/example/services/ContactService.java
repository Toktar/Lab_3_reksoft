package com.example.services;


import com.example.dao.AbstractDBDao;
import com.example.dao.HibernateDao;
import com.example.dao.JdbcDao;
import com.example.models.Contact;
import com.example.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by toktar on 08.07.2016.
 */


@Service
//@Transactional
public class ContactService {
    List<Contact> contactList;


    public enum DBType {JDBC, Hibernate}

    protected static Logger logger = Logger.getLogger("service");




    @Autowired
    private JdbcDao jdbcDao;

    @Autowired
    private HibernateDao hibernateDao;

    public void setDbDao(DBType type) {
        if (type == DBType.Hibernate)
            dbDao = hibernateDao;
        else
            dbDao = jdbcDao;
    }

    @Autowired
    @Qualifier("hibernateDao")
    private AbstractDBDao dbDao;


    public boolean deleteContactDB(long id) {
        updateContactsList();
        Contact contact = getContactById(id);
        if (contact != null) {
            dbDao.deleteElement(contact);
            return true;
        }
        return false;
    }


    public boolean addContactDB(Contact contact) {
        updateContactsList();
        if (contact != null && !contactList.contains(contact)) {
            dbDao.addElement(contact);
            return true;
        }
        return false;
    }


    public List<Contact> getListDB() {
        return dbDao.getList();
    }

    public void updateContactsList() {
        contactList = getListDB();
    }


    public Contact getContactById(long id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) return contact;
        }

        return null;
    }


    public Contact getContactByPhone(String phone) {
        updateContactsList();
        for (Contact contact : contactList) {
            if (contact.getPhone().equals(phone)) return contact;
        }

        return null;
    }

    public String toString(Contact contact) {
        StringBuffer out = new StringBuffer();
        out.append("\n____________________");
        out.append("\nid:" + contact.getId());
        out.append("\nname:" + contact.getName());
        if (!contact.getEmail().isEmpty()) out.append("\nemail:" + contact.getEmail());
        if (!contact.getPhone().isEmpty()) out.append("\nphone:" + contact.getPhone());
        if (contact.getLocation() != 0) out.append("\nlocation:" + contact.getLocation());
        out.append("\n____________________");

        return out.toString();
    }

}
