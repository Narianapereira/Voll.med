package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.patients.Patient;
import med.voll.api.patients.PatientList;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.PatientRepository;
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
        return repository.findAll(pagination).map(PatientList::new);
    }
}
