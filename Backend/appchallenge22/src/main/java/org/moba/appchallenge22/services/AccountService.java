package org.moba.appchallenge22.services;

import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.domains.issue.Issue;
import org.moba.appchallenge22.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService extends CRUDServiceImpl<Account, Long, AccountRepository<Account, Long>>{

    public AccountService(){
        super("Account");
    }

    @Autowired
    @Override
    public void setRepository(AccountRepository<Account, Long> accountRepository) {
        this.repository = accountRepository;
    }

    @Override
    public void addOrUpdate(Account account){
        Optional<Account> email = repository.findByInfoEmail(account.getInfo().getEmail());
        if(email.isPresent() && !Objects.equals(email.get().getId(), account.getId())) throw new IllegalStateException("can not create or edit account because the email " + account.getInfo().getEmail() + " is already taken");
        super.addOrUpdate(account);
    }

    public Account getByEmail(String email){
        return repository.findByInfoEmail(email).orElseThrow(() -> new IllegalStateException("no account with email " + email));
    }

    public boolean isEmailTaken(String email){
        return repository.findByInfoEmail(email).isPresent();
    }
}
