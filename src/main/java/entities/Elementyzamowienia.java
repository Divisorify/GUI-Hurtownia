package entities;

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

    public Elementyzamowienia() {
    }

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
}
