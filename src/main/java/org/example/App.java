package org.example;

import org.example.model.Directors;
import org.example.model.Films;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

/**
 * protectflame
 *
 */
public class App {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().addAnnotatedClass(Directors.class).addAnnotatedClass(Films.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

       try {

           session.beginTransaction();

           Directors directors = session.getReference(Directors.class, 1L);

           Films newFilm = new Films();
           newFilm.setTitle("Гарри Потер");
           newFilm.setOwner(directors);

           directors.getFilms().add(newFilm);

           session.persist(newFilm);

           session.getTransaction().commit();
       }finally {
           sessionFactory.close();
           session.close();
       }
    }
}
