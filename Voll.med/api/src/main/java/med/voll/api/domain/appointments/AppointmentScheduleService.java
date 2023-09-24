package med.voll.api.domain.appointments;

import med.voll.api.domain.doctors.Doctor;
import med.voll.api.domain.doctors.DoctorRepository;
import med.voll.api.domain.patients.Patient;
import med.voll.api.domain.patients.PatientRepository;
import med.voll.api.infra.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentScheduleService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private DoctorRepository docRep;

    @Autowired
    private PatientRepository patRep;
    public void schedule(ScheduleAppointmentData data) throws ValidateException {
        if(!patRep.existsById(data.patientId())){
            throw new ValidateException("Id do paciente não existe");
        }

        if(data.doctorId() != null && !docRep.existsById(data.doctorId())){
            throw new ValidateException("Id do paciente não existe");
        }

        Doctor doctor = chooseDoctor(data);
        Patient patient = patRep.getReferenceById(data.patientId());

        Appointment appointment = new Appointment(null, doctor, patient, data.data());

        repository.save(appointment);
    }

    private Doctor chooseDoctor(ScheduleAppointmentData data) {
        if(data.doctorId() != null){
           return docRep.getReferenceById(data.doctorId());
        }

        if(data.specialty() == null){
            throw new ValidateException("Especialidade é obrigatória");
        }

        return docRep.chooseRandomDoctorBySpecialtyAndDate(data.specialty(), data.data());

    }
}
