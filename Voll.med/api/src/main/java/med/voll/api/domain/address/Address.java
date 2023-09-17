package med.voll.api.domain.address;

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


    public void updateInfo(AddressRegisterData data) {
        if (data.street() != null) {
            this.street = data.street();
        }
        if(data.state() != null) {
            this.state = data.state();
        }
        if(data.cep() != null) {
            this.cep = data.cep();
        }
        if(data.city() != null) {
            this.city = data.city();
        }
        if(data.number() != null) {
            this.number = data.number();
        }
        if(data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if(data.extra() != null) {
            this.extra = data.extra();
        }
    }
}
