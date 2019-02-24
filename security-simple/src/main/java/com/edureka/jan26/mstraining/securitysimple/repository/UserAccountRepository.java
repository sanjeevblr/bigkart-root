package com.edureka.jan26.mstraining.securitysimple.repository;

import com.edureka.jan26.mstraining.securitysimple.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String username);
}
