package ru.bcs.computetest.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcs.computetest.model.Portfolio;
import ru.bcs.computetest.model.exception.NotFoundException;
import ru.bcs.computetest.service.PortfolioService;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;

    }

    @GetMapping
    public Collection<Portfolio> get() {
        Collection<Portfolio> result = portfolioService.getAll();

        if (CollectionUtils.isEmpty(result)) {
            return Collections.emptyList();
        }

        return result;
    }

    @GetMapping("{id}")
    public Portfolio getById(@PathVariable("id") final String id) {
        final Portfolio result = portfolioService.get(id);
        if (Objects.isNull(result)) {
            throw new NotFoundException("Not found!");
        }
        return result;
    }
}
