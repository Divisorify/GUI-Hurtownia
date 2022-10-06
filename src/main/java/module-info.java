module demo1 {
    requires java.sql;
    requires java.naming;
    //requires mysql.connector.java;
    //requires java.base;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires javafx.controls;
    requires java.sql.rowset;
    requires org.postgresql.jdbc;
    opens com.example.demo12 to javafx.fxml;
    exports com.example.demo12;
    opens entities;
    exports DataAccessObject;
    opens DataAccessObject to javafx.fxml;
}