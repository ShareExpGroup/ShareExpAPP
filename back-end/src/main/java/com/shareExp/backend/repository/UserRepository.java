package com.shareExp.backend.repository;

import com.shareExp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<T> findByEmail(String email);
    Optional<T> findById(long id);
    List<T> findByFirstNameAndLastName(String firstName, String lastName);
    boolean deleteByEmail(String email);
    boolean existsByEmail(String email);
}
