package med.voll.api.patients;

public record PatientDetailData(Long id, String name, String email, String phonenumber, String cpf) {

    public PatientDetailData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhonenumber(),
                patient.getCpf());
    }
}
