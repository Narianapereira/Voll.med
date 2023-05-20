package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String state;
    private String extra;
    private String number;

    public Address(AddressRegisterData data) {
        this.street = data.street();
        this.number = data.number();
        this.cep = data.cep();
        this.neighborhood = data.neighborhood();
        this.city = data.city();
        this.extra = data.extra();
        this.state = data.state();
    }


}
