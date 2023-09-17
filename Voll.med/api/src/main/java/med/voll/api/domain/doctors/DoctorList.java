package med.voll.api.domain.doctors;

public record DoctorList(Long id, String name, String crm, String email, Specialty specialty) {

    public DoctorList(Doctor doc){
        this(doc.getId(), doc.getName(),doc.getCrm(), doc.getEmail(), doc.getSpecialty());
    }
}
