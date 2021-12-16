package entities;

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

    public Produkty() {
    }

    public Produkty(int prod_id, int dost_id, String prod_nazwa, Double prod_cena, String prod_waluta, String prod_kraj) {
        this.prod_id = prod_id;
        this.dost_id = dost_id;
        this.prod_nazwa = prod_nazwa;
        this.prod_cena = prod_cena;
        this.prod_waluta = prod_waluta;
        this.prod_kraj = prod_kraj;
    }

    public Produkty(String prod_nazwa, Double prod_cena, String prod_waluta, String prod_kraj) {
        this.prod_nazwa = prod_nazwa;
        this.prod_cena = prod_cena;
        this.prod_waluta = prod_waluta;
        this.prod_kraj = prod_kraj;
    }

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
}
