package com.infiniteskills.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stock")
public final class Stock extends Investment {
    @Id
    @GeneratedValue
    @Column(name = "STOCK_ID")
    private Long stockId;

    @Column(name = "SHARE_PRICE")
    private BigDecimal sharePrice;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

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
