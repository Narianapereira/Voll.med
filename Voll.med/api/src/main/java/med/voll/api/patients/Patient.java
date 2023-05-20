package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
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


    public Patient(PatientRegisterData data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.phonenumber = data.phonenumber();
        this.address = new Address(data.address());
    }
}
