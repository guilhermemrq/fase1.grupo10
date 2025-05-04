package br.com.fiap.techchallenge.fase1.grupo10.service;

import br.com.fiap.techchallenge.fase1.grupo10.model.User;
import br.com.fiap.techchallenge.fase1.grupo10.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void saveUser(UserRequestDto dto);

    User findByUserName(Long id);

    User findByEmail(String email);

    void delete(Long id);

    void update(UserRequestDto userRequestDto, Long id);
}
