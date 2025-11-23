package com.kishanknows.backend.user.repository;

import com.kishanknows.backend.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
