package br.com.fiap.techchallenge.fase1.grupo10.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto (@NotBlank(message = "O nome de usuário é obrigatório")String username, @NotBlank(message = "A senha é obrigatória")String password){
}
