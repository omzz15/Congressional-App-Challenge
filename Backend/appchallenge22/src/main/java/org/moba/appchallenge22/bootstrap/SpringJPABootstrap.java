package org.moba.appchallenge22.bootstrap;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.moba.appchallenge22.domains.account.Account;
import org.moba.appchallenge22.domains.card.Card;
import org.moba.appchallenge22.domains.issue.Issue;
import org.moba.appchallenge22.services.AccountService;
import org.moba.appchallenge22.services.CardService;
import org.moba.appchallenge22.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
@Profile("test")
public class SpringJPABootstrap implements ApplicationListener<ApplicationReadyEvent> {

    AccountService accountService;

    IssueService issueService;

    CardService cardService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        loadAccountData();
        loadIssueData();
        loadCardData();
    }


    private void loadAccountData() {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Account a = new Account();

            Name n = faker.name();
            a.getInfo().getName().setFirstName(n.firstName());
            a.getInfo().getName().setLastName(n.lastName());
            a.getInfo().setUsername(n.username());

            a.getInfo().setEmail(faker.internet().emailAddress());
            a.getInfo().setPhoneNumber(faker.phoneNumber().phoneNumber());

            accountService.addOrUpdate(a);
        }
    }

    private void loadIssueData(){
        Faker faker = new Faker();
        for(int i = 0; i < 500; i++){
            Issue issue = new Issue();

            issue.getInfo().setTitle(faker.book().title());
            issue.getInfo().setDescription(faker.shakespeare().hamletQuote());
            issue.getInfo().setType("test");
            issue.getInfo().setGoal(new BigDecimal(4.34));

            issue.setOwnerId(generateRandomID());

            issueService.addOrUpdate(issue);
        }
    }

    private void loadCardData(){
        for(int i = 0; i < 500; i++){
            Card card = new Card();

            card.setOwner(accountService.getById(generateRandomID()));

            cardService.addOrUpdate(card);
        }
    }

    private Long generateRandomID(){
        return (long)(Math.random() * 100) + 1;
    }
}
