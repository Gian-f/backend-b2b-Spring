package com.br.b2b.repository;

import com.br.b2b.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);


    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    User findUserByEmailIgnoreCase(String emailId);
}