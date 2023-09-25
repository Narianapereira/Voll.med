package med.voll.api.domain.appointments;

import jakarta.validation.constraints.NotNull;

public record AppointmentCancelData(@NotNull Long appointmentId, @NotNull AppointmentCancelationReason reason) {
}
