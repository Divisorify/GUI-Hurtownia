package entities;

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

    public Dostawcy() {
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
}
