package com.infiniteskills.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "stock")
public final class Stock extends Investment {
    @Column(name = "SHARE_PRICE")
    private BigDecimal sharePrice;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
