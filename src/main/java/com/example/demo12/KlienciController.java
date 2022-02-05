package com.example.demo12;

import DataAccessObject.KlienciDAO;
import DataAccessObject.ProduktyDAO;
import entities.Klienci;
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
import java.sql.SQLException;

import static DataAccessObject.KlienciDAO.getAllRecordsKlienci;

public class KlienciController {
    //Pole do wypisywania rezultatów oraz stworzenie tabeli
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView KlienciTable;

    //Tworzenie kolumn
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
        KlienciTable.setEditable(true); //Ustawienie możliwości edytowania tabeli

        //Wypisanie danych z bazy
        colkl_id.setCellValueFactory(cellData -> cellData.getValue().getKlientId().asObject());
        colkl_imie.setCellValueFactory(cellData -> cellData.getValue().getKlientImie());
        colkl_nazwisko.setCellValueFactory(cellData -> cellData.getValue().getKlientNazwisko());
        colkl_miejscowosc.setCellValueFactory(cellData -> cellData.getValue().getKlientMiejscowosc());
        colkl_ulica.setCellValueFactory(cellData -> cellData.getValue().getKlientUlica());
        colkl_nrMieszkania.setCellValueFactory(cellData -> cellData.getValue().getKlientnrMieszkania());
        colkl_nrTelefonu.setCellValueFactory(cellData -> cellData.getValue().getKlientnrTelefonu().asObject());
        colkl_email.setCellValueFactory(cellData -> cellData.getValue().getKlientEmail());

        //Edycja komórki
        colkl_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colkl_imie.setCellFactory(TextFieldTableCell.forTableColumn());
        colkl_nazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
        colkl_miejscowosc.setCellFactory(TextFieldTableCell.forTableColumn());
        colkl_ulica.setCellFactory(TextFieldTableCell.forTableColumn());
        colkl_nrMieszkania.setCellFactory(TextFieldTableCell.forTableColumn());
        colkl_nrTelefonu.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colkl_email.setCellFactory(TextFieldTableCell.forTableColumn());

        ObservableList<Klienci> klienciList = getAllRecordsKlienci();
        populateTableKlienci(klienciList);
    }

    private void populateTableKlienci(ObservableList<Klienci> klienciList) {
        KlienciTable.setItems(klienciList);
    }

    //Wyszukiwanie pojedyńczej komórki po ID
    @FXML
    private void searchKlienci(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchByID(searchId.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Klient został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego Klienta.");
        }
    }

    //Wyszukiwanie wszystkich wierszy
    @FXML
    private void searchAllKlienci(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> kliList = getAllRecordsKlienci();
        populateTableKlienci(kliList);
    }

    //Pola tekstowe do dodania klienta
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

    //Dodanie klienta
    @FXML
    private void dodajKlienta(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            int query = KlienciDAO.dodajKlienta(txtImie.getText(), txtNazwisko.getText(), txtMiejscowosc.getText(),txtUlica.getText(),txtnrMieszkania.getText(),txtnrTelefonu.getText(),txtEmail.getText());
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
//                resultConsole.setText("Wpisz poprawne imię.");
//            }else if (query == 4){
//                resultConsole.setText("Wpisz poprawne nazwisko.");
//            }else if (query == 5){
//                resultConsole.setText("Wpisz poprawną miejscowość.");
//            }else if (query == 6){
//                resultConsole.setText("Wpisz poprawną ulicę.");
//            }else if (query == 7){
//                resultConsole.setText("Wpisz poprawny numer mieszkania.");
//            }
            else if (query == 8){
                resultConsole.clear();
                resultConsole.setText("Wpisz poprawny numer telefonu.");
            }
//            else if (query == 9){
//                resultConsole.setText("Wpisz poprawny email.");
//            }
            ObservableList<Klienci> klienciList = getAllRecordsKlienci();
            populateTableKlienci(klienciList);
        }catch(SQLException e){
            resultConsole.clear();
            resultConsole.setText("Wystąpił błąd w wartościach."+e);
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
    private void updateKlienci(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            int query = KlienciDAO.update(searchId.getText(),searchEmail.getText());
            if(query == 1){
                resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            }else if (query == 2){
                resultConsole.setText("Wpisz poprawny email.");
            }else if (query == 3){
                resultConsole.setText("Nie ma takiego ID klienta.");
            }else if (query == 4){
                resultConsole.setText("Wpisz ID klienta oraz email który chcesz zaktualizować.");
            }
            else if (query == 10){
                resultConsole.setText("Nie ma takiego ID Produktu.");
            }
            ObservableList<Klienci> klienciList = getAllRecordsKlienci();
            populateTableKlienci(klienciList);
        }catch (SQLException e){
            System.out.println("Wystąpił błąd podczas aktualizacji danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Usuwanie
    @FXML
    private void deleteKlienci(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            int query = KlienciDAO.deleteByID(Integer.parseInt(searchId.getText()));
            if (query == 1){
                resultConsole.setText("Klient usunięty pomyślnie.");
            }
            else if (query == 10){
                resultConsole.setText("Nie można usunąć tego klienta, ponieważ ma on złożone zamówienie.");
            }
            ObservableList<Klienci> klienciList = getAllRecordsKlienci();
            populateTableKlienci(klienciList);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu Klienta: "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }

    //Pola tekstowe do wyszukiwania
    @FXML
    private TextField txtIdKlientasearch;
    @FXML
    private TextField txtImieKlientasearch;
    @FXML
    private TextField txtNazwiskoKlientasearch;
    @FXML
    private TextField txtMiejscowoscKlientasearch;
    @FXML
    private TextField txtUlicaKlientasearch;
    @FXML
    private TextField txtnrMieszkaniaKlientasearch;
    @FXML
    private TextField txtnrTelefonuKlientasearch;
    @FXML
    private TextField txtEmailKlientasearch;

    @FXML
    private void advencedsearchKl_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_id(txtIdKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Klient został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono klienta o takim ID.");
        }
    }
    @FXML
    private void advencedsearchKl_imie(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_imie(txtImieKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Imię klienta zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono klienta o takim imieniu.");
        }
    }
    @FXML
    private void advencedsearchKl_nazwisko(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_nazwisko(txtNazwiskoKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Nazwisko klienta zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono klienta o takim nazwisku.");
        }
    }
    @FXML
    private void advencedsearchKl_miejscowosc(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_miejscowosc(txtMiejscowoscKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Miejscowość klienta została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej miejscowości.");
        }
    }
    @FXML
    private void advencedsearchKl_ulica(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_ulica(txtUlicaKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Ulica klienta została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej ulicy.");
        }
    }
    @FXML
    private void advencedsearchKl_nrMieszkania(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_nrMieszkania(txtnrMieszkaniaKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Numer mieszkania klienta został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego numeru mieszkania klienta.");
        }
    }
    @FXML
    private void advencedsearchKl_nrTelefonu(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_nrTel(txtnrTelefonuKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Numer telefonu klienta został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego numeru telefonu klienta.");
        }
    }
    @FXML
    private void advencedsearchKl_email(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Klienci> list = KlienciDAO.searchkl_email(txtEmailKlientasearch.getText());
        populateTableKlienci(list);
        if(list.size()>0){
            populateTableKlienci(list);
            resultConsole.setText("Email klienta został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego emaila klienta.");
        }
    }

}
