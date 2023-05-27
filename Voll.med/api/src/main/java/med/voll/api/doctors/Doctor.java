package med.voll.api.doctors;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
@Table(name = "doctor")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Doctor(DoctorResgisterData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.specialty = data.specialty();
        this.crm = data.crm();
        this.address = new Address(data.address());
        this.phonenumber = data.phonenumber();
    }

    public void udpateInfo(DoctorUpdateData data) {
        if(data.name() != null) {
            this.name = data.name();
        }
        if(data.phonenumber() != null){
            this.phonenumber = data.phonenumber();
        }
        if (data.address() != null){
            this.address.updateInfo(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
