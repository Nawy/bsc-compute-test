package ru.bcs.computetest.model;

import ru.bcs.computetest.model.enums.PositionType;

import java.math.BigDecimal;

public class Position {
    private String name;
    private PositionType type;
    private BigDecimal valueTO;
    private BigDecimal valueTN;

    public Position(String name, PositionType type, BigDecimal valueTO, BigDecimal valueTN) {
        this.name = name;
        this.type = type;
        this.valueTO = valueTO;
        this.valueTN = valueTN;
    }

    public String getName() {
        return name;
    }

    public PositionType getType() {
        return type;
    }

    public BigDecimal getValueTO() {
        return valueTO;
    }

    public BigDecimal getValueTN() {
        return valueTN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PositionType type) {
        this.type = type;
    }

    public void setValueTO(BigDecimal valueTO) {
        this.valueTO = valueTO;
    }

    public void setValueTN(BigDecimal valueTN) {
        this.valueTN = valueTN;
    }
}
