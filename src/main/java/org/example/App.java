package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

       try {
           session.beginTransaction();

            session.createQuery("update Person set name='Papa' where age < 20").executeUpdate();

           session.getTransaction().commit();
       }finally {
           sessionFactory.close();
       }
    }
}
