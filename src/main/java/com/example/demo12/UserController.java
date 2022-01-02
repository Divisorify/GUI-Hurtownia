package com.example.demo12;

import entities.Klienci;
import entities.Produkty;
import entities.Zamowienia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.*;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class UserController{
    UserController() {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();

        // Utworzenie nowego obiektu i zapisanie ich do bazy
        Session session = sessionFactory.openSession();
        //session.beginTransaction();
        //session.save(new Klienci(0,"Marek","Gramek","Rzeszów","Grunwaldzka","20a",557668392,"małkpa@wp.pl"));
        //session.save(new Klienci(4,"Marko","Gaccio","Lubenia","283","2b/2",554353452,"strzała@wp.pl"));
        //session.save(new Produkty("Medium",29.99,"Dolarów","Niemcy"));
        //session.getTransaction().commit();

        // Pobranie wszystkich obiektów danej klasy z bazy danych
//        CriteriaQuery<Klienci> cq = session.getCriteriaBuilder().createQuery(Klienci.class);
//        cq.from(Klienci.class);
//        List<Klienci> genders = session.createQuery(cq).getResultList();
//        System.out.println(genders.getClass());
//        System.out.println(genders.toString());
//        System.out.println(genders.get(0).toString());
        session.close();
    }


}