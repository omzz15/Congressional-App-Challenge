package org.moba.appchallenge22.repositories;

import org.moba.appchallenge22.domains.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IssueRepository<T extends Issue, ID extends Serializable> extends JpaRepository<T, ID> {
    List<Issue> findByOwnerId(Long ownerId);
}
