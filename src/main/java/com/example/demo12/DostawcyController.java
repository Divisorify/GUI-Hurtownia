package com.example.demo12;

import DataAccessObject.DostawcyDAO;
import DataAccessObject.ProduktyDAO;
import entities.Dostawcy;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DataAccessObject.DostawcyDAO.getAllRecords;

public class DostawcyController {
    //Pole do wypisywania rezultatów oraz stworzenie tabeli
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView Table;

    //Tworzenie kolumn
    @FXML
    private TableColumn<Dostawcy, Integer> coldost_id;
    @FXML
    private TableColumn<Dostawcy, String> coldost_nazwa;
    @FXML
    private TableColumn<Dostawcy, String> coldost_miejscowosc;
    @FXML
    private TableColumn<Dostawcy, String> coldost_ulica;
    @FXML
    private TableColumn<Dostawcy, String> coldost_kraj;
    @FXML
    private TableColumn<Dostawcy, String> coldost_email;

    //Przyciski do zmiany tabel
    @FXML
    void btnDostawcy(ActionEvent event) throws IOException{
        Parent dostawcy = FXMLLoader.load(getClass().getResource("dostawcy.fxml"));
        Scene scenedostawcy = new Scene(dostawcy);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scenedostawcy);
        app_stage.show();
    }

    @FXML
    void btnElementyZamówienia(ActionEvent event) throws IOException{
        Parent elementyzamowienia = FXMLLoader.load(getClass().getResource("elementyzamowienia.fxml"));
        Scene sceneelementyzamowienia = new Scene(elementyzamowienia);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneelementyzamowienia);
        app_stage.show();
    }

    @FXML
    void btnKlienci(ActionEvent event) throws IOException {
        Parent klienci = FXMLLoader.load(getClass().getResource("klienci.fxml"));
        Scene sceneklienci = new Scene(klienci);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneklienci);
        app_stage.show();

    }

    @FXML
    void btnProdukty(ActionEvent event) throws IOException{
        Parent produkty = FXMLLoader.load(getClass().getResource("produkty.fxml"));
        Scene sceneprodukty = new Scene(produkty);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(sceneprodukty);
        app_stage.show();
    }

    @FXML
    void btnZamówienia(ActionEvent event) throws IOException{
        Parent produkty = FXMLLoader.load(getClass().getResource("zamowienia.fxml"));
        Scene scenezamowienia = new Scene(produkty);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scenezamowienia);
        app_stage.show();
    }
    @FXML
    private void initialize() throws Exception{
        Table.setEditable(true); //Ustawienie możliwości edytowania tabeli

        //Wypisanie danych z bazy
        coldost_id.setCellValueFactory(cellData -> cellData.getValue().dost_idPropertyProperty().asObject());
        coldost_nazwa.setCellValueFactory(cellData -> cellData.getValue().dost_nazwaPropertyProperty());
        coldost_miejscowosc.setCellValueFactory(cellData -> cellData.getValue().dost_miejscowoscPropertyProperty());
        coldost_ulica.setCellValueFactory(cellData -> cellData.getValue().dost_ulicaPropertyProperty());
        coldost_kraj.setCellValueFactory(cellData -> cellData.getValue().dost_krajPropertyProperty());
        coldost_email.setCellValueFactory(cellData -> cellData.getValue().dost_emailPropertyProperty());

        //Edycja komórki
        coldost_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coldost_nazwa.setCellFactory(TextFieldTableCell.forTableColumn());
        coldost_miejscowosc.setCellFactory(TextFieldTableCell.forTableColumn());
        coldost_ulica.setCellFactory(TextFieldTableCell.forTableColumn());
        coldost_kraj.setCellFactory(TextFieldTableCell.forTableColumn());
        coldost_email.setCellFactory(TextFieldTableCell.forTableColumn());

        ObservableList<Dostawcy> List = getAllRecords();
        populateTable(List);
    }

    private void populateTable(ObservableList<Dostawcy> List) {
        Table.setItems(List);
    }

    //Wyszukiwanie pojedyńczej komórki po ID
    @FXML
    private void search(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchByID(searchId.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Znaleziono.");
        }else{
            resultConsole.setText("Nie znaleziono.");
        }
    }

    //Wyszukiwanie wszystkich wierszy
    @FXML
    private void searchAll(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> List = getAllRecords();
        populateTable(List);
    }

    //Pola tekstowe do dodania dostawcy
    @FXML
    private TextField txtNazwa;
    @FXML
    private TextField txtMiejscowosc;
    @FXML
    private TextField txtUlica;
    @FXML
    private TextField txtKraj;
    @FXML
    private TextField txtEmail;

    //Dodanie dostawcy z walidacją
    @FXML
    private void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            int query = DostawcyDAO.dodaj(txtNazwa.getText(), txtMiejscowosc.getText(),txtUlica.getText(),txtKraj.getText(),txtEmail.getText());
            if(query == 2){
                resultConsole.clear();
                resultConsole.setText("Wypełnij wszystkie komórki. ");
            }else if (query == 0){
                resultConsole.clear();
                resultConsole.setText("Wpisz poprawny email.");
            }else if (query == 1){
                resultConsole.clear();
                resultConsole.setText("Sukces! Wartości zostały dodane.");
            }
