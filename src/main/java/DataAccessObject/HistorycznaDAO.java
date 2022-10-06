package DataAccessObject;

import com.example.demo12.DBUtil;
import com.example.demo12.HelloController;
import entities.Historyczna;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistorycznaDAO {
    //Wypisanie wszystkich zamówień
    public static ObservableList<Historyczna> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from pokazhistoryczna()";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna> List = getObjects(rsSet);
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Przyporządkowanie danych kolumnom
    private static ObservableList<Historyczna> getObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Historyczna> List = FXCollections.observableArrayList();

            while(rsSet.next()){
                Historyczna kli = new Historyczna();
                kli.setHist_idProperty(rsSet.getInt("hist_id"));
                kli.setZam_numerProperty(rsSet.getInt("zam_numer"));
//                kli.setZam_dataProperty(rsSet.getString("zam_data"));
//                kli.setKl_idProperty(rsSet.getInt("kl_id"));
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
            String sql = "CALL dodajhistoryczna(?,?)";
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
    public static int update(String histid,String zamnumer) throws ClassNotFoundException,SQLException {
        if(histid.equals("") || zamnumer.equals("")){
            return 4;
        }
        if(Integer.parseInt(histid)<1){
            return 3;
        }
//        if(zamnumer.equals("") || !HelloController.isDate(zamnumer)){
//            return 2;
//        }
        String sql = "CALL zaktualizujhistoryczna(?,?)";
        try {
            DBUtil.dbExecuteQueryZaktualizujZamowienia(sql, histid, zamnumer);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            return 10;
        }
        return 1;
    }

    //Usunięcie zamówienia po ID
    public static int delete(int numer) throws ClassNotFoundException,SQLException {
        String sql = "CALL usunhistoryczna(?)";
        try {
            DBUtil.dbExecuteQueryUsun(sql, numer);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            return 10;
        }
        return 1;
    }



    //Wyszukanie zamówienia po numerze
    public static ObservableList<Historyczna> search(String hist_id) throws ClassNotFoundException,SQLException{
        String sql = "select * from historyczna where hist_id = "+hist_id;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po numerze zamówienia "+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Wyszukiwanie zaawansowane
    public static ObservableList<Historyczna> searchhist_id(String numer) throws ClassNotFoundException,SQLException{
        String sql = "select * from historyczna where hist_id = "+numer;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po numerze zamówienia. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Historyczna> searchzam_numer(String numer) throws ClassNotFoundException,SQLException{
        String sql = "select * from historyczna where zam_numer like '%"+numer+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po numerze zamówienia. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Historyczna> searchzam_data(String data) throws ClassNotFoundException,SQLException{
        String sql = "select * from historyczna where zam_data like '%"+data+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po dacie. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Historyczna> searchkl_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from zamowienia where kl_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Historyczna>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
