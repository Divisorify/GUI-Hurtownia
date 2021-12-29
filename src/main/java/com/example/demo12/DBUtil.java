package com.example.demo12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/hurtowniadoprojektu";
    private static Connection connection = null;
    private static Statement statement = null;

    private static final String user="";
    private static final String password="";

    public static void dbConnect() throws SQLException,ClassNotFoundException{
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("1. Zarejestrowano sterownik do bazy danych MySQL!");
        } catch(ClassNotFoundException e){
            System.err.println("Niewłaściwy sterownik JDBC lub jego brak");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DBURL);
            System.out.println("2. Nawiązano połączenie z bazą miejscowości!");
        } catch(SQLException e){
            System.err.println("Problem z otwarciem połączenia");
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(DBURL);
            statement = connection.createStatement();

            /*            String query = "DELETE FROM miejscowosc WHERE id_miejscowosci= 190";
            statement.executeUpdate(query);*/

            /*            String miejscowosc = "Żarnowiec";
            String query = "DELETE FROM miejscowosc WHERE nazwa_miejscowosci = '"+miejscowosc+"'";
            statement.executeQuery(query);*/

            String query = "DELETE FROM miejscowosc WHERE nazwa_miejscowosci = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Jaszczew");
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            System.err.println("Nie można wykonać tego polecenia!");
        }
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

    public static void dbExecuteQuery(String sqlStmt) throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        try{
            dbConnect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
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
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException,SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;

        try{
            dbConnect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
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
        return crs;
    }
}
