package med.voll.api.domain.appointments;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.doctors.Specialty;

import java.time.LocalDateTime;

public record ScheduleAppointmentData (
            Long doctorId,

            @NotNull
            Long patientId,

            @NotNull
            @Future
            LocalDateTime data,

            Specialty specialty) {

}
