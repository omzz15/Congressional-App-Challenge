package org.moba.appchallenge22.services;

import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.domains.issue.Issue;
import org.moba.appchallenge22.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService extends CRUDServiceImpl<Issue, Long, IssueRepository<Issue, Long>>{

    public IssueService(){
        super("Issue");
    }

    @Autowired
    @Override
    public void setRepository(IssueRepository<Issue, Long> issueRepository) {
        this.repository = issueRepository;
    }

    public List<Issue> getByOwnerId(Long id){
        return repository.findByOwnerId(id);
    }

    public List<Issue> getByOwner(Account owner){
        return getByOwnerId(owner.getId());
    }
}
