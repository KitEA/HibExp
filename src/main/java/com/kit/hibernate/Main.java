package com.kit.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Eldest on 20.02.2016.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger("Hibernate-Tutorial");

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void persistPerson(Session session) {
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Person person = new Person();
            person.setFirstName("Homer");
            person.setLastName("Simpson");
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void run() {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session = sessionFactory.openSession();
            persistPerson(session);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
