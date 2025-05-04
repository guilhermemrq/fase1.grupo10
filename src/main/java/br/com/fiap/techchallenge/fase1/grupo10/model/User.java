package br.com.fiap.techchallenge.fase1.grupo10.model;

import br.com.fiap.techchallenge.fase1.grupo10.dto.UserRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity.UserEntity;

import java.time.LocalDate;

public class User {
    private String name;
    private String email;
    private String username;
    private String password;
    private LocalDate dateLastChange;
    private Address address;

    public User(UserEntity entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.dateLastChange = entity.getDateLastChange();
        this.address = new Address(entity.getAddress());
    }

    public User(UserRequestDto userRequestDto, String encryptedPassword) {
        this(userRequestDto);
        changePassword(encryptedPassword);
    }

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.name();
        this.email = userRequestDto.email();
        this.username = userRequestDto.username();
        this.address = new Address(userRequestDto.state(), userRequestDto.city(), userRequestDto.street(), userRequestDto.zipCode());
    }

    public User(UserEntity userEntity, String encryptedPassword) {
        this(userEntity);
        changePassword(encryptedPassword);

    }

    private void changePassword(String encryptedPassword) {
        this.dateLastChange = LocalDate.now();
        this.password = encryptedPassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateLastChange() {
        return dateLastChange;
    }

    public Address getAddress() {
        return address;
    }

}
