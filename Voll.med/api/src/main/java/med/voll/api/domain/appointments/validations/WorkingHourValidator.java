package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.infra.ValidateException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class WorkingHourValidator implements AppointmentScheduleValidator {

    public void validate(ScheduleAppointmentData data){

        LocalDateTime date = data.date();

        boolean sunday = date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean beforeOpeningHour = date.getHour() < 7;
        boolean afterClosingHour = date.getHour() > 18;

        if(sunday || beforeOpeningHour || afterClosingHour){
            throw new ValidateException("Agendamento da consulta deve estar dentro do hoŕario de " +
                    "funcionamento");
        }


    }
}
