package med.voll.api.doctors;

public record DoctorList(String name, String crm, String email, Specialty specialty) {

    public DoctorList(Doctor doc){
        this(doc.getName(),doc.getCrm(), doc.getEmail(), doc.getSpecialty());
    }
}
