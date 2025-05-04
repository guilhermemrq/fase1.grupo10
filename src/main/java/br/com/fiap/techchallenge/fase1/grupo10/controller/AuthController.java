package br.com.fiap.techchallenge.fase1.grupo10.controller;

import br.com.fiap.techchallenge.fase1.grupo10.model.Credential;
import br.com.fiap.techchallenge.fase1.grupo10.dto.ChangePasswordRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.dto.LoginRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final LoginService loginService;

    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        String mensage = this.loginService.login(new Credential(loginRequest));
        return ResponseEntity.ok(mensage);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(@PathVariable Long id,
                                                 @RequestBody ChangePasswordRequestDto changePassordRequestDto) {
        String mensage = this.loginService.changePassword(new Credential(id, changePassordRequestDto));
        return ResponseEntity.ok(mensage);
    }
}
