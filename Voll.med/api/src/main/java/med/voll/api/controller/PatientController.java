package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorUpdateData;
import med.voll.api.patients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void registerPatients(@RequestBody @Valid PatientRegisterData data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientList> getAll(@PageableDefault(sort={"name"}, size=10) Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(PatientList::new);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdateData data) {
        Patient pat = repository.getReferenceById(data.id());
        pat.udpateInfo(data);
    }
    @DeleteMapping
    @Transactional
    @RequestMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        Patient pat = repository.getReferenceById(id);
        pat.delete();
    }
}
