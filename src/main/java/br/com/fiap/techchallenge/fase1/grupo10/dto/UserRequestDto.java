package br.com.fiap.techchallenge.fase1.grupo10.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,
        @NotBlank(message = "O nome de usuário é obrigatório")
        String username,
        @NotBlank(message = "A senha é obrigatória")
        String password,
        @NotBlank(message = "A rua é obrigatória")
        String street,
        @NotBlank(message = "A cidade é obrigatória")
        String city,
        @NotBlank(message = "O estado é obrigatório")
        @Size(min = 2, max = 2, message = "O estado deve conter 2 letras (UF)")
        String state,
        @NotBlank(message = "O CEP é obrigatório")
        @Size(min = 8, max = 8, message = "O CEP deve conter 8 dígitos")
        String zipCode
) {}
