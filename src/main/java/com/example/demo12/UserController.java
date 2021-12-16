package com.example.demo12;

import entities.Klienci;
import entities.Produkty;
import entities.Zamowienia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class UserController {
    UserController() {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();

        // Utworzenie nowego obiektu i zapisanie ich do bazy
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Klienci(0,"Marek","Gramek","Rzeszów","Grunwaldzka","20a",557668392,"małkpa@wp.pl"));
        //session.save(new Produkty("Medium",29.99,"Dolarów","Niemcy"));
        session.getTransaction().commit();


        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<Klienci> cq = session.getCriteriaBuilder().createQuery(Klienci.class);
        cq.from(Klienci.class);
        List<Klienci> genders = session.createQuery(cq).getResultList();
        System.out.println(genders.getClass());
        System.out.println(genders.toString());
        System.out.println(genders.get(1).toString());
        session.close();
    }


}