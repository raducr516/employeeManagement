package proiect.employeeManagement;

import jakarta.persistence.*;

@Entity
@Table(name = "angajati")
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nume;
    @Column(nullable = false)
    private String prenume;
    @Column(nullable = false)
    private String nrDeTelefon;
    @Column(nullable = false)
    private String salariu;
    @Column(nullable = false)
    private String departament;
    @Column(nullable = false)
    private String post;
    @Column(nullable = false)
    private boolean angajat;

    public Angajat(){}
    public Angajat(String nume, String prenume, String nrDeTelefon, String salariu, String departament, String post, boolean angajat) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrDeTelefon = nrDeTelefon;
        this.salariu = salariu;
        this.departament = departament;
        this.post = post;
        this.angajat = angajat;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNume() {
        return nume;
    }
    public String setNume(String nume) {
        return this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public String setPrenume(String prenume) {
        return this.prenume = prenume;
    }
    public String getNrDeTelefon() {
        return nrDeTelefon;
    }
    public String setNrDeTelefon(String nrDeTelefon) {
        return this.nrDeTelefon = nrDeTelefon;
    }
    public String getSalariu() {
        return salariu;
    }
    public String setSalariu(String salariu) {
        return this.salariu = salariu;
    }
    public String getDepartament() {
        return departament;
    }
    public String setDepartament(String departament) {
        return this.departament = departament;
    }
    public String getPost() {
        return post;
    }
    public String setPost(String post) {
        return this.post = post;
    }
    public boolean getAngajat() {
        return angajat;
    }
    public boolean setAngajat(boolean angajat) {
        return this.angajat = angajat;
    }
}
