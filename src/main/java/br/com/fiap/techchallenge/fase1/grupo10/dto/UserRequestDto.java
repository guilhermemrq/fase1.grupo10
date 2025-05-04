package br.com.fiap.techchallenge.fase1.grupo10.dto;

public record UserRequestDto(
        String name,
        String email,
        String username,
        String password,
        String street,
        String city,
        String state,
        String zipCode
) {}
