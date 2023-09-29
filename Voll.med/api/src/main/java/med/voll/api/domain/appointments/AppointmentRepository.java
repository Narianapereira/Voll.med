package med.voll.api.domain.appointments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select m from appointment m where m.patient.id = :patientId and " +
            "m.date = :date")
    Appointment getTodayAppointmentByPatient(Long patientId, int date);
}
