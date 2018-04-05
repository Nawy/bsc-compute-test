package ru.bcs.computetest.service;

import org.springframework.stereotype.Service;
import ru.bcs.computetest.model.Portfolio;
import ru.bcs.computetest.model.Position;
import ru.bcs.computetest.model.enums.PositionType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PortfolioService {

    private final Map<String, Portfolio> portfolioMap = new HashMap<>();

    public PortfolioService() {
        Portfolio portfolio1 = new Portfolio(
                "1212",
                Arrays.asList(
                        new Position(
                                "RUB",
                                PositionType.CURRENCY,
                                BigDecimal.ZERO,
                                BigDecimal.ZERO
                        ),
                        new Position(
                                "XDDR",
                                PositionType.SECURITY,
                                BigDecimal.ZERO,
                                BigDecimal.TEN
                        )
                )
        );

        Portfolio portfolio2 = new Portfolio(
                "1213",
                Arrays.asList(
                        new Position(
                                "RUB",
                                PositionType.CURRENCY,
                                BigDecimal.ZERO,
                                BigDecimal.TEN
                        ),
                        new Position(
                                "XDDR",
                                PositionType.SECURITY,
                                BigDecimal.ZERO,
                                BigDecimal.ZERO
                        )
                )
        );

        portfolioMap.put(portfolio1.getAccount(), portfolio1);
        portfolioMap.put(portfolio2.getAccount(), portfolio2);
    }

    public Portfolio get(final String account) {
        return portfolioMap.get(account);
    }

    public Collection<Portfolio> getAll() {
        return portfolioMap.values();
    }


    public void save(final Portfolio portfolio) {
        portfolioMap.put(portfolio.getAccount(), portfolio);
    }


}
