package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Zamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zam_numer;

    @Column
    private LocalDate zam_data;

    @ManyToOne
    @JoinColumn(name = "kl_id",referencedColumnName = "kl_id")
    private Klienci kl_id;

    public Zamowienia(int zam_numer, LocalDate zam_data, Klienci kl_id) {
        this.zam_numer = zam_numer;
        this.zam_data = zam_data;
        this.kl_id = kl_id;
    }

    public Zamowienia() {
    }

    public int getZam_numer() {
        return zam_numer;
    }

    public void setZam_numer(int zam_numer) {
        this.zam_numer = zam_numer;
    }

    public LocalDate getZam_data() {
        return zam_data;
    }

    public void setZam_data(LocalDate zam_data) {
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
}
