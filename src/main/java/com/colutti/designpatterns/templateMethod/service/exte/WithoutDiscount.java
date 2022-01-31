package com.colutti.designpatterns.templateMethod.service.exte;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.colutti.designpatterns.templateMethod.service.ADiscount;
import java.math.BigDecimal;

public class WithoutDiscount extends ADiscount {

    public WithoutDiscount() {
        super(null);
    }

    @Override
    public BigDecimal makeCalc(Budget budget) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean mustApply(Budget budget){
        return true;
    }

}
