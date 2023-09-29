package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.Appointment;
import med.voll.api.domain.appointments.AppointmentRepository;
import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.infra.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RepeatedPatientValidation implements AppointmentScheduleValidator{

    @Autowired
    private AppointmentRepository repository;

    public void validate(ScheduleAppointmentData data){

    Appointment previousApp = repository.getTodayAppointmentByPatient(data.patientId(), data.date().getDayOfMonth());
    if(previousApp != null){
        throw new  ValidateException("não é possível agendar o paciente duas vezes no dia");
    }

    }
}
