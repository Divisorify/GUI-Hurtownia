package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class KlienciController {

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
    private void dodajKlienta(ActionEvent event) throws ClassNotFoundException, SQLException{
        KlienciDAO.dodajKlienta(txtImie.getText(), txtNazwisko.getText(), txtMiejscowosc.getText(),txtUlica.getText(),txtnrMieszkania.getText(),txtnrTelefonu.getText(),txtEmail.getText());
    }
}
