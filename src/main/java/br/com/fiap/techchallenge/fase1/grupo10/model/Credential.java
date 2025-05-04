package br.com.fiap.techchallenge.fase1.grupo10.model;

import br.com.fiap.techchallenge.fase1.grupo10.dto.ChangePasswordRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.dto.LoginRequestDto;

public class Credential {
    private Long id;
    private String userName;
    private String password;
    private String newPassword;

    public Credential(LoginRequestDto loginRequestDto) {
        this.id = loginRequestDto.id();
        this.userName = loginRequestDto.username();
        this.password = loginRequestDto.password();
    }
    public Credential(Long id, ChangePasswordRequestDto changePasswordRequestDto) {
        this.id = id;
        this.password = changePasswordRequestDto.currentPassword();
        this.newPassword = changePasswordRequestDto.newPassword();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public String getNewPassword() { return newPassword; }
}
