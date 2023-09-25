package med.voll.api.domain.appointments;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.domain.doctors.Doctor;
import med.voll.api.domain.patients.Patient;

import java.time.LocalDateTime;

@Table(name = "appointment")
@Entity(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime date;

    @Column(name = "appointment_reason")
    @Enumerated(EnumType.STRING)
    private AppointmentCancelationReason reason;

    public void cancel(AppointmentCancelationReason reason) {
        this.reason = reason;
    }



    public Appointment(Appointment appointment){
        this.id = appointment.id;
        this.doc = appointment.doc;
        this.date = appointment.date;
        this.reason = appointment.reason;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoc() {
        return doc;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDate() {
        return date;
    }
}

