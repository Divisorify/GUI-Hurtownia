package entities;

import javax.persistence.*;

@Entity
public class Klienci {

    @Id
    @Column(name = "kl_id", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int kl_id;

    @Column
    private String kl_imie;

    @Column
    private String kl_nazwisko;

    @Column
    private String kl_miejscowosc;

    @Column
    private String kl_ulica;

    @Column
    private String kl_nrMieszkania;

    @Column
    private int kl_nrTelefonu;

    @Column
    private String kl_email;

    public Klienci() {
    }

    public Klienci(int kl_id, String kl_imie, String kl_nazwisko, String kl_miejscowosc, String kl_ulica, String kl_nrMieszkania, int kl_nrTelefonu, String kl_email) {
        this.kl_id = kl_id;
        this.kl_imie = kl_imie;
        this.kl_nazwisko = kl_nazwisko;
        this.kl_miejscowosc = kl_miejscowosc;
        this.kl_ulica = kl_ulica;
        this.kl_nrMieszkania = kl_nrMieszkania;
        this.kl_nrTelefonu = kl_nrTelefonu;
        this.kl_email = kl_email;
    }

    public int getKl_id() {
        return kl_id;
    }

    public void setKl_id(int kl_id) {
        this.kl_id = kl_id;
    }

    public String getKl_imie() {
        return kl_imie;
    }

    public void setKl_imie(String kl_imie) {
        this.kl_imie = kl_imie;
    }

    public String getKl_nazwisko() {
        return kl_nazwisko;
    }

    public void setKl_nazwisko(String kl_nazwisko) {
        this.kl_nazwisko = kl_nazwisko;
    }

    public String getKl_miejscowosc() {
        return kl_miejscowosc;
    }

    public void setKl_miejscowosc(String kl_miejscowosc) {
        this.kl_miejscowosc = kl_miejscowosc;
    }

    public String getKl_ulica() {
        return kl_ulica;
    }

    public void setKl_ulica(String kl_ulica) {
        this.kl_ulica = kl_ulica;
    }

    public String getKl_nrMieszkania() {
        return kl_nrMieszkania;
    }

    public void setKl_nrMieszkania(String kl_nrMieszkania) {
        this.kl_nrMieszkania = kl_nrMieszkania;
    }

    public int getKl_nrTelefonu() {
        return kl_nrTelefonu;
    }

    public void setKl_nrTelefonu(int kl_nrTelefonu) {
        this.kl_nrTelefonu = kl_nrTelefonu;
    }

    public String getKl_email() {
        return kl_email;
    }

    public void setKl_email(String kl_email) {
        this.kl_email = kl_email;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "kl_id=" + kl_id +
                ", kl_imie='" + kl_imie + '\'' +
                ", kl_nazwisko='" + kl_nazwisko + '\'' +
                ", kl_miejscowosc='" + kl_miejscowosc + '\'' +
                ", kl_ulica='" + kl_ulica + '\'' +
                ", kl_nrMieszkania='" + kl_nrMieszkania + '\'' +
                ", kl_nrTelefonu=" + kl_nrTelefonu +
                ", kl_email='" + kl_email + '\'' +
                '}';
    }
}
