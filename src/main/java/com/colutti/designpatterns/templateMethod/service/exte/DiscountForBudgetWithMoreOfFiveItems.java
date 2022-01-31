package com.colutti.designpatterns.templateMethod.service.exte;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.colutti.designpatterns.templateMethod.service.ADiscount;

import java.math.BigDecimal;

public class DiscountForBudgetWithMoreOfFiveItems extends ADiscount {

    public DiscountForBudgetWithMoreOfFiveItems(ADiscount next) {
        super(next);
    }

    @Override
    public BigDecimal makeCalc(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean mustApply(Budget budget){
        return budget.getQuantityItems() > 5;
    }
}
