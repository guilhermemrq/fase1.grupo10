package br.com.fiap.techchallenge.fase1.grupo10.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDto(@NotBlank(message = "A senha atual é obrigatória")String currentPassword, @NotBlank(message = "A nova senha é obrigatória")String newPassword) {
}
