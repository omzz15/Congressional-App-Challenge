package org.moba.appchallenge22.domains.card;

import org.moba.appchallenge22.domains.DomainObject;
import org.moba.appchallenge22.domains.account.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Card implements DomainObject<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Version
    Integer version;
    @OneToOne
    @NotNull
    Account owner;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
