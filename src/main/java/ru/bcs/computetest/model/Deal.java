package ru.bcs.computetest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bcs.computetest.model.enums.DealType;

import java.math.BigDecimal;

public class Deal {

    private String account;
    private DealType type;
    private BigDecimal securitySum;
    private BigDecimal currencySum;

    public Deal(
            @JsonProperty(value = "account", required = true) String account,
            @JsonProperty(value = "type", required = true) DealType type,
            @JsonProperty(value = "securitySum", required = true) BigDecimal securitySum,
            @JsonProperty(value = "currencySum", required = true) BigDecimal currencySum) {
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
