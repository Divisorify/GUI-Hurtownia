package DataAccessObject;

import com.example.demo12.DBUtil;
import com.example.demo12.HelloController;
import entities.Dostawcy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DostawcyDAO {
    //Wypisanie wszystkich dostawców
    public static ObservableList<Dostawcy> getAllRecords() throws ClassNotFoundException, SQLException {
        String sql = "select * from Dostawcy";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy> List = getObjects(rsSet);
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Przyporządkowanie danych kolumnom
    private static ObservableList<Dostawcy> getObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Dostawcy> List = FXCollections.observableArrayList();

            while(rsSet.next()){
                Dostawcy kli = new Dostawcy();
                kli.setDost_idProperty(rsSet.getInt("dost_id"));
                kli.setDost_nazwaProperty(rsSet.getString("dost_nazwa"));
                kli.setDost_miejscowoscProperty(rsSet.getString("dost_miejscowosc"));
                kli.setDost_ulicaProperty(rsSet.getString("dost_ulica"));
                kli.setDost_krajProperty(rsSet.getString("dost_kraj"));
                kli.setDost_emailProperty(rsSet.getString("dost_email"));
                List.add(kli);
            }
            return List;
        }catch(SQLException e){
            System.out.println("Błąd przy łączeniu z bazą danych"+e);
            e.printStackTrace();
            throw e;
        }

    }

    //Dodanie dostawcy
    public static int dodaj(String nazwa, String miejscowosc, String ulica, String kraj, String email) throws SQLException,ClassNotFoundException{
        boolean validEmailAddress = HelloController.isValidEmailAddress(email);
        if(nazwa =="" || miejscowosc == "" || ulica == "" || kraj == "" || email == ""){
            return 2;
        }
//        else if(Integer.parseInt(nazwa) < 0){
//            return 3;
//        }else if(Integer.parseInt(miejscowosc) < 0){
//            return 4;
//        }else if(Integer.parseInt(ulica) < 0){
//            return 5;
//        }else if(Integer.parseInt(kraj) < 0){
//            return 6;
//        }else if(Integer.parseInt(email) < 0){
//            return 7;
//        }
        if(validEmailAddress == true){
            String sql = "insert into Dostawcy(dost_nazwa,dost_miejscowosc,dost_ulica,dost_kraj,dost_email)values(' "+nazwa+"', '"+miejscowosc+"', '"+ulica+"', '"+kraj+"', '"+email+"')";
            try{
                DBUtil.dbExecuteQuery(sql);
            }catch(SQLException e){
                System.out.println("Wyjątek przy dodawaniu Dostawcy"+ e);
                e.printStackTrace();
                throw e;
            }
            return 1;
        }else{
            return 0;
        }
    }

    //Aktualizacja emailu dostawcy
    public static void update(int id,String email) throws ClassNotFoundException,SQLException {
        String sql = "update Dostawcy set dost_email = '" + email + "' where dost_id = '" + id + "' ";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Wyjątek przy aktualizacji!");
            e.printStackTrace();
            throw e;
        }
    }

    //Usunięcie dostawcy po ID
    public static void deleteByID(int id) throws ClassNotFoundException,SQLException {
        String sql = "delete from Dostawcy where dost_id = '" + id + "'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Błąd przy usuwaniu.");
            e.printStackTrace();
            throw e;
        }
    }

    //Wyszukanie dostawcy po ID
    public static ObservableList<Dostawcy> searchByID(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_id = "+id;

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID "+e);
            e.printStackTrace();
            throw e;
        }
    }

    //Wyszukiwanie zaawansowane
    public static ObservableList<Dostawcy> searchdost_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po ID."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dostawcy> searchdost_nazwa(String nazwa) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_nazwa like '%"+nazwa+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu nazwy."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dostawcy> searchdost_miejscowosc(String miejscowosc) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_miejscowosc like'"+miejscowosc+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu miejscowości."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dostawcy> searchdost_ulica(String ulica) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_ulica like '%"+ulica+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu ulicy."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dostawcy> searchdost_kraj(String kraj) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_kraj like '%"+kraj+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu kraju."+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dostawcy> searchdost_email(String email) throws ClassNotFoundException,SQLException{
        String sql = "select * from Dostawcy where dost_email like '%"+email+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dostawcy>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu emaila."+e);
            e.printStackTrace();
            throw e;
        }
    }
}

