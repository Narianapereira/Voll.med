package med.voll.api.domain.appointments;

import med.voll.api.domain.doctors.Doctor;
import med.voll.api.domain.doctors.DoctorRepository;
import med.voll.api.domain.patients.Patient;
import med.voll.api.domain.patients.PatientRepository;
import med.voll.api.infra.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentScheduleService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository docRep;

    @Autowired
    private PatientRepository patRep;


    public void schedule(ScheduleAppointmentData data) throws ValidateException {
        if(!patRep.existsById(data.patientId())){
            throw new ValidateException("Id do paciente não existe");
        }

        if(data.doctorId() != null && !docRep.existsById(data.doctorId())){
            throw new ValidateException("Id do paciente não existe");
        }

        Doctor doctor = chooseDoctor(data);
        Patient patient = patRep.getReferenceById(data.patientId());

        Appointment appointment = new Appointment(null, doctor, patient, data.date(),null);

        appointmentRepository.save(appointment);
    }

    private Doctor chooseDoctor(ScheduleAppointmentData data) {
        if(data.doctorId() != null){
           return docRep.getReferenceById(data.doctorId());
        }

        if(data.specialty() == null){
            throw new ValidateException("Specialty is mandatory");
        }

        return docRep.chooseRandomDoctorBySpecialtyAndDate(data.specialty(), data.date());

    }

    public void cancel(AppointmentCancelData data) {
        if(!appointmentRepository.existsById(data.appointmentId())){
            throw new ValidateException("Appointment must exists");
        }

        Appointment appointment = appointmentRepository.getReferenceById(data.appointmentId());
        validateCancelation(data, appointment);

        appointment.cancel(data.reason());
        appointmentRepository.save(appointment);

    }

    private void validateCancelation(AppointmentCancelData data, Appointment appointment) {

        Duration duration = Duration.between(appointment.getDate(), LocalDateTime.now());
        if (duration.toHours() > 24) {
            throw new ValidateException("Cancelations can only occur until 24 hours of " +
                    "the appointment.");
        }

    }


}
