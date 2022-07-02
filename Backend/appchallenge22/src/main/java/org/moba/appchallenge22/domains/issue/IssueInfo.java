package org.moba.appchallenge22.domains.issue;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
public class IssueInfo{
    @NotNull
    private String title;
    private String description;
    @NotNull
    private String type;
    @NotNull
    private BigDecimal goal;

    public IssueInfo(){}

    public IssueInfo(String title, String description, String type, BigDecimal goal) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.goal = goal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }
}
