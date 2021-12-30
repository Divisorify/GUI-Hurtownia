package com.example.demo12;

import entities.Klienci;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Baza Danych Hurtownia Konrad Pelc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
        // Utworzenie obiektów klasy Gender i przesłanie ich do bazy danych
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Klienci());
        //session.save(new Gender("Female"));
        session.getTransaction().commit();
        session.close();
        new UserController();

        launch();
    }
}

