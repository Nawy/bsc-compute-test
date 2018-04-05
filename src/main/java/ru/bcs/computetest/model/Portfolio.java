package ru.bcs.computetest.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private String account;
    private List<Position> positions = new ArrayList<>();

    public Portfolio(String account, List<Position> positions) {
        this.account = account;
        this.positions = positions;
    }

    public String getAccount() {
        return account;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
