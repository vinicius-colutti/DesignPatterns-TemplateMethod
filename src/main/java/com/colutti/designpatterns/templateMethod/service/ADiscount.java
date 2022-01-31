package com.colutti.designpatterns.templateMethod.service;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import java.math.BigDecimal;

public abstract class ADiscount {

    protected ADiscount next;

    public ADiscount(ADiscount next) {
        this.next = next;
    }

    public BigDecimal calculate(Budget budget){
        if(mustApply(budget)){
            return makeCalc(budget);
        }
        return next.calculate(budget);
    }

    protected abstract BigDecimal makeCalc(Budget budget);
    protected abstract boolean mustApply(Budget budget);
}
