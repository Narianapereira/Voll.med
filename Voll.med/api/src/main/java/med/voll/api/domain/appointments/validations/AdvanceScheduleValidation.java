package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.infra.ValidateException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AdvanceScheduleValidation implements AppointmentScheduleValidator{

    public void validate(ScheduleAppointmentData data){

        LocalDateTime scheduleHour = data.date();
        LocalDateTime now = LocalDateTime.now();
        long differenceInMin = Duration.between(scheduleHour, now).toMinutes();
        if(differenceInMin < 30){
            throw new ValidateException("Antecedência deve ser de 30 minutos");
        }
    }
}
