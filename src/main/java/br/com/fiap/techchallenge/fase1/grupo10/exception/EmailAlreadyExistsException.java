package br.com.fiap.techchallenge.fase1.grupo10.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Usuário ja cadastrado com email: " + email + ".");
    }
}
