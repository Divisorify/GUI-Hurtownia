package entities;

import javafx.beans.property.*;

import javax.persistence.*;

@Entity
public class Elementyzamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zam_id;

    @ManyToOne(targetEntity = Zamowienia.class)
    @JoinColumn(name = "zam_numer",referencedColumnName = "zam_numer")
    private int zam_numer;

    @Column
    private int zam_elem;

    @ManyToOne(targetEntity = Produkty.class)
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    private int prod_id;

    @Column
    private int ilosc;

    @Column
    private Double cena_elem;

    @Column
    private String waluta;

    public Elementyzamowienia(int zam_id, int zam_numer, int zam_elem, int prod_id, int ilosc, Double cena_elem, String waluta) {
        this.zam_id = zam_id;
        this.zam_numer = zam_numer;
        this.zam_elem = zam_elem;
        this.prod_id = prod_id;
        this.ilosc = ilosc;
        this.cena_elem = cena_elem;
        this.waluta = waluta;
    }

    public int getZam_id() {
        return zam_id;
    }

    public void setZam_id(int zam_id) {
        this.zam_id = zam_id;
    }

    public int getZam_numer() {
        return zam_numer;
    }

    public void setZam_numer(int zam_numer) {
        this.zam_numer = zam_numer;
    }

    public int getZam_elem() {
        return zam_elem;
    }

    public void setZam_elem(int zam_elem) {
        this.zam_elem = zam_elem;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Double getCena_elem() {
        return cena_elem;
    }

    public void setCena_elem(Double cena_elem) {
        this.cena_elem = cena_elem;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    @Override
    public String toString() {
        return "Elementyzamowienia{" +
                "zam_id=" + zam_id +
                ", zam_numer=" + zam_numer +
                ", zam_elem=" + zam_elem +
                ", prod_id=" + prod_id +
                ", ilosc=" + ilosc +
                ", cena_elem=" + cena_elem +
                ", waluta='" + waluta + '\'' +
                '}';
    }

    @Transient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private IntegerProperty zam_idProperty;

    @Transient
    @ManyToOne(targetEntity = Zamowienia.class)
    @JoinColumn(name = "zam_numer",referencedColumnName = "zam_numer")
    private IntegerProperty zam_numerProperty;

    @Transient
    private IntegerProperty zam_elemProperty;

    @Transient
    @ManyToOne(targetEntity = Produkty.class)
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    private IntegerProperty prod_idProperty;

    @Transient
    private IntegerProperty iloscProperty;

    @Transient
    private DoubleProperty cena_elemProperty;

    @Transient
    private StringProperty walutaProperty;

    public Elementyzamowienia() {
        this.zam_idProperty = new SimpleIntegerProperty();
        this.zam_numerProperty = new SimpleIntegerProperty();
        this.zam_elemProperty = new SimpleIntegerProperty();
        this.prod_idProperty = new SimpleIntegerProperty();
        this.iloscProperty = new SimpleIntegerProperty();
        this.cena_elemProperty = new SimpleDoubleProperty();
        this.walutaProperty = new SimpleStringProperty();
    }

    public int getZam_idProperty() {
        return zam_idProperty.get();
    }

    public IntegerProperty zam_idPropertyProperty() {
        return zam_idProperty;
    }

    public void setZam_idProperty(int zam_idProperty) {
        this.zam_idProperty.set(zam_idProperty);
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

    public int getZam_elemProperty() {
        return zam_elemProperty.get();
    }

    public IntegerProperty zam_elemPropertyProperty() {
        return zam_elemProperty;
    }

    public void setZam_elemProperty(int zam_elemProperty) {
        this.zam_elemProperty.set(zam_elemProperty);
    }

    public int getProd_idProperty() {
        return prod_idProperty.get();
    }

    public IntegerProperty prod_idPropertyProperty() {
        return prod_idProperty;
    }

    public void setProd_idProperty(int prod_idProperty) {
        this.prod_idProperty.set(prod_idProperty);
    }

    public int getIloscProperty() {
        return iloscProperty.get();
    }

    public IntegerProperty iloscPropertyProperty() {
        return iloscProperty;
    }

    public void setIloscProperty(int iloscProperty) {
        this.iloscProperty.set(iloscProperty);
    }

    public double getCena_elemProperty() {
        return cena_elemProperty.get();
    }

    public DoubleProperty cena_elemPropertyProperty() {
        return cena_elemProperty;
    }

    public void setCena_elemProperty(double cena_elemProperty) {
        this.cena_elemProperty.set(cena_elemProperty);
    }

    public String getWalutaProperty() {
        return walutaProperty.get();
    }

    public StringProperty walutaPropertyProperty() {
        return walutaProperty;
    }

    public void setWalutaProperty(String walutaProperty) {
        this.walutaProperty.set(walutaProperty);
    }
}
