package med.voll.api.doctors;

import med.voll.api.address.Address;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.Specialty;

public record DoctorDetailData(Long id, String name, String email, String crm,
                               String phonenumber, Specialty specialty, Address address) {

    public DoctorDetailData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhonenumber(),
                doctor.getSpecialty(), doctor.getAddress());
    }
}
