package hu.Tanarora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tanar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int kor;
    private String szak;
    @OneToMany(mappedBy = "tanar")
    @JsonIgnore
    private List<Ora> orak;

    public Tanar() {
    }

    public List<Ora> getOrak() {
        return orak;
    }

    public void setOrak(List<Ora> orak) {
        this.orak = orak;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    @Override
    public String toString() {
        return "Tanar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", szak='" + szak + '\'' +
                ", orak=" + orak +
                '}';
    }
}
