package med.voll.api.domain.appointments.validations;

import med.voll.api.domain.appointments.ScheduleAppointmentData;

public interface AppointmentScheduleValidator {

    void validate(ScheduleAppointmentData data);
}
