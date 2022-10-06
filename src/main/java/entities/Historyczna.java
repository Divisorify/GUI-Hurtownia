package entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

public class Historyczna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hist_id;

//    @ManyToOne(targetEntity = Zamowienia.class)
    @Column
    private int zam_numer;

////    @ManyToOne(targetEntity = Zamowienia.class)
//    @Column
//    private String zam_data;
//
////    @ManyToOne(targetEntity = Klienci.class)
//    @JoinColumn(name = "kl_id")
//    private int kl_id;

    public Historyczna(int hist_id,int zam_numer, String zam_data, int kl_id) {
        this.hist_id = hist_id;
        this.zam_numer = zam_numer;
//        this.zam_data = zam_data;
//        this.kl_id = kl_id;
    }

//    public Zamowienia() {
//    }

    public int getHist_id() {
        return hist_id;
    }

    public void setHist_id(int hist_id) {this.hist_id = hist_id;}

    public int getZam_numer() {
        return zam_numer;
    }

    public void setZam_numer(int zam_numer) {
        this.zam_numer = zam_numer;
    }

//    public String getZam_data() {
//        return zam_data;
//    }
//
//    public void setZam_data(String zam_data) {
//        this.zam_data = zam_data;
//    }
//
//    public int getKl_id() {
//        return kl_id;
//    }
//
//    public void setKl_id(int kl_id) {
//        this.kl_id = kl_id;
//    }

    @Override
    public String toString() {
        return "Historyczna{" +
                "hist_id=" + hist_id +
                "zam_numer=" + zam_numer +
//                ", zam_data=" + zam_data +
//                ", kl_id=" + kl_id +
                '}';
    }

    @Transient
    @Id
    @Column(name = "hist_id", nullable = true)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private IntegerProperty hist_idProperty;

    @Transient
    //@Column(name = "kl_id", nullable = true)
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
//    @ManyToOne(targetEntity = Zamowienia.class)
//    @JoinColumn(name = "zam_numer")
    private IntegerProperty zam_numerProperty;
//    @ManyToOne(targetEntity = Zamowienia.class)
//    @JoinColumn(name = "zam_data")
//    @Transient
//    private StringProperty zam_dataProperty;
//    @Transient
////    @ManyToOne(targetEntity = Klienci.class)
////    @JoinColumn(name = "kl_id")
//    private IntegerProperty kl_idProperty;

    public Historyczna() {
        this.hist_idProperty = new SimpleIntegerProperty();
        this.zam_numerProperty = new SimpleIntegerProperty();
//        this.zam_dataProperty = new SimpleStringProperty();
//        this.kl_idProperty = new SimpleIntegerProperty();
    }

    public int getHist_idProperty() {
        return hist_idProperty.get();
    }

    public IntegerProperty hist_idPropertyProperty() {return hist_idProperty;}

    public void setHist_idProperty(int hist_idProperty) {
        this.hist_idProperty.set(hist_idProperty);
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

//    public String getZam_dataProperty() {
//        return zam_dataProperty.get();
//    }
//
//    public StringProperty zam_dataPropertyProperty() {
//        return zam_dataProperty;
//    }
//
//    public void setZam_dataProperty(String zam_dataProperty) {
//        this.zam_dataProperty.set(zam_dataProperty);
//    }
//
//    public int getKl_idProperty() {
//        return kl_idProperty.get();
//    }
//
//    public IntegerProperty kl_idPropertyProperty() {
//        return kl_idProperty;
//    }
//
//    public void setKl_idProperty(int kl_idProperty) {
//        this.kl_idProperty.set(kl_idProperty);
//    }
}
