package com.example.dao;

import com.example.models.Contact;
import com.example.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by toktar on 13.07.2016.
 */
@Component("hibernateDao")
public class HibernateDao extends AbstractDBDao {

    @Autowired
    private ContactRepository contactRepository;

  //@Autowired
  // private HibernateTemplate hibernateTemplate;

 /*   public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }
*/
    @Override
    //@SuppressWarnings("unchecked")
    public List<Contact> getList() {
       /* Session session = this.sessionFactory.openSession();
        List<Contact> personList = session.createQuery("from Contact").list();
        session.close();
        return personList;*/
        return contactRepository.findAll();
       // return hibernateTemplate.loadAll(Contact.class);
       // return null;
    }

    @Override
    public void addElement(Contact contact) {
       /* Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(contact);
        tx.commit();
        session.close();*/
        contactRepository.save(contact);
        //hibernateTemplate.save(contact);
    }
    @Override
    public void deleteElement(Contact contact) {
     /*   Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(contact);
        tx.commit();
        session.close();*/
        contactRepository.delete(contact);
        //hibernateTemplate.delete(contact);

    }



}

