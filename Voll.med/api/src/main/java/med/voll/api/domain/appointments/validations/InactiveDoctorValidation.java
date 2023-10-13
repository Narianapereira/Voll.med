package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.domain.doctors.Doctor;
import med.voll.api.domain.doctors.DoctorRepository;
import med.voll.api.infra.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class InactiveDoctorValidation implements AppointmentScheduleValidator{

    @Autowired
    private DoctorRepository repository;

    public void validate(ScheduleAppointmentData data){

        Doctor doc = repository.getReferenceById(data.doctorId());
        if(!doc.getActive()){
            throw new ValidateException("Médico deve estar ativo");
        }

    }
}
