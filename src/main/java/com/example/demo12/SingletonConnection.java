package com.example.demo12;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;

public class SingletonConnection {
    private static SessionFactory sessionFactory;

    private SingletonConnection() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
//            sessionFactory = new MetadataSources(
//                    new StandardServiceRegistryBuilder().configure().build())
//                    .buildMetadata().
//                    buildSessionFactory();

            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }

}