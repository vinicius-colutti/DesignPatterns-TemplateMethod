package com.colutti.designpatterns.templateMethod.controller;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.colutti.designpatterns.templateMethod.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private Calculator calculator;

    @Autowired
    public BudgetController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping
    public BigDecimal discountCalculate(@RequestBody Budget budget){
        return calculator.calculateDiscount(budget);
    }

}
