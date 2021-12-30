package entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Zamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zam_numer;

    @Column
    private String zam_data;

    @ManyToOne
    @JoinColumn(name = "kl_id",referencedColumnName = "kl_id")
    private Klienci kl_id;

    public Zamowienia(int zam_numer, String zam_data, Klienci kl_id) {
        this.zam_numer = zam_numer;
        this.zam_data = zam_data;
        this.kl_id = kl_id;
    }

//    public Zamowienia() {
//    }

    public int getZam_numer() {
        return zam_numer;
    }

    public void setZam_numer(int zam_numer) {
        this.zam_numer = zam_numer;
    }

    public String getZam_data() {
        return zam_data;
    }

    public void setZam_data(String zam_data) {
        this.zam_data = zam_data;
    }

    public Klienci getKl_id() {
        return kl_id;
    }

    public void setKl_id(Klienci kl_id) {
        this.kl_id = kl_id;
    }

    @Override
    public String toString() {
        return "Zamowienia{" +
                "zam_numer=" + zam_numer +
                ", zam_data=" + zam_data +
                ", kl_id=" + kl_id +
                '}';
    }

    @Transient
    @Column(name = "kl_id", nullable = true)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private IntegerProperty zam_numerProperty;
    @Transient
    private StringProperty zam_dataProperty;
    @Transient
    private IntegerProperty kl_idProperty;

    public Zamowienia() {
        this.zam_numerProperty = new SimpleIntegerProperty();
        this.zam_dataProperty = new SimpleStringProperty();
        this.kl_idProperty = new SimpleIntegerProperty();
    }

    public int getZam_numerProperty() {
        return zam_numerProperty.get();
    }

    public IntegerProperty zam_numerPropertyProperty() {
        return zam_numerProperty;
    }

    public void setZam_numerProperty(int zam_numerProperty) {
        this.zam_numerProperty.set(zam_numerProperty);
    }

    public String getZam_dataProperty() {
        return zam_dataProperty.get();
    }

    public StringProperty zam_dataPropertyProperty() {
        return zam_dataProperty;
    }

    public void setZam_dataProperty(String zam_dataProperty) {
        this.zam_dataProperty.set(zam_dataProperty);
    }

    public int getKl_idProperty() {
        return kl_idProperty.get();
    }

    public IntegerProperty kl_idPropertyProperty() {
        return kl_idProperty;
    }

    public void setKl_idProperty(int kl_idProperty) {
        this.kl_idProperty.set(kl_idProperty);
    }
}
