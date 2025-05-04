package br.com.fiap.techchallenge.fase1.grupo10.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Usuário não encontrado com id: " + id+ ".");
    }
}
