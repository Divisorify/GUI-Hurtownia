package com.example.demo12;

import DataAccessObject.HistorycznaDAO;
import entities.Historyczna;
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
import java.sql.SQLException;

import static DataAccessObject.HistorycznaDAO.getAllRecords;

public class HistorycznaController {
    //Pole do wypisywania rezultatów oraz stworzenie tabeli
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView Table;

    //Tworzenie kolumn
    @FXML
    private TableColumn<Historyczna, Integer> colhist_id;
    @FXML
    private TableColumn<Historyczna, Integer> colzam_numer;
//    @FXML
//    private TableColumn<Historyczna, String> colzam_data;
//    @FXML
//    private TableColumn<Historyczna, Integer> colkl_id;

    //Przyciski do zmiany tabel
    @FXML
    void btnDostawcy(ActionEvent event) throws IOException {
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
    void btnHistoryczna(ActionEvent event) throws IOException {
        Parent historyczna = FXMLLoader.load(getClass().getResource("historyczna.fxml"));
        Scene scenehistoryczna = new Scene(historyczna);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scenehistoryczna);
        app_stage.show();
    }

    @FXML
    private void initialize() throws Exception{
        Table.setEditable(true);  //Ustawienie możliwości edytowania tabeli

        //Wypisanie danych z bazy
        colhist_id.setCellValueFactory(cellData -> cellData.getValue().hist_idPropertyProperty().asObject());
        colzam_numer.setCellValueFactory(cellData -> cellData.getValue().zam_numerPropertyProperty().asObject());
//        colzam_data.setCellValueFactory(cellData -> cellData.getValue().zam_dataPropertyProperty());
//        colkl_id.setCellValueFactory(cellData -> cellData.getValue().kl_idPropertyProperty().asObject());

        //Edycja komórki
        colhist_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colzam_numer.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        colzam_data.setCellFactory(TextFieldTableCell.forTableColumn());
//        colkl_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        ObservableList<Historyczna> List = getAllRecords();
        populateTable(List);
    }

    private void populateTable(ObservableList<Historyczna> List) {
        Table.setItems(List);
    }

    //Wyszukiwanie pojedyńczej komórki po ID
    @FXML
    private void search(ActionEvent event)throws ClassNotFoundException, SQLException {
        ObservableList<Historyczna> list = HistorycznaDAO.search(searchHistId.getText());
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
        ObservableList<Historyczna> List = getAllRecords();
        populateTable(List);
    }

//    //Pola tekstowe do dodania zamówienia
//    @FXML
//    private TextField txtZamData;
//    @FXML
//    private TextField txtKlId;
//
//    //Dodanie zamówienia
//    @FXML
//    private void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException {
//        try{
//            int query = ZamowieniaDAO.dodaj(txtZamData.getText(), txtKlId.getText());
//            if(query == 2){
//                resultConsole.clear();
//                resultConsole.setText("Wypełnij wszystkie komórki. ");
//            }else if (query == 0){
//                resultConsole.clear();
//                resultConsole.setText("Wpisz poprawne wartości w komórkach.");
//            }else if (query == 1){
//                resultConsole.clear();
//                resultConsole.setText("Sukces! Wartości zostały dodane.");
//            }
//            else if (query == 3){
//                resultConsole.setText("Wpisz poprawną datę.");
//            }
//            else if (query == 4){
//                resultConsole.clear();
//                resultConsole.setText("Wpisz poprawne id Klienta.");
//            }else if (query == 10){
//                resultConsole.clear();
//                resultConsole.setText("Nie ma klienta z takim numerem ID w tabeli Klienci.");
//            }
//            ObservableList<Zamowienia> List = getAllRecords();
//            populateTable(List);
//        }catch(SQLException e){
//            System.out.println("Wystąpił błąd w wartościach."+e);
//            e.printStackTrace();
//            throw e;
//        }
//    }

    //Pola tekstowe do wyszukiwania
    @FXML
    private TextField searchHistId;
    @FXML
    private TextField searchId;
    @FXML
    private TextField searchZamNumer;
    @FXML
    private TextField updateDataZam;
    @FXML
    private TextField updateZamNumer;

    //Aktualizacja
    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            int query = HistorycznaDAO.update(searchHistId.getText(),updateZamNumer.getText());
            if(query == 1){
                resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            }else if (query == 2){
                resultConsole.setText("Wpisz poprawną datę do zaktualizowania. ");
            }else if (query == 3){
                resultConsole.setText("Wpisz poprawny numer zamówienia do zaktualizowania.");
            }else if (query == 4){
                resultConsole.setText("Wpisz numer zamówienia oraz zaktualizowaną datę.");
            }
            ObservableList<Historyczna> List = getAllRecords();
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
            int query = HistorycznaDAO.delete(Integer.parseInt(searchHistId.getText()));
            if (query == 1){
                resultConsole.setText("Usunięto pomyślnie.");
            }else if (query == 10){
                resultConsole.setText("Nie można usunąć tego zamówienia, ponieważ znajduje się ono w tabeli ElementyZamówienia.");
            }
            ObservableList<Historyczna> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu numerze zamówienia: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }

    //Pola tekstowe do wyszukiwania
    @FXML
    private TextField txtHistIDsearch;
    @FXML
    private TextField txtZamNumersearch;
    @FXML
    private TextField txtZamDatasearch;
    @FXML
    private TextField txtKlIdsearch;

    @FXML
    private void advencedsearchhist_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Historyczna> list = HistorycznaDAO.searchkl_id(txtHistIDsearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Zamówienie zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono takiego zamówienia po ID.");
        }
    }

    @FXML
    private void advencedsearchkl_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Historyczna> list = HistorycznaDAO.searchkl_id(txtKlIdsearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Zamówienie zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono takiego zamówienia po ID.");
        }
    }

    @FXML
    private void advencedsearchzam_data(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Historyczna> list = HistorycznaDAO.searchzam_data(txtZamDatasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Zamówienie z taką datą zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono zamówienia z taką datą.");
        }
    }

    @FXML
    private void advencedsearchzam_numer(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Historyczna> list = HistorycznaDAO.searchzam_numer(txtZamNumersearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Zamówienie zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono takiego numeru zamówienia.");
        }
    }
}
