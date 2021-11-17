package hu.Tanarora.domain;

import javax.persistence.*;

@Entity
public class Ora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String oraname;
    private String address;
    @ManyToOne
    private Tanar tanar;

    @Override
    public String toString() {
        return "Ora{" +
                "id=" + id +
                ", ora_name='" + oraname + '\'' +
                ", address='" + address + '\'' +
                ", tanar=" + tanar +
                '}';
    }

    public Ora() {
    }

    public Tanar getTanar() {
        return tanar;
    }

    public void setTanar(Tanar tanar) {
        this.tanar = tanar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOraname() {
        return oraname;
    }

    public void setOraname(String oraname) {
        this.oraname = oraname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
