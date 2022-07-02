package org.moba.appchallenge22.controllers;

import org.moba.appchallenge22.domains.card.Card;
import org.moba.appchallenge22.domains.issue.Issue;
import org.moba.appchallenge22.services.CardService;
import org.moba.appchallenge22.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    private IssueService issueService;

    private CardService cardService;

    @Autowired
    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "issue/{id}")
    public List<Issue> getByOwner(@PathVariable Long id){
        return issueService.getByOwnerId(id);
    }

    @GetMapping(path = "card/{id}")
    public List<Card> getCardByOwner(@PathVariable Long id){
        return cardService.getByOwnerId(id);
    }
}
