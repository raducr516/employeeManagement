package proiect.employeeManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Integer> {
    List<Angajat> findByNumeAndPrenumeIgnoreCase(String nume, String prenume);
    List<Angajat> findByAngajatTrue();
}
