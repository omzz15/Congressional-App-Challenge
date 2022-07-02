package org.moba.appchallenge22.controllers;

import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAll();
    }

    @GetMapping(path="{id}")
    public Account getAccountById(@PathVariable("id") Long id){
        return accountService.getById(id);
    }

    @GetMapping(params = "email")
    public Account getAccountByEmail(@RequestParam String email){
        return accountService.getByEmail(email);
    }

    @PostMapping
    public void addAccount(@RequestBody Account account){
        accountService.addOrUpdate(account);
    }
}
