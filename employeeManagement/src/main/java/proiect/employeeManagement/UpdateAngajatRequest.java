package proiect.employeeManagement;

public class UpdateAngajatRequest {
    private String nume;
    private String prenume;
    private String nrDeTelefon;
    private String salariu;
    private String departament;
    private String post;
    private boolean angajat;

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

