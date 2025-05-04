package br.com.fiap.techchallenge.fase1.grupo10.exception;

public class CredentialFailException extends RuntimeException {
    public CredentialFailException() {
        super("Senha e/ou usuário não correspondem.");
    }
}
