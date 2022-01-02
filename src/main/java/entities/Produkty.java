package entities;

import javafx.beans.property.*;

import javax.persistence.*;

@Entity
public class Produkty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prod_id;

    @ManyToOne(targetEntity = Dostawcy.class)
    @JoinColumn(name = "dost_id")
    private int dost_id;

    @Column
    private String prod_nazwa;

    @Column
    private Double prod_cena;

    @Column
    private String prod_waluta;

    @Column
    private String prod_kraj;


    public Produkty(int prod_id, int dost_id, String prod_nazwa, Double prod_cena, String prod_waluta, String prod_kraj) {
        this.prod_id = prod_id;
        this.dost_id = dost_id;
        this.prod_nazwa = prod_nazwa;
        this.prod_cena = prod_cena;
        this.prod_waluta = prod_waluta;
        this.prod_kraj = prod_kraj;
    }

//    public Produkty(String prod_nazwa, Double prod_cena, String prod_waluta, String prod_kraj) {
//        this.prod_nazwa = prod_nazwa;
//        this.prod_cena = prod_cena;
//        this.prod_waluta = prod_waluta;
//        this.prod_kraj = prod_kraj;
//    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getDost_id() {
        return dost_id;
    }

    public void setDost_id(int dost_id) {
        this.dost_id = dost_id;
    }

    public String getProd_nazwa() {
        return prod_nazwa;
    }

    public void setProd_nazwa(String prod_nazwa) {
        this.prod_nazwa = prod_nazwa;
    }

    public Double getProd_cena() {
        return prod_cena;
    }

    public void setProd_cena(Double prod_cena) {
        this.prod_cena = prod_cena;
    }

    public String getProd_waluta() {
        return prod_waluta;
    }

    public void setProd_waluta(String prod_waluta) {
        this.prod_waluta = prod_waluta;
    }

    public String getProd_kraj() {
        return prod_kraj;
    }

    public void setProd_kraj(String prod_kraj) {
        this.prod_kraj = prod_kraj;
    }

    @Override
    public String toString() {
        return "Produkty{" +
                "prod_id=" + prod_id +
                ", dost_id=" + dost_id +
                ", prod_nazwa='" + prod_nazwa + '\'' +
                ", prod_cena=" + prod_cena +
                ", prod_waluta='" + prod_waluta + '\'' +
                ", prod_kraj='" + prod_kraj + '\'' +
                '}';
    }

    @Transient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private IntegerProperty prod_idProperty;
    @Transient
    @ManyToOne(targetEntity = Dostawcy.class)
    @JoinColumn(name = "dost_idProperty")
    private IntegerProperty dost_idProperty;
    @Transient
    private StringProperty prod_nazwaProperty;
    @Transient
    private DoubleProperty prod_cenaProperty;
    @Transient
    private StringProperty prod_walutaProperty;
    @Transient
    private StringProperty prod_krajProperty;

    public Produkty() {
        this.prod_idProperty = new SimpleIntegerProperty();
        this.dost_idProperty = new SimpleIntegerProperty();
        this.prod_nazwaProperty = new SimpleStringProperty();
        this.prod_cenaProperty = new SimpleDoubleProperty();
        this.prod_walutaProperty = new SimpleStringProperty();
        this.prod_krajProperty = new SimpleStringProperty();
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

    public int getDost_idProperty() {
        return dost_idProperty.get();
    }

    public IntegerProperty dost_idPropertyProperty() {
        return dost_idProperty;
    }

    public void setDost_idProperty(int dost_idProperty) {
        this.dost_idProperty.set(dost_idProperty);
    }

    public String getProd_nazwaProperty() {
        return prod_nazwaProperty.get();
    }

    public StringProperty prod_nazwaPropertyProperty() {
        return prod_nazwaProperty;
    }

    public void setProd_nazwaProperty(String prod_nazwaProperty) {
        this.prod_nazwaProperty.set(prod_nazwaProperty);
    }

    public double getProd_cenaProperty() {
        return prod_cenaProperty.get();
    }

    public DoubleProperty prod_cenaPropertyProperty() {
        return prod_cenaProperty;
    }

    public void setProd_cenaProperty(double prod_cenaProperty) {
        this.prod_cenaProperty.set(prod_cenaProperty);
    }

    public String getProd_walutaProperty() {
        return prod_walutaProperty.get();
    }

    public StringProperty prod_walutaPropertyProperty() {
        return prod_walutaProperty;
    }

    public void setProd_walutaProperty(String prod_walutaProperty) {
        this.prod_walutaProperty.set(prod_walutaProperty);
    }

    public String getProd_krajProperty() {
        return prod_krajProperty.get();
    }

    public StringProperty prod_krajPropertyProperty() {
        return prod_krajProperty;
    }

    public void setProd_krajProperty(String prod_krajProperty) {
        this.prod_krajProperty.set(prod_krajProperty);
    }
}

