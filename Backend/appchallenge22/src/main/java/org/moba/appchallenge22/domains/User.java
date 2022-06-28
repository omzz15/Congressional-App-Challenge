package org.moba.appchallenge22.domains;

import com.sun.istack.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;

import javax.persistence.*;

@Entity
public class User implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;

    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    private String phoneNumber;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
