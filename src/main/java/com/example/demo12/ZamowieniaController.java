package com.example.demo12;

import DataAccessObject.ZamowieniaDAO;
import entities.Zamowienia;
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

import java.io.IOException;
import java.sql.SQLException;

import static DataAccessObject.ZamowieniaDAO.getAllRecords;

public class ZamowieniaController {

    @FXML
    private TableColumn<Zamowienia, Integer> colzam_numer;
    @FXML
    private TableColumn<Zamowienia, String> colzam_data;
    @FXML
    private TableColumn<Zamowienia, Integer> colkl_id;


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
        colzam_numer.setCellValueFactory(cellData -> cellData.getValue().zam_numerPropertyProperty().asObject());
        colzam_data.setCellValueFactory(cellData -> cellData.getValue().zam_dataPropertyProperty());
        colkl_id.setCellValueFactory(cellData -> cellData.getValue().kl_idPropertyProperty().asObject());
        ObservableList<Zamowienia> List = getAllRecords();
        populateTable(List);
    }

    private void populateTable(ObservableList<Zamowienia> List) {
        Table.setItems(List);
    }

    @FXML
    private void search(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Zamowienia> list = ZamowieniaDAO.search(searchZamNumer.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Znaleziono.");
        }else{
            resultConsole.setText("Nie znaleziono.");
        }
    }

    @FXML
    private void searchAll(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Zamowienia> List = getAllRecords();
        populateTable(List);
    }

    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView Table;

    @FXML
    private TextField txtZamData;
    @FXML
    private TextField txtKlId;


    @FXML
    private void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            ZamowieniaDAO.dodaj(txtZamData.getText(), txtKlId.getText());
            resultConsole.setText("Sukces! Wartości zostały dodane.");
            ObservableList<Zamowienia> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Wystąpił błąd w wartościach."+e);
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    private TextField searchId;

    @FXML
    private TextField searchZamNumer;

    @FXML
    private TextField updateDataZam;

    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            ZamowieniaDAO.update(Integer.parseInt(searchZamNumer.getText()),updateDataZam.getText());
            resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            ObservableList<Zamowienia> List = getAllRecords();
            populateTable(List);
        }catch (SQLException e){
            System.out.println("Wystąpił błąd podczas aktualizacji danych"+e);
            e.printStackTrace();
            throw e;

        }
    }

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ZamowieniaDAO.delete(Integer.parseInt(searchZamNumer.getText()));
            resultConsole.setText("Usunięto pomyślnie.");
            ObservableList<Zamowienia> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu numerze zamówienia: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }
}
