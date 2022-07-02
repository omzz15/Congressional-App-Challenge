package org.moba.appchallenge22.domains.account;

import org.moba.appchallenge22.domains.Name;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class AccountInfo {
    @NotNull
    private Name name;
    @NotNull
    private String username;
    @NotNull
    private String email;
    private String phoneNumber;

    public AccountInfo(){
        name = new Name();
    }

    public AccountInfo(Name name, String username, String email, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
