package DataAccessObject;

import com.example.demo12.DBUtil;
import entities.Produkty;
import entities.Zamowienia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZamowieniaDAO {
    public static ObservableList<Zamowienia> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from Zamowienia";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Zamowienia> List = getObjects(rsSet);
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Zamowienia> getObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Zamowienia> List = FXCollections.observableArrayList();

            while(rsSet.next()){
                Zamowienia kli = new Zamowienia();
                kli.setZam_numerProperty(rsSet.getInt("zam_numer"));
                kli.setZam_dataProperty(rsSet.getString("zam_data"));
                kli.setKl_idProperty(rsSet.getInt("kl_id"));
                List.add(kli);
            }
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }

    }

    public static void dodaj(String data, String id) throws SQLException,ClassNotFoundException{
        String sql = "insert into Zamowienia(zam_data,kl_id)values(' "+data+"', '"+id+"')";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Wyjątek przy dodawaniu elementu"+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void update(int zamnumer,String data) throws ClassNotFoundException,SQLException {
        String sql = "update Zamowienia set zam_data = '" + data + "' where zam_numer = '" + zamnumer + "' ";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            throw e;
        }
    }

    public static void delete(int numer) throws ClassNotFoundException,SQLException {
        String sql = "delete from Zamowienia where zam_numer = '" + numer + "'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Zamowienia> search(String zamnumer) throws ClassNotFoundException,SQLException{
        String sql = "select * from Zamowienia where zam_numer = "+zamnumer;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Zamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po numerze zamówienia "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Zamowienia> searchzam_numer(String numer) throws ClassNotFoundException,SQLException{
        String sql = "select * from zamowienia where zam_numer like '%"+numer+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Zamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po numerze zamówienia. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Zamowienia> searchzam_data(String data) throws ClassNotFoundException,SQLException{
        String sql = "select * from zamowienia where zam_data like '%"+data+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Zamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po dacie. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Zamowienia> searchkl_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from zamowienia where kl_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Zamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
