package proiect.employeeManagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class comenziAngajat {

    private final managerAngajat manageAngajati;
    public comenziAngajat(managerAngajat manageAngajati) {
        this.manageAngajati = manageAngajati;
    }


    @PostMapping("/addAngajat") // adauga un angajat in baza de date
    public ResponseEntity<String> addAngajat(@RequestBody Angajat angajat) {
        manageAngajati.addAngajat(angajat);
        return ResponseEntity.status(200).body("Angajat adaugat cu succes");
    }


    @GetMapping("/angajati") // afiseaza toti angajati activi
    public ResponseEntity<Iterable<Angajat>> getAllAngajati() {
        Iterable<Angajat> angajati = manageAngajati.getAllAngajati();
        return ResponseEntity.ok(angajati);
    }

    @DeleteMapping("/deleteAngajat/{id}") // marcheaza angajatul ca si cum a fost dat afara
    public ResponseEntity<String> deleteAngajat(@PathVariable int id) {
        return manageAngajati.deleteAngajat(id) ? ResponseEntity.status(200).body("Angajatul a fost marcat ca si dat afara") : ResponseEntity.status(404).body("Angajatul nu mai lucreaza deja");
    }


    @PutMapping("/updateAngajat/{id}") // modifica datele angajatilor cu posibilitatea de a marca ca reangajat un fost angajat
    public ResponseEntity<String> updateAngajat(
            @PathVariable int id,
            @RequestBody UpdateAngajatRequest updateAngajatRequest
    ) {
        Angajat updatedAngajat = manageAngajati.updateAngajat(id, updateAngajatRequest);

        if (updatedAngajat != null) {
            return ResponseEntity.status(200).body("Datele angajatului au fost modificate cu succes");
        } else {
            return ResponseEntity.status(404).body("Angajatul nu exista");
        }
    }

    @PostMapping("/searchAngajat") // cauta si afiseaza angajatii care inca lucreaza dar si cei dati afara
    public ResponseEntity<Iterable<Angajat>> searchAngajati(@RequestBody SearchAngajatRequest request) {
        Iterable<Angajat> angajati = manageAngajati.searchAngajat(request.getNume(), request.getPrenume());
        if (angajati != null) {
            return ResponseEntity.ok(angajati);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
