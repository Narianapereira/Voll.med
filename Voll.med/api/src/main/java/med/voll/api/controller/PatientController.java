package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.patients.Patient;
import med.voll.api.domain.patients.PatientList;
import med.voll.api.domain.patients.PatientRepository;
import med.voll.api.domain.patients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatients(@RequestBody @Valid PatientRegisterData data, UriComponentsBuilder componentsBuilder) {
        var patient = new Patient(data);
        repository.save(patient);
        var uri = componentsBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientList>> getAll(@PageableDefault(sort={"name"}, size=10) Pageable pagination){
        var page = repository.findAllByActiveTrue(pagination).map(PatientList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateData data) {
        Patient pat = repository.getReferenceById(data.id());
        pat.udpateInfo(data);
        return ResponseEntity.ok(new PatientDetailData(pat));
    }
    @DeleteMapping
    @Transactional
    @RequestMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        Patient pat = repository.getReferenceById(id);
        pat.delete();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detailPatient(@PathVariable Long id){
        Patient pat = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailData(pat));
    }
}
