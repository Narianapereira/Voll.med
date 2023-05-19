package med.voll.api.patients;

import med.voll.api.address.AddressData;
import med.voll.api.doctors.Specialty;

public record PatientRegisterData(String name, String email, String phonenumber, String cpf, AddressData
        address) {
}