//            else if (query == 3){
//                resultConsole.setText("Wpisz poprawną nazwę.");
//            }else if (query == 4){
//                resultConsole.setText("Wpisz poprawną miejscowość.");
//            }else if (query == 5){
//                resultConsole.setText("Wpisz poprawną ulicę.");
//            }else if (query == 6){
//                resultConsole.setText("Wpisz poprawną nazwę kraju.");
//            }else if (query == 7){
//                resultConsole.setText("Wpisz poprawny email.");
//            }
            ObservableList<Dostawcy> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Wystąpił błąd w wartościach."+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Pola tekstowe do wyszukiwania
    @FXML
    private TextField searchId;
    @FXML
    private TextField searchEmail;

    //Aktualizacja
    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            DostawcyDAO.update(Integer.parseInt(searchId.getText()),searchEmail.getText());
            resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            ObservableList<Dostawcy> List = getAllRecords();
            populateTable(List);
        }catch (SQLException e){
            System.out.println("Wystąpił błąd podczas aktualizacji danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Usuwanie
    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            DostawcyDAO.deleteByID(Integer.parseInt(searchId.getText()));
            resultConsole.setText("Usunięto pomyślnie.");
            ObservableList<Dostawcy> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu ID: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }

    //Pola tekstowe do wyszukiwania
    @FXML
    private TextField txtIdDostawcysearch;
    @FXML
    private TextField txtNazwaDostawcysearch;
    @FXML
    private TextField txtMiejscowoscDostawcysearch;
    @FXML
    private TextField txtUlicasearch;
    @FXML
    private TextField txtKrajProdukcjisearch;
    @FXML
    private TextField txtEmailDostawcysearch;

    @FXML
    private void advencedsearchDost_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_id(txtIdDostawcysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("ID dostawcy został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego ID dostawcy.");
        }
    }
    @FXML
    private void advencedsearchDost_nazwa(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_nazwa(txtNazwaDostawcysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Nazwa dostawcy została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej nazwy dostawcy.");
        }
    }
    @FXML
    private void advencedsearchDost_miejscowosc(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_miejscowosc(txtMiejscowoscDostawcysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Miejscowość dostawcy została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej miejscowości dostawcy.");
        }
    }
    @FXML
    private void advencedsearchDost_ulica(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_ulica(txtUlicasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Ulica dostawcy została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiego kraju dostawcy.");
        }
    }
    @FXML
    private void advencedsearchDost_kraj(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_kraj(txtKrajProdukcjisearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Kraj dostawcy został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego kraju dostawcy.");
        }
    }

    @FXML
    private void advencedsearchDost_email(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Dostawcy> list = DostawcyDAO.searchdost_email(txtEmailDostawcysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Email dostawcy został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego emaila dostawcy.");
        }
    }


}
