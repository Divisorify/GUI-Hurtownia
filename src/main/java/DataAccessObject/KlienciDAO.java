package DataAccessObject;

import com.example.demo12.DBUtil;
import entities.Klienci;
import entities.Produkty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KlienciDAO {

    public static ObservableList<Klienci> getAllRecordsKlienci() throws ClassNotFoundException, SQLException {
        String sql = "select * from Klienci";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci> klienciList = getKlienciObjects(rsSet);
            return klienciList;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Klienci> getKlienciObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Klienci> klienciList = FXCollections.observableArrayList();

            while(rsSet.next()){
                Klienci kli = new Klienci();
                kli.setKlient_id(rsSet.getInt("kl_id"));
                kli.setKl_imieProperty(rsSet.getString("kl_imie"));
                kli.setKl_nazwiskoProperty(rsSet.getString("kl_nazwisko"));
                kli.setKl_miejscowoscProperty(rsSet.getString("kl_miejscowosc"));
                kli.setKl_ulicaProperty(rsSet.getString("kl_ulica"));
                kli.setKl_nrMieszkaniaProperty(rsSet.getString("kl_nrMieszkania"));
                kli.setKl_nrTelefonuProperty(rsSet.getInt("kl_nrTelefonu"));
                kli.setKl_emailProperty(rsSet.getString("kl_email"));
                klienciList.add(kli);
            }
            return klienciList;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }

    }

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

    public static ObservableList<Klienci> searchByID(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from klienci where kl_id = "+id;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Klienci> searchkl_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_imie(String imie) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_imie like '%"+imie+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu imienia klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_nazwisko(String nazwisko) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_nazwisko like '%"+nazwisko+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu nazwiska klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_miejscowosc(String miejscowosc) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_miejscowosc like '%"+miejscowosc+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu miejscowości klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_ulica(String ulica) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_ulica like '%"+ulica+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu ulicy klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_nrMieszkania(String nrMieszkania) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_nrMieszkania like '%"+nrMieszkania+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu numeru mieszkania klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_nrTel(String nrTel) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_nrTelefonu like '%"+nrTel+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu numeru telefonu klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Klienci> searchkl_email(String email) throws ClassNotFoundException,SQLException{
        String sql = "select * from Klienci where kl_email like '%"+email+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Klienci>  list = getKlienciObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu emailu klienta. "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
