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
        session.beginTransaction();
        session.save(new Klienci(0,"Marek","Gramek","Rzeszów","Grunwaldzka","20a",557668392,"małkpa@wp.pl"));
        session.save(new Klienci(4,"Marko","Gaccio","Lubenia","283","2b/2",554353452,"strzała@wp.pl"));
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
    public static ObservableList<Klienci> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from Klienci";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci> klienciList = getKlienciObjects(rsSet);
            return klienciList;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Klienci> getKlienciObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Klienci> klienciList = FXCollections.observableArrayList();

            while(rsSet.next()){
                Klienci kli = new Klienci();
                kli.setKlient_id(rsSet.getInt("kl_id"));
                kli.setKl_imieProperty(rsSet.getString("kl_imie"));
                kli.setKl_nazwiskoProperty(rsSet.getString("kl_nazwisko"));
                kli.setKl_miejscowoscProperty(rsSet.getString("kl_miejscowosc"));
                kli.setKl_ulicaProperty(rsSet.getString("kl_ulica"));
                kli.setKl_nrMieszkaniaProperty(rsSet.getString("kl_nrMieszkania"));
                kli.setKl_nrTelefonuProperty(rsSet.getInt("kl_nrTelefonu"));
                kli.setKl_emailProperty(rsSet.getString("kl_email"));
                klienciList.add(kli);
            }
            return klienciList;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }

    }

}