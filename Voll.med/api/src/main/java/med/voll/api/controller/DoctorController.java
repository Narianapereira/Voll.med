package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorRepository;
import med.voll.api.doctors.DoctorResgisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
