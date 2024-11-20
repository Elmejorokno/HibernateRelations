package org.myapp.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.myapp.entity.Customer;
import org.myapp.entity.CustomerDetails;
import org.myapp.entity.Order;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(CustomerDetails.class)
                    .addAnnotatedClass(Order.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Hibernate SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdownSession() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
