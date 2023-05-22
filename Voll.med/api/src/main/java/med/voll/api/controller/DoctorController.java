package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorList;
import med.voll.api.doctors.DoctorRepository;
import med.voll.api.doctors.DoctorResgisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid DoctorResgisterData data){
        repository.save(new Doctor(data));
    }

    @GetMapping
    //@RequestMapping("/list")
    public Page<DoctorList> getAll(@PageableDefault(size=10, sort={"name"}) Pageable pagination){
        return repository.findAll(pagination).map(DoctorList::new);
    }
}
