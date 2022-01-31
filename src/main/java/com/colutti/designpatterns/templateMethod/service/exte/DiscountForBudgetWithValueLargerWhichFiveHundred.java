package com.colutti.designpatterns.templateMethod.service.exte;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.colutti.designpatterns.templateMethod.service.ADiscount;
import java.math.BigDecimal;

public class DiscountForBudgetWithValueLargerWhichFiveHundred extends ADiscount {

    public DiscountForBudgetWithValueLargerWhichFiveHundred(ADiscount next) {
        super(next);
    }

    @Override
    public BigDecimal makeCalc(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean mustApply(Budget budget){
        return budget.getValue().compareTo(new BigDecimal("500")) > 0;
    }

}
