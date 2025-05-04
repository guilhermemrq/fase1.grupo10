package br.com.fiap.techchallenge.fase1.grupo10.service;

import br.com.fiap.techchallenge.fase1.grupo10.model.Credential;

public interface LoginService {
    String login(Credential credential);
    String changePassword(Credential credential);
}
