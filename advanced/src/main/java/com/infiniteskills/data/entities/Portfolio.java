package com.infiniteskills.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "portfolio")
public final class Portfolio {
    @Id
    @GeneratedValue
    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "portfolio")
    private List<Investment> investements = new ArrayList<>();

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Investment> getInvestements() {
        return investements;
    }

}
