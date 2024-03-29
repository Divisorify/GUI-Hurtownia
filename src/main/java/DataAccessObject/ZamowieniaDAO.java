package DataAccessObject;

import com.example.demo12.DBUtil;
import com.example.demo12.HelloController;
import entities.Zamowienia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZamowieniaDAO {
    //Wypisanie wszystkich zamówień
    public static ObservableList<Zamowienia> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from pokazzamowienia()";
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

    //Przyporządkowanie danych kolumnom
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

    //Dodanie zamówienia
    public static int dodaj(String data, String id) throws SQLException,ClassNotFoundException{
        if(data.equals("") || id.equals("")){
            return 2;
        }
        else if(!HelloController.isDate(data)){
            return 3;
        }
        else if(!HelloController.isInteger(id)){
            return 4;
        }
        if(HelloController.isInteger(id)){
            String sql = "CALL dodajzamowienia(?,?)";
            try{
                DBUtil.dbExecuteQuery(sql,data, id);
            }catch(SQLException e){
                System.out.println("Wyjątek przy dodawaniu klienta"+ e);
                e.printStackTrace();
                //throw e;
                return 10;
            }
            return 1;
        }else{
            return 0;
        }
    }

    //Aktualizacja daty zamówienia
    public static int update(String zamnumer,String data) throws ClassNotFoundException,SQLException {
        if(zamnumer.equals("") || data.equals("")){
            return 4;
        }
        if(Integer.parseInt(zamnumer)<1){
            return 3;
        }
        if(data.equals("") || !HelloController.isDate(data)){
            return 2;
        }
        String sql = "CALL zaktualizujzamowienia(?,?)";
        try {
            DBUtil.dbExecuteQueryZaktualizujZamowienia(sql, zamnumer, data);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            return 10;
        }
        return 1;
    }

    //Usunięcie zamówienia po ID
    public static int delete(int numer) throws ClassNotFoundException,SQLException {
        String sql = "CALL usunzamowienia(?)";
        try {
            DBUtil.dbExecuteQueryUsun(sql, numer);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            return 10;
        }
        return 1;
    }

    public static String archiwizuj(String data) throws ClassNotFoundException,SQLException {
        String sql = "CALL transfer("+"'"+data+"'"+")";
        try {
            DBUtil.dbExecute(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy archiwizowaniu.");
            e.printStackTrace();
            return "Błąd w archiwizacji.";
        }
        return "Zarchiwizowano poprawnie.";
    }

    //Wyszukanie zamówienia po numerze
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

    //Wyszukiwanie zaawansowane
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
