package com.example.demo12;

import entities.Klienci;
import entities.Produkty;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

//        TableView<Produkty> table = new TableView<Produkty>();
//        table.setEditable(true);
//
//        TableColumn<Produkty, String> colprod_nazwa = new TableColumn<Produkty, String>("prod_nazwa");
//        colprod_nazwa.setCellValueFactory(new PropertyValueFactory<Produkty, String>("prod_nazwa"));
//        colprod_nazwa.setCellFactory(TextFieldTableCell.forTableColumn());
//        colprod_nazwa.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Produkty, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<Produkty, String> event) {
//                Produkty person = event.getRowValue();
//                person.setProd_nazwa(event.getNewValue());
//            }
//        });
//        table.getColumns().add(colprod_nazwa);

    }

    public static void main(String[] args) throws Exception {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
//        // Utworzenie obiektów klasy Gender i przesłanie ich do bazy danych
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        //session.save(new Klienci());
//        //session.save(new Gender("Female"));
//        //session.getTransaction().commit();
//        session.close();
//        new UserController();
//
        launch();


    }
}

