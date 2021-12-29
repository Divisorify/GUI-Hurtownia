package entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
public class Klienci{

    @Id
    @Column(name = "kl_id", nullable = true)
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

//    public Klienci() {
//    }

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
    @Transient
    @Column(name = "kl_id", nullable = true)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private IntegerProperty kl_idProperty;
    @Transient
    private StringProperty kl_imieProperty;
    @Transient
    private StringProperty kl_nazwiskoProperty;
    @Transient
    private StringProperty kl_miejscowoscProperty;
    @Transient
    private StringProperty kl_ulicaProperty;
    @Transient
    private StringProperty kl_nrMieszkaniaProperty;
    @Transient
    private IntegerProperty kl_nrTelefonuProperty;
    @Transient
    private StringProperty kl_emailProperty;


    public Klienci(){
        this.kl_idProperty = new SimpleIntegerProperty();
        this.kl_imieProperty = new SimpleStringProperty();
        this.kl_nazwiskoProperty = new SimpleStringProperty();
        this.kl_miejscowoscProperty = new SimpleStringProperty();
        this.kl_ulicaProperty = new SimpleStringProperty();
        this.kl_nrMieszkaniaProperty = new SimpleStringProperty();
        this.kl_nrTelefonuProperty = new SimpleIntegerProperty();
        this.kl_emailProperty = new SimpleStringProperty();
    }

    public int getKlient_id() {
        return kl_idProperty.get();
    }

    public void setKlient_id(int id) {
        this.kl_idProperty.set(id);
    }

    public IntegerProperty getKlientId() {
        return kl_idProperty;
    }

    public String getKl_imieProperty() {
        return kl_imieProperty.get();
    }

    public StringProperty getKlientImie() {
        return kl_imieProperty;
    }

    public void setKl_imieProperty(String kl_imieProperty) {
        this.kl_imieProperty.set(kl_imieProperty);
    }

    public String getKl_nazwiskoProperty() {
        return kl_nazwiskoProperty.get();
    }

    public StringProperty getKlientNazwisko() {
        return kl_nazwiskoProperty;
    }

    public void setKl_nazwiskoProperty(String kl_nazwiskoProperty) {
        this.kl_nazwiskoProperty.set(kl_nazwiskoProperty);
    }

    public String getKl_miejscowoscProperty() {
        return kl_miejscowoscProperty.get();
    }

    public StringProperty getKlientMiejscowosc() {
        return kl_miejscowoscProperty;
    }

    public void setKl_miejscowoscProperty(String kl_miejscowoscProperty) {
        this.kl_miejscowoscProperty.set(kl_miejscowoscProperty);
    }

    public String getKl_ulicaProperty() {
        return kl_ulicaProperty.get();
    }

    public StringProperty getKlientUlica() {
        return kl_ulicaProperty;
    }

    public void setKl_ulicaProperty(String kl_ulicaProperty) {
        this.kl_ulicaProperty.set(kl_ulicaProperty);
    }

    public String getKl_nrMieszkaniaProperty() {
        return kl_nrMieszkaniaProperty.get();
    }

    public StringProperty getKlientnrMieszkania() {
        return kl_nrMieszkaniaProperty;
    }

    public void setKl_nrMieszkaniaProperty(String kl_nrMieszkaniaProperty) {
        this.kl_nrMieszkaniaProperty.set(kl_nrMieszkaniaProperty);
    }

    public int getKl_nrTelefonuProperty() {
        return kl_nrTelefonuProperty.get();
    }

    public IntegerProperty getKlientnrTelefonu() {
        return kl_nrTelefonuProperty;
    }

    public void setKl_nrTelefonuProperty(int kl_nrTelefonuProperty) {
        this.kl_nrTelefonuProperty.set(kl_nrTelefonuProperty);
    }

    public String getKliEmail() {
        return kl_emailProperty.get();
    }

    public StringProperty getKlientEmail() {
        return kl_emailProperty;
    }

    public void setKl_emailProperty(String email) {
        this.kl_emailProperty.set(email);
    }
}
