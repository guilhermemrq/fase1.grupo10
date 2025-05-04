package br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity;

import br.com.fiap.techchallenge.fase1.grupo10.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private LocalDate dateLastChange;
    @Embedded
    private AddressEmbeddable address;

    public UserEntity(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.dateLastChange = user.getDateLastChange();
        this.address = new AddressEmbeddable(user.getAddress());
    }

    public UserEntity() {

    }

    public UserEntity(Long id, User user) {
        this(user);
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public AddressEmbeddable getAddress() {
        return address;
    }

}
