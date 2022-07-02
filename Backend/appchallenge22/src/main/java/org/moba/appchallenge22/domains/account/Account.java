package org.moba.appchallenge22.domains.account;

import org.moba.appchallenge22.domains.DomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Account implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @NotNull
    private AccountInfo info;

    public Account(){
        info = new AccountInfo();
    }

    public Account(Long id, Integer version, AccountInfo info) {
        this.id = id;
        this.version = version;
        this.info = info;
    }

    public Account(AccountInfo info) {
        this.info = info;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public AccountInfo getInfo() {
        return info;
    }

    public void setInfo(AccountInfo info) {
        this.info = info;
    }
}
