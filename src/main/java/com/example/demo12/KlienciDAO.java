package com.example.demo12;

import java.sql.SQLException;

public class KlienciDAO {

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
}
