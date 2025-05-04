package br.com.fiap.techchallenge.fase1.grupo10.service;

import br.com.fiap.techchallenge.fase1.grupo10.model.User;
import br.com.fiap.techchallenge.fase1.grupo10.dto.UserRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.exception.EmailAlreadyExistsException;
import br.com.fiap.techchallenge.fase1.grupo10.exception.UserNotFoundException;
import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity.UserEntity;
import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(User::new)
                .toList();
    }

    @Override
    public User findByUserName(Long id) {
        return userRepository.findById(id)
                .map(User::new)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(User::new)
                .orElseThrow(() -> new EmailAlreadyExistsException(email));
    }

    @Override
    public void saveUser(UserRequestDto dto) {
        throwIfUserExistsByEmail(dto.email());
        String encryptedPassword = passwordEncoder.encode(dto.password());
        UserEntity userEntity = new UserEntity(new User(dto, encryptedPassword));
        userRepository.save(userEntity);
    }

    @Override
    public void update(UserRequestDto dto, Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        String encryptedPassword = passwordEncoder.encode(dto.password());
        UserEntity updatedUser = new UserEntity(id, new User(dto, encryptedPassword));
        userRepository.save(updatedUser);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    private void throwIfUserExistsByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }
    }
}
