package med.voll.api.domain.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
@Entity(name = "patient")
@Table(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    private String cpf;
    @Embedded
    private Address address;
    private Boolean active;


    public Patient(PatientRegisterData data){
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.phonenumber = data.phonenumber();
        this.address = new Address(data.address());
    }

    public void udpateInfo(PatientUpdateData data) {
        if(data.name() != null) {
            this.name = data.name();
        }
        if(data.phonenumber() != null){
            this.phonenumber = data.phonenumber();
        }
        if (data.address() != null){
            this.address.updateInfo(data.address());
        }
        if(data.email() != null){
            this.email = data.email();
        }
    }

    public void delete() {
        this.active = false;
    }
}
