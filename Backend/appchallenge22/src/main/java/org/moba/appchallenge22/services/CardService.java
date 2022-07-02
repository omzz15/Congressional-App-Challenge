package org.moba.appchallenge22.services;

import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.domains.card.Card;
import org.moba.appchallenge22.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService extends CRUDServiceImpl<Card, Long, CardRepository<Card, Long>>{

    CardService(){
        super("Card");
    }

    @Override
    @Autowired
    public void setRepository(CardRepository<Card, Long> repository) {
        this.repository = repository;
    }

    public List<Card> getByOwner(Account owner){
        return repository.findByOwner(owner);
    }

    public List<Card> getByOwnerId(Long id){
        return repository.findByOwnerId(id);
    }
}
