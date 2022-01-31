package com.colutti.designpatterns.templateMethod.service.impl;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.colutti.designpatterns.templateMethod.service.ADiscount;
import com.colutti.designpatterns.templateMethod.service.Calculator;
import com.colutti.designpatterns.templateMethod.service.exte.DiscountForBudgetWithMoreOfFiveItems;
import com.colutti.designpatterns.templateMethod.service.exte.DiscountForBudgetWithValueLargerWhichFiveHundred;
import com.colutti.designpatterns.templateMethod.service.exte.WithoutDiscount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorImpl implements Calculator {
    @Override
    public BigDecimal calculateDiscount(Budget budget) {
        ADiscount discount = new DiscountForBudgetWithValueLargerWhichFiveHundred(
                new DiscountForBudgetWithMoreOfFiveItems(
                        new WithoutDiscount()
                )
        );
        return discount.calculate(budget);
    }
}
