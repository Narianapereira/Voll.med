package med.voll.api.domain.patients;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.AddressRegisterData;

public record PatientRegisterData(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String phonenumber,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotNull
        @Valid
        AddressRegisterData address) {
}
