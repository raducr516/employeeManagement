package proiect.employeeManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class managerAngajat {
    @Autowired
    private AngajatRepository angajatiRepository;

    public Angajat addAngajat(Angajat angajat) {
        return angajatiRepository.save(angajat);
    }
    public Iterable<Angajat> getAllAngajati() {
        return angajatiRepository.findByAngajatTrue();
    }
    public boolean deleteAngajat(int id) {
        Optional<Angajat> optionalAngajat = angajatiRepository.findById(id);
        if (optionalAngajat.isPresent()) {
            Angajat angajat = optionalAngajat.get();
            angajat.setAngajat(false);
            angajatiRepository.save(angajat);
        }
        return false;
    }

    public Angajat adaugaAngajat(Angajat angajat) {
        return angajatiRepository.save(angajat);
    }
    public Angajat updateAngajat(int id, UpdateAngajatRequest updateAngajatRequest) {
        Optional<Angajat> optionalAngajat = angajatiRepository.findById(id);


        if (optionalAngajat.isPresent()) {
            Angajat angajat = optionalAngajat.get();

            if (updateAngajatRequest.getNume() != null) angajat.setNume(updateAngajatRequest.getNume());
            if (updateAngajatRequest.getPrenume() != null) angajat.setPrenume(updateAngajatRequest.getPrenume());
            if (updateAngajatRequest.getNrDeTelefon() != null) angajat.setNrDeTelefon(updateAngajatRequest.getNrDeTelefon());
            if (updateAngajatRequest.getSalariu() != null) angajat.setSalariu(updateAngajatRequest.getSalariu());
            if (updateAngajatRequest.getDepartament() != null) angajat.setDepartament(updateAngajatRequest.getDepartament());
            if (updateAngajatRequest.getPost() != null) angajat.setPost(updateAngajatRequest.getPost());
            angajat.setAngajat(updateAngajatRequest.getAngajat());
            return angajatiRepository.save(angajat);
        }
        return null;
    }


    public Iterable<Angajat> searchAngajat(String nume, String prenume) {
        return angajatiRepository.findByNumeAndPrenumeIgnoreCase(nume, prenume);
    }


}

