package ru.bcs.computetest.model;

import ru.bcs.computetest.model.enums.DealType;

import java.math.BigDecimal;

public class Deal {

    private String account;
    private DealType type;
    private BigDecimal securitySum;
    private BigDecimal currencySum;

    public Deal(String account, DealType type, BigDecimal securitySum, BigDecimal currencySum) {
        this.account = account;
        this.type = type;
        this.securitySum = securitySum;
        this.currencySum = currencySum;
    }

    public String getAccount() {
        return account;
    }

    public DealType getType() {
        return type;
    }

    public BigDecimal getSecuritySum() {
        return securitySum;
    }

    public BigDecimal getCurrencySum() {
        return currencySum;
    }
}
