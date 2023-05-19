package med.voll.api.address;

public record AddressData(String street, String neighborhood, String cep, String city,
                          String state, String extra, String number) {
}
