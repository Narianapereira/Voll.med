package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.domain.patients.Patient;
import med.voll.api.domain.patients.PatientRepository;
import med.voll.api.infra.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class InactivePatientValidation implements AppointmentScheduleValidator{

    @Autowired
    private PatientRepository repository;

    public void validate(ScheduleAppointmentData data){
        Patient patient = repository.getReferenceById(data.patientId());

        if(!patient.getActive()){
            throw new ValidateException("Paciente deve ser ativo");
        }
    }
}
