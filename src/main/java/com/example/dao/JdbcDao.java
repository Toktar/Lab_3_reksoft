package com.example.dao;

import com.example.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by toktar on 11.07.2016.
 */
@Component("jdbcDao")
public class JdbcDao extends AbstractDBDao {


    /*   private JdbcTemplate jdbcTemplate;

       @Autowired
       public void setDataSource(DataSource dataSource) {
           this.jdbcTemplate = new JdbcTemplate(dataSource);
       }*/
    private String tableName = "contacts", name = "name", email = "email", phone = "phone", location = "location";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS " + tableName + "");
        StringBuffer query = new StringBuffer("CREATE TABLE " + tableName + "(" +
                "id SERIAL");

        String[] colomnsName = {name, email, phone, location};
        for (String name : colomnsName) {
            query.append(", " + name + " VARCHAR(255)");
        }
        query.append(")");
        jdbcTemplate.execute(query.toString());
    }

    @Override
    public void addElement(Contact element) {
        List<Object[]> elementInList = element.toList();
        jdbcTemplate.batchUpdate("INSERT INTO " + tableName + "(" + name + ", " + email + ", " + phone + ", " + location + ") VALUES (?,?,?,?)", elementInList);
    }


    @Override
    public void deleteElement(Contact contact) {
        jdbcTemplate.batchUpdate("DELETE FROM " + tableName + " WHERE id = " + contact.getId());
    }

    @Override
    public List<Contact> getList() {
        List<Contact> contactMap = new ArrayList<>();
        for (Map<String, Object> element : getListOfMap()) {
            Contact contact = new Contact();
            contact.setId(Long.parseLong(element.get("id").toString()));
            contact.setName(element.get(name).toString());
            contact.setEmail(element.get(email).toString());
            contact.setPhone(element.get(phone).toString());
            contact.setLocation((long)element.get(location));
            contactMap.add(contact);
        }
        return contactMap;
    }

    public List<Map<String, Object>> getListOfMap() {
        List<Map<String, Object>> elementsList = jdbcTemplate.queryForList("SELECT * FROM " + tableName);
        return elementsList;
        //  return  null;
    }
}
