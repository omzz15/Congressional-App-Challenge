package org.moba.appchallenge22.repositories;

import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.domains.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository<T extends Card, ID extends Serializable> extends JpaRepository<T, ID> {
    List<Card> findByOwner(Account owner);

    List<Card> findByOwnerId(Long id);
}
