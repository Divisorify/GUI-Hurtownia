package com.example.demo12;

import entities.Klienci;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.Transient;
import java.io.IOException;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextArea resultConsole;

    @FXML
    private TableColumn<Klienci, Integer> colkl_id;
    @FXML
    private TableColumn<Klienci, String> colkl_imie;
    @FXML
    private TableColumn<Klienci, String> colkl_nazwisko;
    @FXML
    private TableColumn<Klienci, String> colkl_miejscowosc;
    @FXML
    private TableColumn<Klienci, String> colkl_ulica;
    @FXML
    private TableColumn<Klienci, String> colkl_nrMieszkania;
    @FXML
    private TableColumn<Klienci, Integer> colkl_nrTelefonu;
    @FXML
    private TableColumn<Klienci, String> colkl_email;

    @FXML
    private TableView KlienciTable;

    @FXML
    void btnDostawcy(ActionEvent event) throws IOException{
        Parent dostawcy = FXMLLoader.load(getClass().getResource("dostawcy.FXML"));
        Scene scenedostawcy = new Scene(dostawcy);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scenedostawcy);
        app_stage.show();
    }

    @FXML
    void btnElementyZamówienia(ActionEvent event) throws IOException{
        Parent elementyzamowienia = FXMLLoader.load(getClass().getResource("elementyzamowienia.FXML"));
        Scene sceneelementyzamowienia = new Scene(elementyzamowienia);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneelementyzamowienia);
        app_stage.show();
    }

    @FXML
    void btnKlienci(ActionEvent event) throws IOException {
        Parent klienci = FXMLLoader.load(getClass().getResource("klienci.FXML"));
        Scene sceneklienci = new Scene(klienci);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneklienci);
        app_stage.show();
    }

    @FXML
    void btnProdukty(ActionEvent event) throws IOException{
        Parent produkty = FXMLLoader.load(getClass().getResource("produkty.FXML"));
        Scene sceneprodukty = new Scene(produkty);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneprodukty);
        app_stage.show();
    }

    @FXML
    void btnZamówienia(ActionEvent event) throws IOException{
        Parent produkty = FXMLLoader.load(getClass().getResource("zamowienia.FXML"));
        Scene scenezamowienia = new Scene(produkty);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scenezamowienia);
        app_stage.show();
    }

    @FXML
    private void initialize() throws Exception{
        colkl_id.setCellValueFactory(cellData -> cellData.getValue().getKlientId().asObject());
        colkl_imie.setCellValueFactory(cellData -> cellData.getValue().getKlientImie());
        colkl_nazwisko.setCellValueFactory(cellData -> cellData.getValue().getKlientNazwisko());
        colkl_miejscowosc.setCellValueFactory(cellData -> cellData.getValue().getKlientMiejscowosc());
        colkl_ulica.setCellValueFactory(cellData -> cellData.getValue().getKlientUlica());
        colkl_nrMieszkania.setCellValueFactory(cellData -> cellData.getValue().getKlientnrMieszkania());
        colkl_nrTelefonu.setCellValueFactory(cellData -> cellData.getValue().getKlientnrTelefonu().asObject());
        colkl_email.setCellValueFactory(cellData -> cellData.getValue().getKlientEmail());
        ObservableList<Klienci> klienciList = UserController.getAllRecords();
        populateTable(klienciList);
    }

    private void populateTable(ObservableList<Klienci> klienciList) {
        KlienciTable.setItems(klienciList);
    }

    @FXML
    private TextField txtImie;
    @FXML
    private TextField txtNazwisko;
    @FXML
    private TextField txtMiejscowosc;
    @FXML
    private TextField txtUlica;
    @FXML
    private TextField txtnrMieszkania;
    @FXML
    private TextField txtnrTelefonu;
    @FXML
    private TextField txtEmail;

    @FXML
    private void dodajKlienta(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            KlienciDAO.dodajKlienta(txtImie.getText(), txtNazwisko.getText(), txtMiejscowosc.getText(),txtUlica.getText(),txtnrMieszkania.getText(),txtnrTelefonu.getText(),txtEmail.getText());
            resultConsole.setText("Sukces! Wartości zostały dodane.");
            ObservableList<Klienci> klienciList = UserController.getAllRecords();
            populateTable(klienciList);
        }catch(SQLException e){
            System.out.println("Wystąpił błąd w wartościach."+e);
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    private TextField searchId;

    @FXML
    private TextField searchEmail;

    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            KlienciDAO.update(Integer.parseInt(searchId.getText()),searchEmail.getText());
            resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            ObservableList<Klienci> klienciList = UserController.getAllRecords();
            populateTable(klienciList);
        }catch (SQLException e){
            System.out.println("Wystąpił błąd podczas aktualizacji danych"+e);
            e.printStackTrace();
            throw e;

        }
    }

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            KlienciDAO.deleteByID(Integer.parseInt(searchId.getText()));
            resultConsole.setText("Klient usunięty pomyślnie.");
            ObservableList<Klienci> klienciList = UserController.getAllRecords();
            populateTable(klienciList);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu Klienta: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }


}
