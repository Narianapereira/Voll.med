package med.voll.api.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressRegisterData;

public record PatientUpdateData(@NotNull Long id, String name, String email, String phonenumber, AddressRegisterData address) {
}
