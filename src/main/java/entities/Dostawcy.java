package entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
public class Dostawcy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dost_id;

    @Column
    private String dost_nazwa;

    @Column
    private String dost_miejscowosc;

    @Column
    private String dost_ulica;

    @Column
    private String dost_kraj;

    @Column
    private String dost_email;

    public Dostawcy(int dost_id, String dost_nazwa, String dost_miejscowosc, String dost_ulica, String dost_kraj, String dost_email) {
        this.dost_id = dost_id;
        this.dost_nazwa = dost_nazwa;
        this.dost_miejscowosc = dost_miejscowosc;
        this.dost_ulica = dost_ulica;
        this.dost_kraj = dost_kraj;
        this.dost_email = dost_email;
    }


    public int getDost_id() {
        return dost_id;
    }

    public void setDost_id(int dost_id) {
        this.dost_id = dost_id;
    }

    public String getDost_nazwa() {
        return dost_nazwa;
    }

    public void setDost_nazwa(String dost_nazwa) {
        this.dost_nazwa = dost_nazwa;
    }

    public String getDost_miejscowosc() {
        return dost_miejscowosc;
    }

    public void setDost_miejscowosc(String dost_miejscowosc) {
        this.dost_miejscowosc = dost_miejscowosc;
    }

    public String getDost_ulica() {
        return dost_ulica;
    }

    public void setDost_ulica(String dost_ulica) {
        this.dost_ulica = dost_ulica;
    }

    public String getDost_kraj() {
        return dost_kraj;
    }

    public void setDost_kraj(String dost_kraj) {
        this.dost_kraj = dost_kraj;
    }

    public String getDost_email() {
        return dost_email;
    }

    public void setDost_email(String dost_email) {
        this.dost_email = dost_email;
    }

    @Override
    public String toString() {
        return "Dostawcy{" +
                "dost_id=" + dost_id +
                ", dost_nazwa='" + dost_nazwa + '\'' +
                ", dost_miejscowosc='" + dost_miejscowosc + '\'' +
                ", dost_ulica='" + dost_ulica + '\'' +
                ", dost_kraj='" + dost_kraj + '\'' +
                ", dost_email='" + dost_email + '\'' +
                '}';
    }

    @Transient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private IntegerProperty dost_idProperty;
    @Transient
    private StringProperty dost_nazwaProperty;
    @Transient
    private StringProperty dost_miejscowoscProperty;
    @Transient
    private StringProperty dost_ulicaProperty;
    @Transient
    private StringProperty dost_krajProperty;
    @Transient
    private StringProperty dost_emailProperty;

    public Dostawcy() {
        this.dost_idProperty = new SimpleIntegerProperty();
        this.dost_nazwaProperty = new SimpleStringProperty();
        this.dost_miejscowoscProperty = new SimpleStringProperty();
        this.dost_ulicaProperty = new SimpleStringProperty();
        this.dost_krajProperty = new SimpleStringProperty();
        this.dost_emailProperty = new SimpleStringProperty();
    }

    public int getDost_idProperty() {
        return dost_idProperty.get();
    }

    public IntegerProperty dost_idPropertyProperty() {
        return dost_idProperty;
    }

    public void setDost_idProperty(int dost_idProperty) {
        this.dost_idProperty.set(dost_idProperty);
    }

    public String getDost_nazwaProperty() {
        return dost_nazwaProperty.get();
    }

    public StringProperty dost_nazwaPropertyProperty() {
        return dost_nazwaProperty;
    }

    public void setDost_nazwaProperty(String dost_nazwaProperty) {
        this.dost_nazwaProperty.set(dost_nazwaProperty);
    }

    public String getDost_miejscowoscProperty() {
        return dost_miejscowoscProperty.get();
    }

    public StringProperty dost_miejscowoscPropertyProperty() {
        return dost_miejscowoscProperty;
    }

    public void setDost_miejscowoscProperty(String dost_miejscowoscProperty) {
        this.dost_miejscowoscProperty.set(dost_miejscowoscProperty);
    }

    public String getDost_ulicaProperty() {
        return dost_ulicaProperty.get();
    }

    public StringProperty dost_ulicaPropertyProperty() {
        return dost_ulicaProperty;
    }

    public void setDost_ulicaProperty(String dost_ulicaProperty) {
        this.dost_ulicaProperty.set(dost_ulicaProperty);
    }

    public String getDost_krajProperty() {
        return dost_krajProperty.get();
    }

    public StringProperty dost_krajPropertyProperty() {
        return dost_krajProperty;
    }

    public void setDost_krajProperty(String dost_krajProperty) {
        this.dost_krajProperty.set(dost_krajProperty);
    }

    public String getDost_emailProperty() {
        return dost_emailProperty.get();
    }

    public StringProperty dost_emailPropertyProperty() {
        return dost_emailProperty;
    }

    public void setDost_emailProperty(String dost_emailProperty) {
        this.dost_emailProperty.set(dost_emailProperty);
    }
}
