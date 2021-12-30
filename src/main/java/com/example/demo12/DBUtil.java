package com.example.demo12;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/hurtowniadoprojektu";
    private static Connection connection;
    private static Statement statement;

    private static final String user="root";
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
            connection = DriverManager.getConnection(DBURL,"root","");
            System.out.println("2. Nawiązano połączenie z bazą hurtowni!");
        } catch(SQLException e){
            System.err.println("2. Problem z otwarciem połączenia");
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(DBURL);
            statement = connection.createStatement();

        } catch (SQLException e){
            System.err.println("3.Nie można wykonać tego polecenia!");
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
        //CachedRowSetImpl crs = null;

        try{
            dbConnect();

            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
            //crs = new CachedRowSetImpl();
            //crs.populate(rs);
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
