package DataAccessObject;

import com.example.demo12.DBUtil;
import com.example.demo12.HelloController;
import com.example.demo12.UserController;
import entities.Klienci;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class KlienciDAO {

//    @FXML
//    private TableColumn<Klienci, Integer> colkl_id;
//    @FXML
//    private TableColumn<Klienci, String> colkl_imie;
//    @FXML
//    private TableColumn<Klienci, String> colkl_nazwisko;
//    @FXML
//    private TableColumn<Klienci, String> colkl_miejscowosc;
//    @FXML
//    private TableColumn<Klienci, String> colkl_ulica;
//    @FXML
//    private TableColumn<Klienci, String> colkl_nrMieszkania;
//    @FXML
//    private TableColumn<Klienci, Integer> colkl_nrTelefonu;
//    @FXML
//    private TableColumn<Klienci, String> colkl_email;
//
//    @FXML
//    private TableView KlienciTable;
//    @FXML
//    private void populateTable(ObservableList<Klienci> klienciList) {
//        KlienciTable.setItems(klienciList);
//    }
//
//    @FXML
//    public void initialize() throws Exception{
//        colkl_id.setCellValueFactory(cellData -> cellData.getValue().getKlientId().asObject());
//        colkl_imie.setCellValueFactory(cellData -> cellData.getValue().getKlientImie());
//        colkl_nazwisko.setCellValueFactory(cellData -> cellData.getValue().getKlientNazwisko());
//        colkl_miejscowosc.setCellValueFactory(cellData -> cellData.getValue().getKlientMiejscowosc());
//        colkl_ulica.setCellValueFactory(cellData -> cellData.getValue().getKlientUlica());
//        colkl_nrMieszkania.setCellValueFactory(cellData -> cellData.getValue().getKlientnrMieszkania());
//        colkl_nrTelefonu.setCellValueFactory(cellData -> cellData.getValue().getKlientnrTelefonu().asObject());
//        colkl_email.setCellValueFactory(cellData -> cellData.getValue().getKlientEmail());
//        ObservableList<Klienci> klienciList = UserController.getAllRecords();
//        populateTable(klienciList);
//    }

    public static void dodajKlienta(String imie,String nazwisko,String miejscowosc, String ulica, String nrMieszkania, String nrTelefonu, String email) throws SQLException,ClassNotFoundException{
        String sql = "insert into klienci(kl_imie,kl_nazwisko,kl_miejscowosc,kl_ulica,kl_nrMieszkania,kl_nrTelefonu,kl_email)values(' "+imie+"', '"+nazwisko+"', '"+miejscowosc+"', '"+ulica+"', '"+nrMieszkania+"', '"+nrTelefonu+"', '"+email+"')";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Wyjątek przy dodawaniu klienta"+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void update(int id,String email) throws ClassNotFoundException,SQLException {
        String sql = "update Klienci set kl_email = '" + email + "' where kl_id = '" + id + "' ";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteByID(int id) throws ClassNotFoundException,SQLException {
        String sql = "delete from klienci where kl_id = '" + id + "'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            throw e;
        }
    }
}
