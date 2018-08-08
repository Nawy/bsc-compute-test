package ru.bcs.computetest.service;

import org.springframework.stereotype.Service;
import ru.bcs.computetest.model.Deal;
import ru.bcs.computetest.model.Portfolio;
import ru.bcs.computetest.model.Position;
import ru.bcs.computetest.model.enums.DealType;
import ru.bcs.computetest.model.enums.PositionType;
import ru.bcs.computetest.model.exception.NotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class ComputeService {

    private final PortfolioService portfolioService;

    public ComputeService(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public void compute(final Deal deal, boolean isInvert) {

        final Portfolio portfolio = portfolioService.get(deal.getAccount());
        if (Objects.isNull(portfolio)) {
            throw new NotFoundException("Cannot find position");
        }

        final List<Position> positions = portfolio.getPositions();

        final Position currency = positions.stream().filter(findCurrency()).findFirst().orElseGet(null);
        final Position security = positions.stream().filter(findSecurity()).findFirst().orElseGet(null);

        final Portfolio resultPortfolio = computeCommon(portfolio, security, currency, deal, isInvert);
        portfolioService.save(resultPortfolio);
    }

    private Portfolio computeCommon(
            Portfolio portfolio,
            Position security,
            Position currency,
            Deal deal,
            boolean isInvert
    ) {
        final DealType dealType = isInvert ? invertDeal(deal.getType()) : deal.getType();

        switch (dealType) {
            case SELL: {
                security.setValueTN(security.getValueTN().subtract(deal.getSecuritySum()));
                currency.setValueTN(currency.getValueTN().add(deal.getCurrencySum()));
                break;
            }
            case BUY: {
                security.setValueTN(security.getValueTN().add(deal.getSecuritySum()));
                currency.setValueTN(currency.getValueTN().subtract(deal.getCurrencySum()));
                break;
            }
            default: throw new IllegalStateException();
        }

        final List<Position> positions = Arrays.asList(security, currency);
        return new Portfolio(portfolio.getAccount(), positions);
    }

    private DealType invertDeal(DealType dealType) {
        return dealType == DealType.BUY ? DealType.SELL : DealType.BUY;
    }

    private Predicate<Position> findCurrency() {
        return p -> p.getType().equals(PositionType.CURRENCY);
    }

    private Predicate<Position> findSecurity() {
        return p -> p.getType().equals(PositionType.SECURITY);
    }
}
