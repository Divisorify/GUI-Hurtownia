package DataAccessObject;

import com.example.demo12.DBUtil;
import entities.Elementyzamowienia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementyzamowieniaDAO {
    public static ObservableList<Elementyzamowienia> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from Elementyzamowienia";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia> List = getObjects(rsSet);
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Elementyzamowienia> getObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Elementyzamowienia> List = FXCollections.observableArrayList();

            while(rsSet.next()){
                Elementyzamowienia kli = new Elementyzamowienia();
                kli.setZam_idProperty(rsSet.getInt("zam_id"));
                kli.setZam_numerProperty(rsSet.getInt("zam_numer"));
                kli.setZam_elemProperty(rsSet.getInt("zam_elem"));
                kli.setProd_idProperty(rsSet.getInt("prod_id"));
                kli.setIloscProperty(rsSet.getInt("ilosc"));
                kli.setCena_elemProperty(rsSet.getDouble("cena_elem"));
                kli.setWalutaProperty(rsSet.getString("waluta"));
                List.add(kli);
            }
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }

    }

    public static void dodaj(String numer,Integer element, int prod_id, String ilosc,Double cenaelem,String waluta ) throws SQLException,ClassNotFoundException{
        String sql = "insert into Elementyzamowienia(zam_numer,zam_elem,prod_id,ilosc,cena_elem,waluta)values('"+numer+"', '"+element+"', '"+prod_id+"', '"+ilosc+"', '"+cenaelem+"', '"+waluta+"')";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Wyjątek przy dodawaniu elementu"+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void update(int id,String ilosc) throws ClassNotFoundException,SQLException {
        String sql = "update Elementyzamowienia set ilosc = '" + ilosc + "' where zam_id = '" + id + "' ";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteByID(int id) throws ClassNotFoundException,SQLException {
        String sql = "delete from Elementyzamowienia where zam_id = '" + id + "'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Elementyzamowienia> searchByID(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where zam_id = "+id;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
