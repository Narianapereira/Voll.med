package med.voll.api.domain.doctors;

import med.voll.api.domain.address.Address;

public record DoctorDetailData(Long id, String name, String email, String crm,
                               String phonenumber, Specialty specialty, Address address) {

    public DoctorDetailData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhonenumber(),
                doctor.getSpecialty(), doctor.getAddress());
    }
}
