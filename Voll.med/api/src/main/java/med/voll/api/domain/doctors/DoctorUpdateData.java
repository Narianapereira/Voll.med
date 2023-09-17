package med.voll.api.domain.doctors;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressRegisterData;

public record DoctorUpdateData(@NotNull Long id, String name, String phonenumber, AddressRegisterData address) {
}
