package com.example.demo12;

import javax.sql.rowset.CachedRowSet;
//import com.sun.rowset.CachedRowSetImpl;
import java.math.BigDecimal;
import java.sql.*;
import javax.sql.rowset.*;
//import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {
    //Łączenie z bazą danych
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DBURL = "jdbc:postgresql://localhost:5432/hurtowniadb";
    public static Connection connection;
    private static Statement statement;

    private static final String user="postgres";
    private static final String password="konrad";

    public static void dbConnect() throws SQLException,ClassNotFoundException{
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("1. Zarejestrowano sterownik do bazy danych PostgreSQL!");
        } catch(ClassNotFoundException e){
            System.err.println("Niewłaściwy sterownik JDBC lub jego brak");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DBURL,user,password);
            System.out.println("2. Nawiązano połączenie z bazą hurtowni!");
        } catch(SQLException e){
            System.err.println("2. Problem z otwarciem połączenia");
            e.printStackTrace();
        }
//        try{
//            connection = DriverManager.getConnection(DBURL);
//            statement = connection.createStatement();
//
//        } catch (SQLException e){
//            System.err.println("3.Nie można wykonać tego polecenia!");
//        }
    }
    public static void dbDisconnect() throws SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(Exception e){
            throw e;
        }
    }

    public static void dbExecuteQuery(String sqlStmt,String imie, String nazwisko, String miejscowosc,String ulica,String nrmieszkania,String nrtelefonu,String email) throws SQLException,ClassNotFoundException{
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sqlStmt);
            stmt.setString(1,imie);
            stmt.setString(2,nazwisko);
            stmt.setString(3,miejscowosc);
            stmt.setString(4,ulica);
            stmt.setString(5,nrmieszkania);
            stmt.setInt(6,Integer.parseInt(nrtelefonu));
            stmt.setString(7,email);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }
    public static void dbExecuteQuery(String sql, String nazwa, String miejscowosc, String ulica, String kraj, String email) throws SQLException, ClassNotFoundException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setString(1,nazwa);
            stmt.setString(2,miejscowosc);
            stmt.setString(3,ulica);
            stmt.setString(4,kraj);
            stmt.setString(5,email);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryProdukty(String sql, String dost_id, String nazwa, String cena, String waluta, String kraj) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(dost_id));
            stmt.setString(2,nazwa);
            stmt.setString(3,cena);
            stmt.setString(4,waluta);
            stmt.setString(5,kraj);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryElementy(String sql, String numer, String prod_id, String ilosc, String cenaelem, String waluta) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(numer));
            stmt.setInt(2, Integer.parseInt(prod_id));
            stmt.setInt(3, Integer.parseInt(ilosc));
            stmt.setBigDecimal(4, BigDecimal.valueOf(Long.parseLong(cenaelem)));
            stmt.setString(5,waluta);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQuery(String sql, String data, String id) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setDate(1, Date.valueOf(data));
            stmt.setInt(2, Integer.parseInt(id));
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryZaktualizujDostawcow(String sql, String id, String email) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2,email);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryZaktualizujElementy(String sql, String id, String ilosc) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setInt(2, Integer.parseInt(ilosc));
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryZaktualizujKlientow(String sql, String id, String email) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2,email);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryZaktualizujProdukty(String sql, String id, String nazwa) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2,nazwa);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }


    }

    public static void dbExecuteQueryZaktualizujZamowienia(String sql, String zamnumer, String data) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, Integer.parseInt(zamnumer));
            //stmt.setDate(2, Date.valueOf(data));
            stmt.setInt(2, Integer.parseInt(data));
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static void dbExecuteQueryUsun(String sql, int id) throws SQLException {
        CallableStatement stmt = null;
        try{
            dbConnect();
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Problem wystąpił w dbExecuteQuery"+e);
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException,SQLException{
        Statement stmt = null;
        ResultSet rs = null;


        try{
            dbConnect();

            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);

            return crs;
        }catch(SQLException e){
            System.out.println("Błąd w dbExecute"+ e);
            throw e;
        }finally{
            if(rs !=null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }

    }
}
