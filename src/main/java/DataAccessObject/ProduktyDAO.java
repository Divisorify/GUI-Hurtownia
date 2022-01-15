package DataAccessObject;

import com.example.demo12.DBUtil;
import entities.Produkty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduktyDAO {
    //Wypisanie wszystkich produktów
    public static ObservableList<Produkty> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from Produkty";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty> List = getObjects(rsSet);
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Przyporządkowanie danych kolumnom
    private static ObservableList<Produkty> getObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Produkty> List = FXCollections.observableArrayList();

            while(rsSet.next()){
                Produkty kli = new Produkty();
                kli.setProd_idProperty(rsSet.getInt("prod_id"));
                kli.setDost_idProperty(rsSet.getInt("dost_id"));
                kli.setProd_nazwaProperty(rsSet.getString("prod_nazwa"));
                kli.setProd_cenaProperty(rsSet.getDouble("prod_cena"));
                kli.setProd_walutaProperty(rsSet.getString("prod_waluta"));
                kli.setProd_krajProperty(rsSet.getString("prod_kraj"));
                List.add(kli);
            }
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Dodanie produktu
    public static void dodaj(String Dost_id, String nazwa, String cena, String waluta, String kraj) throws SQLException,ClassNotFoundException{
        String sql = "insert into produkty(dost_id,prod_nazwa,prod_cena,prod_waluta,prod_kraj)values(' "+Dost_id+"', '"+nazwa+"', '"+cena+"', '"+waluta+"', '"+kraj+"')";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Wyjątek przy dodawaniu elementu"+ e);
            e.printStackTrace();
            throw e;
        }
    }

    //Aktualizacja nazwy produktu
    public static void update(int id,String nazwa) throws ClassNotFoundException,SQLException {
        String sql = "update produkty set prod_nazwa = '" + nazwa + "' where prod_id = '" + id + "' ";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            throw e;
        }
    }

    //Usunięcie produktu po ID
    public static void deleteByID(int id) throws ClassNotFoundException,SQLException {
        String sql = "delete from produkty where prod_id = '" + id + "'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            throw e;
        }
    }

    //Wyszukanie produktu po ID
    public static ObservableList<Produkty> searchByID(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_id like "+id;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID "+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Wyszukiwanie zaawansowane
    public static ObservableList<Produkty> searchprod_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Produkty> searchdost_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where dost_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Produkty> searchprod_nazwa(String nazwa) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_nazwa like '%"+nazwa+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu nazwy."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Produkty> searchprod_cena(String cena) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_cena like'"+cena+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu ceny."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Produkty> searchprod_waluta(String waluta) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_waluta like '%"+waluta+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu waluty."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Produkty> searchprod_kraj(String kraj) throws ClassNotFoundException,SQLException{
        String sql = "select * from produkty where prod_kraj like '%"+kraj+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Produkty>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu kraju."+e);
            e.printStackTrace();
            throw e;
        }
    }
}
