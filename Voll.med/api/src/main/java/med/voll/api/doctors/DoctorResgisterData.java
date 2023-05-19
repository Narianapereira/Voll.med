package med.voll.api.doctors;

import med.voll.api.address.AddressData;

public record DoctorResgisterData(String name, String email, String crm, Specialty specialty, AddressData
                                  address) {

}