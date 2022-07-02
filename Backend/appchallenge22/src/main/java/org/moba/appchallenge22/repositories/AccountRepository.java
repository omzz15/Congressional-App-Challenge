package org.moba.appchallenge22.repositories;

import org.moba.appchallenge22.domains.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface AccountRepository<T extends Account, ID extends Serializable> extends JpaRepository<T, ID> {
    Optional<T> findByInfoEmail(String email);
}
