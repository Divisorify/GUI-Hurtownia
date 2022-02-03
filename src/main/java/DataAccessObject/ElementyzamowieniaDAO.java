package DataAccessObject;

import com.example.demo12.DBUtil;
import com.example.demo12.HelloController;
import entities.Elementyzamowienia;
import entities.Produkty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementyzamowieniaDAO {
    //Wypisanie wszystkich elementów zamówienia
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

    //Przyporządkowanie danych kolumnom
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

    //Dodanie elementu zamówienia
    public static int dodaj(String numer,String element, String prod_id, String ilosc,String cenaelem,String waluta) throws SQLException,ClassNotFoundException{
        if(numer =="" || element == "" || prod_id == "" || ilosc == "" || cenaelem == "" || waluta == ""){
            return 2;
        } else if(HelloController.isInteger(numer) == false){
            return 7;
        } else if(Integer.parseInt(element) < 0){
            return 6;
        } else if(Integer.parseInt(prod_id) < 0){
            return 5;
        } else if(Integer.parseInt(ilosc) < 0){
            return 3;
        } else if(Double.parseDouble(cenaelem) < 0){
            return 4;
        }    else if(Integer.parseInt(ilosc)>= 0 && Double.parseDouble(cenaelem) >= 0){
            String sql = "insert into Elementyzamowienia(zam_numer,zam_elem,prod_id,ilosc,cena_elem,waluta)values('"+numer+"', '"+element+"', '"+prod_id+"', '"+ilosc+"', '"+cenaelem+"', '"+waluta+"')";
            try{
                DBUtil.dbExecuteQuery(sql);
            }catch(SQLException e){
                System.out.println("Wyjątek przy dodawaniu elementu zamówienia. "+ e);
                e.printStackTrace();
                //throw e;
                return 10;
            }
            return 1;
        }else{
            return 0;
        }
    }

    //Aktualizacja ilości zamówionych produktów
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

    //Usunięcie elementu zamówienia po ID
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

    //Wyszukanie elementu zamówienia po ID zamówienia
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

    //Wyszukiwanie zaawansowane
    public static ObservableList<Elementyzamowienia> searchzam_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where zam_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po zam_ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Elementyzamowienia> searchzam_numer(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where zam_numer like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu numeru zamówienia. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Elementyzamowienia> searchzam_elem(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where zam_elem like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu elementów zamówienia. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Elementyzamowienia> searchprod_id(String id) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where prod_id like '%"+id+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu po prod_ID. "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Elementyzamowienia> searchilosc(String ilosc) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where ilosc like '%"+ilosc+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu liczby sztuk. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Elementyzamowienia> searchcena_elem(String cena) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where cena_elem like '%"+cena+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu ceny elementu. "+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Elementyzamowienia> searchwaluta(String waluta) throws ClassNotFoundException,SQLException{
        String sql = "select * from Elementyzamowienia where waluta like '%"+waluta+"%'";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Elementyzamowienia>  list = getObjects(rsSet);
            return list;
        }catch(SQLException e){
            System.out.println("Błąd przy szukaniu waluty. "+e);
            e.printStackTrace();
            throw e;
        }
    }

}
