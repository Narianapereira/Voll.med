package med.voll.api.doctors;

public record DoctorList(Long id, String name, String crm, String email, Specialty specialty) {

    public DoctorList(Doctor doc){
        this(doc.getId(), doc.getName(),doc.getCrm(), doc.getEmail(), doc.getSpecialty());
    }
}
