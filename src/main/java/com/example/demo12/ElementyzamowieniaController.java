package com.example.demo12;

import DataAccessObject.ElementyzamowieniaDAO;
import DataAccessObject.ProduktyDAO;
import entities.Elementyzamowienia;
import entities.Produkty;
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

import static DataAccessObject.ElementyzamowieniaDAO.getAllRecords;

public class ElementyzamowieniaController {
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView Table;

    @FXML
    private TableColumn<Elementyzamowienia, Integer> colzam_id;
    @FXML
    private TableColumn<Elementyzamowienia, Integer> colzam_numer;
    @FXML
    private TableColumn<Elementyzamowienia, Integer> colzam_elem;
    @FXML
    private TableColumn<Elementyzamowienia, Integer> colprod_id;
    @FXML
    private TableColumn<Elementyzamowienia, Integer> colilosc;
    @FXML
    private TableColumn<Elementyzamowienia, Double> colcena_elem;
    @FXML
    private TableColumn<Elementyzamowienia, String> colwaluta;

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
        colzam_id.setCellValueFactory(cellData -> cellData.getValue().zam_idPropertyProperty().asObject());
        colzam_numer.setCellValueFactory(cellData -> cellData.getValue().zam_numerPropertyProperty().asObject());
        colzam_elem.setCellValueFactory(cellData -> cellData.getValue().zam_elemPropertyProperty().asObject());
        colprod_id.setCellValueFactory(cellData -> cellData.getValue().prod_idPropertyProperty().asObject());
        colilosc.setCellValueFactory(cellData -> cellData.getValue().iloscPropertyProperty().asObject());
        colcena_elem.setCellValueFactory(cellData -> cellData.getValue().cena_elemPropertyProperty().asObject());
        colwaluta.setCellValueFactory(cellData -> cellData.getValue().walutaPropertyProperty());
        ObservableList<Elementyzamowienia> List = getAllRecords();
        populateTable(List);
    }

    private void populateTable(ObservableList<Elementyzamowienia> List) {
        Table.setItems(List);
    }

    @FXML
    private void search(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchByID(searchId.getText());
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
        ObservableList<Elementyzamowienia> List = getAllRecords();
        populateTable(List);
    }

    @FXML
    private TextField txtZamNumer;
    @FXML
    private TextField txtZamElem;
    @FXML
    private TextField txtProdId;
    @FXML
    private TextField txtIlosc;
    @FXML
    private TextField txtCenaElem;
    @FXML
    private TextField txtWaluta;

    @FXML
    private void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            ElementyzamowieniaDAO.dodaj(txtZamNumer.getText(), txtZamElem.getText(), txtProdId.getText(),txtIlosc.getText(),txtCenaElem.getText(),txtWaluta.getText());
            resultConsole.setText("Sukces! Wartości zostały dodane.");
            ObservableList<Elementyzamowienia> List = getAllRecords();
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
    private TextField searchEmail;

    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            ElementyzamowieniaDAO.update(Integer.parseInt(searchId.getText()),searchEmail.getText());
            resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            ObservableList<Elementyzamowienia> List = getAllRecords();
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
            ElementyzamowieniaDAO.deleteByID(Integer.parseInt(searchId.getText()));
            resultConsole.setText("Usunięto pomyślnie.");
            ObservableList<Elementyzamowienia> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu ID: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private TextField txtIdZamowieniasearch;
    @FXML
    private TextField txtNumZamowieniasearch;
    @FXML
    private TextField txtElemZamowieniasearch;
    @FXML
    private TextField txtIdProduktusearch;
    @FXML
    private TextField txtIloscsearch;
    @FXML
    private TextField txtCenaElemsearch;
    @FXML
    private TextField txtwalutasearch;

    @FXML
    private void advencedsearchZam_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchzam_id(txtIdZamowieniasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Element zamówienia został znaleziony po ID.");
        }else{
            resultConsole.setText("Nie znaleziono takiego elementu zamówienia.");
        }
    }
    @FXML
    private void advencedsearchZam_numer(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchzam_numer(txtNumZamowieniasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Numer elementu zamówienia został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego numeru elementu zamówienia.");
        }
    }
    @FXML
    private void advencedsearchZam_elem(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchzam_elem(txtElemZamowieniasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Element zamówienia został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego elementu zamówienia.");
        }
    }
    @FXML
    private void advencedsearchProd_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchprod_id(txtIdProduktusearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Element zamówienia został znaleziony po ID produktu.");
        }else{
            resultConsole.setText("Nie znaleziono takiego ID produktu.");
        }
    }
    @FXML
    private void advencedsearchIlosc(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchilosc(txtIloscsearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Ilość elementów zamówienia została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej ilości elementów zamówienia.");
        }
    }@FXML
    private void advencedsearchCena_elem(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchcena_elem(txtCenaElemsearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Cena elementu zamówienia została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej ceny elementu zamówienia.");
        }
    }@FXML
    private void advencedsearchWaluta(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Elementyzamowienia> list = ElementyzamowieniaDAO.searchwaluta(txtwalutasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Waluta elementu zamówienia została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej waluty elementu zamówienia.");
        }
    }


}
