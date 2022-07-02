package org.moba.appchallenge22.domains.issue;

import org.moba.appchallenge22.domains.DomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Issue implements DomainObject<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @NotNull
    private Long ownerId;
    @NotNull
    private IssueInfo info;

    public Issue(){
        info = new IssueInfo();
    }

    public Issue(Long id, Integer version, Long ownerId, IssueInfo info) {
        this.id = id;
        this.version = version;
        this.ownerId = ownerId;
        this.info = info;
    }

    public Issue(Long ownerId, IssueInfo info) {
        this.ownerId = ownerId;
        this.info = info;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public IssueInfo getInfo() {
        return info;
    }

    public void setInfo(IssueInfo info) {
        this.info = info;
    }
}
