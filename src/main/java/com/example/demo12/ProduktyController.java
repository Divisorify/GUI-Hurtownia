package com.example.demo12;


import DataAccessObject.ProduktyDAO;
import entities.Produkty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;

import static DataAccessObject.ProduktyDAO.getAllRecords;

public class ProduktyController {
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView Table;

    @FXML
    private TableColumn<Produkty, Integer> colprod_id;
    @FXML
    private TableColumn<Produkty, Integer> coldost_id;
    @FXML
    private TableColumn<Produkty, String> colprod_nazwa;
    @FXML
    private TableColumn<Produkty, Double> colprod_cena;
    @FXML
    private TableColumn<Produkty, String> colprod_waluta;
    @FXML
    private TableColumn<Produkty, String> colprod_kraj;


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
        Table.setEditable(true);
        colprod_id.setCellValueFactory(cellData -> cellData.getValue().prod_idPropertyProperty().asObject());
        colprod_id.setOnEditCommit(
                (TableColumn.CellEditEvent<Produkty, Integer> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setProd_id(t.getNewValue())
        );
        coldost_id.setCellValueFactory(cellData -> cellData.getValue().dost_idPropertyProperty().asObject());
        colprod_nazwa.setCellValueFactory(cellData -> cellData.getValue().prod_nazwaPropertyProperty());
        colprod_nazwa.setEditable(true);
        Callback<TableColumn<Produkty, String>, TableCell<Produkty, String>> defaultCellFactory
                = TextFieldTableCell.forTableColumn();

        colprod_nazwa.setCellFactory(col -> {
            TableCell<Produkty, String> cell = defaultCellFactory.call(col);
            //cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });

        colprod_nazwa.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Produkty, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Produkty, String> t) {
                        Produkty produkty = t.getRowValue();
                        produkty.setProd_nazwa(t.getNewValue());
                    }
            }
        );
        colprod_cena.setCellValueFactory(cellData -> cellData.getValue().prod_cenaPropertyProperty().asObject());
        colprod_waluta.setCellValueFactory(cellData -> cellData.getValue().prod_walutaPropertyProperty());
        colprod_kraj.setCellValueFactory(cellData -> cellData.getValue().prod_krajPropertyProperty());
        ObservableList<Produkty> List = getAllRecords();
        populateTable(List);
    }

    private void populateTable(ObservableList<Produkty> List) {
        Table.setItems(List);
    }

    @FXML
    private void search(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchByID(searchId.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Produkt został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego produktu.");
        }
    }

    @FXML
    private void searchAll(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> List = getAllRecords();
        populateTable(List);
    }

    @FXML
    private TextField txtIdDostawcy;
    @FXML
    private TextField txtNazwaProduktu;
    @FXML
    private TextField txtCena;
    @FXML
    private TextField txtWaluta;
    @FXML
    private TextField txtKrajProdukcji;

    @FXML
    private void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            ProduktyDAO.dodaj(txtIdDostawcy.getText(), txtNazwaProduktu.getText(), txtCena.getText(),txtWaluta.getText(),txtKrajProdukcji.getText());
            resultConsole.setText("Sukces! Wartości zostały dodane.");
            ObservableList<Produkty> List = getAllRecords();
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
    private TextField searchNazwa;

    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            ProduktyDAO.update(Integer.parseInt(searchId.getText()),searchNazwa.getText());
            resultConsole.setText("Sukces! Dane zostały zaktualizowane.");
            ObservableList<Produkty> List = getAllRecords();
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
            ProduktyDAO.deleteByID(Integer.parseInt(searchId.getText()));
            resultConsole.setText("Produkt usunięty pomyślnie.");
            ObservableList<Produkty> List = getAllRecords();
            populateTable(List);
        }catch(SQLException e){
            System.out.println("Błąd przy usuwaniu produktu "+ searchId);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private TextField txtIdProduktysearch;
    @FXML
    private TextField txtIdDostawcysearch;
    @FXML
    private TextField txtNazwaProduktusearch;
    @FXML
    private TextField txtCenasearch;
    @FXML
    private TextField txtWalutasearch;
    @FXML
    private TextField txtKrajProdukcjisearch;

    @FXML
    private void advencedsearchProd_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchprod_id(txtIdProduktysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("ID produktu zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono takiego ID produktu.");
        }
    }
    @FXML
    private void advencedsearchDost_id(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchdost_id(txtIdDostawcysearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("ID dostawcy zostało znalezione.");
        }else{
            resultConsole.setText("Nie znaleziono takiego ID dostawcy.");
        }
    }
    @FXML
    private void advencedsearchProd_nazwa(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchprod_nazwa(txtNazwaProduktusearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Nazwa produktu została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej nazwy produktu.");
        }
    }
    @FXML
    private void advencedsearchProd_cena(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchprod_cena(txtCenasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Cena produktu została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej ceny produktu.");
        }
    }
    @FXML
    private void advencedsearchProd_waluta(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchprod_waluta(txtWalutasearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Waluta produktu została znaleziona.");
        }else{
            resultConsole.setText("Nie znaleziono takiej waluty produktu.");
        }
    }

    @FXML
    private void advencedsearchProd_kraj(ActionEvent event)throws ClassNotFoundException,SQLException{
        ObservableList<Produkty> list = ProduktyDAO.searchprod_kraj(txtKrajProdukcjisearch.getText());
        populateTable(list);
        if(list.size()>0){
            populateTable(list);
            resultConsole.setText("Kraj produkcji został znaleziony.");
        }else{
            resultConsole.setText("Nie znaleziono takiego kraju produkcji.");
        }
    }

//    private void edit(ActionEvent event) {
//        colprod_nazwa.setEditable(true);
//        Callback<TableColumn<Produkty, String>, TableCell<Produkty, String>> defaultCellFactory
//                = TextFieldTableCell.forTableColumn();
//
//        colprod_nazwa.setCellFactory(col -> {
//            TableCell<Produkty, String> cell = defaultCellFactory.call(col);
//            //cell.setAlignment(Pos.CENTER_LEFT);
//            return cell;
//        });
//
//        colprod_nazwa.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Produkty, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Produkty, String> t) {
//                        ((Produkty) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())).setProd_nazwa(t.getNewValue());
//                    }
//                }
//        );
//    }

}
