package br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.repository;

import br.com.fiap.techchallenge.fase1.grupo10.infraestructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
