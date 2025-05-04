package br.com.fiap.techchallenge.fase1.grupo10.service;

import br.com.fiap.techchallenge.fase1.grupo10.model.Credential;
import br.com.fiap.techchallenge.fase1.grupo10.model.User;
import br.com.fiap.techchallenge.fase1.grupo10.exception.CredentialFailException;
import br.com.fiap.techchallenge.fase1.grupo10.exception.UserNotFoundException;
import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity.UserEntity;
import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public String login(Credential credential) {
        UserEntity user = getUserById(credential.getId());
        validatePassword(credential.getPassword(), user.getPassword());
        return "Login realizado com sucesso.";
    }

    @Override
    public String changePassword(Credential credential) {
        UserEntity userEntity = getUserById(credential.getId());
        validatePassword(credential.getPassword(), userEntity.getPassword());

        String newPasswordHash = passwordEncoder.encode(credential.getNewPassword());
        User updatedUser = new User(userEntity, newPasswordHash);
        userRepository.save(new UserEntity(userEntity.getId(), updatedUser));

        return "Senha alterada com sucesso!";
    }
    private UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private void validatePassword(String rawPassword, String encodedCurrentPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedCurrentPassword)) {
            throw new CredentialFailException();
        }
    }
}
