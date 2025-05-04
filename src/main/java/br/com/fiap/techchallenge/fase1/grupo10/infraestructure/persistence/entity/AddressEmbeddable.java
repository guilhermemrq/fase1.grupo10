package br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity;

import br.com.fiap.techchallenge.fase1.grupo10.model.Address;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEmbeddable {
    private String state;
    private String city;
    private String street;
    private String zipCode;

    public AddressEmbeddable(Address address) {
        this.state = address.getState();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.zipCode = address.getZipCode();
    }

    public AddressEmbeddable() {

    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}
