package com.infiniteskills.data.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    @TableGenerator(table = "ifinances_keys", pkColumnName = "pk_name",
            valueColumnName = "pk_value", name = "key_generator")
    @Column(name = "INVESTMENT_ID")
    private Long investmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PORTFOLIO_ID")
    private Portfolio portfolio;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ISSUER")
    private String issuer;

    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
        portfolio.getInvestements().add(this);
    }
}
