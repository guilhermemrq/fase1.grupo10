package br.com.fiap.techchallenge.fase1.grupo10.model;

import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity.AddressEmbeddable;

public class Address {
    private String state;
    private String city;
    private String street;
    private String zipCode;

    public Address(AddressEmbeddable addressEmbeddable) {
        this.state = addressEmbeddable.getState();
        this.city = addressEmbeddable.getCity();
        this.street = addressEmbeddable.getStreet();
        this.zipCode = addressEmbeddable.getState();
    }

    public Address(String state, String city, String street, String zipcode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipcode;
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
