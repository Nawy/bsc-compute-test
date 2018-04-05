package ru.bcs.computetest.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcs.computetest.model.Deal;
import ru.bcs.computetest.service.ComputeService;

@RestController
@RequestMapping("/deal")
public class ComputeController {

    private final ComputeService computeService;

    public ComputeController(ComputeService computeService) {
        this.computeService = computeService;
    }

    @PostMapping
    public void deal(@RequestBody final Deal deal) {
        computeService.compute(deal, false);
    }

    @PostMapping("/inverted")
    public void dealInverted(@RequestBody final Deal deal) {
        computeService.compute(deal, true);
    }
}
